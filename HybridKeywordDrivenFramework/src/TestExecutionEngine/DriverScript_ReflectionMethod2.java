package TestExecutionEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import KeywordActionLibrary.KeywordAction2;
import Utility.ExcelUtil;
import Utility.Propertie;

public class DriverScript_ReflectionMethod2 
{
	//public static KeywordAction keywordActions;
	public static KeywordAction2 keywordActions;
	public static String actionKeyword;
	public static Method methods[];
	
	static Logger log = Logger.getLogger(DriverScript_ReflectionMethod2.class);
	
	public void runReflectionMethod(String strClassName, String strMethodName, Object... inputArgs) 
	{
		Class<?> params[] = new Class[inputArgs.length];

		for (int i = 0; i < inputArgs.length; i++) 
		{
			if (inputArgs[i] instanceof String) 
			{
				params[i] = String.class;
			}
		}
		
		try 
		{
			Class<?> cls = Class.forName(strClassName);
			
			Object _instance = cls.newInstance();
			
			Method method = cls.getDeclaredMethod(strMethodName, params);
			
			//System.out.println(method);
			
			method.invoke(_instance, inputArgs);

		} catch (ClassNotFoundException e) {
			log.error(strClassName + ":- Class not found%n");
		} catch (IllegalArgumentException e) {
			log.error("Method invoked with wrong number of arguments%n");
		} catch (NoSuchMethodException e) {
			log.error("In Class " + strClassName + "::" + strMethodName + ":- method does not exists%n");
		} catch (InvocationTargetException e) {
			log.error("Exception thrown by an invoked method%n");
		} catch (IllegalAccessException e) {
			log.error("Can not access a member of class with modifiers private%n");
			e.printStackTrace();
		} catch (InstantiationException e) {
			log.error("Object cannot be instantiated for the specified class using the newInstance method%n");
			
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		
		ExcelUtil.setExcelFile(Propertie.testExcel_filePath, Propertie.testExcel_FileName, Propertie.testExcel_TestSuite_SheetName, Propertie.testExcel_TestCase_sheetName);
		
		DriverScript_ReflectionMethod2 startEngine = new DriverScript_ReflectionMethod2();
		
		log.info("Test Suite Row count: " + ExcelUtil.getRowCount(Propertie.testExcel_TestSuite_SheetName));
		
		for(int tsRow=1; tsRow<=ExcelUtil.getRowCount(Propertie.testExcel_TestSuite_SheetName)-1; tsRow++)
		{
			for(int tsCol=0; tsCol<=ExcelUtil.getColumnCount(Propertie.testExcel_TestSuite_SheetName); tsCol++)
			{
				//Checks Execution is YES in execution column in Excel. If YES then proceeds execution of Test Case.
				if(ExcelUtil.getCellData(tsRow, Propertie.Col_Execution, Propertie.testExcel_TestSuite_SheetName).equalsIgnoreCase("YES"))
				{
					log.info("Test Case Row Count: " + ExcelUtil.getRowCount(Propertie.testExcel_TestCase_sheetName));
					
					log.info("Started Executing Test Suite - Test Case ID:: " + ExcelUtil.getCellData(tsRow, Propertie.Col_TestCaseID, Propertie.testExcel_TestSuite_SheetName));
					
					for(int tcRow=1; tcRow<=ExcelUtil.getRowCount(Propertie.testExcel_TestCase_sheetName)-1; tcRow++)
					{
						//Checks Test Suite sheet Test Case ID and Test Case Sheet Test case ID are equal then proceeds excetion otherwise skips
						if(ExcelUtil.getCellData(tsRow, Propertie.Col_TestCaseID, Propertie.testExcel_TestSuite_SheetName).equalsIgnoreCase(ExcelUtil.getCellData(tcRow, Propertie.Col_TestCaseID, Propertie.testExcel_TestCase_sheetName)))
						{
							List<Object> paramList = new ArrayList<Object>(); //creates array list
							
							String methodName = ExcelUtil.getCellData(tcRow, 3, Propertie.testExcel_TestCase_sheetName); //gets method name from action keyword column
							
							//reads parameter list for method/action keyword
							for (int tcCol = 4; tcCol <= 6; tcCol++)
							{
								if (!ExcelUtil.getCellData(tcRow, tcCol, Propertie.testExcel_TestCase_sheetName).isEmpty() & !ExcelUtil.getCellData(tcRow, tcCol, Propertie.testExcel_TestCase_sheetName).equals("null")) 
								{
									paramList.add(ExcelUtil.getCellData(tcRow, tcCol, Propertie.testExcel_TestCase_sheetName)); //creates list
								}
							}

							Object[] paramListObject = new String[paramList.size()]; //creates object array
						
							paramListObject = paramList.toArray(paramListObject); //converts parameter list to array
							
							log.info("Executing Test Case ID :: " + ExcelUtil.getCellData(tcRow, Propertie.Col_TestCaseID, Propertie.testExcel_TestCase_sheetName) + ", Test Step ID :: " + ExcelUtil.getCellData(tcRow, Propertie.Col_TestStepID, Propertie.testExcel_TestCase_sheetName) + ", Test Descriptions :: " + ExcelUtil.getCellData(tcRow, Propertie.Col_TestStepDescription, Propertie.testExcel_TestCase_sheetName));
							
							startEngine.runReflectionMethod("KeywordActionLibrary.KeywordAction2", methodName, paramListObject);
						}
						
						
					}
				}
			}
		}
		
		

	}
}
