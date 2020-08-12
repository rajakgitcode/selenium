package TestExecutionEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;

import KeywordActionLibrary.KeywordAction;
import KeywordActionLibrary.KeywordAction2;
import Utility.ExcelUtil;
import Utility.Propertie;

public class DriverScript_ReflectionMethod 
{
	//public static KeywordAction keywordActions;
	public static KeywordAction2 keywordActions;
	public static String actionKeyword;
	public static Method methods[];
	
	
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
			System.out.println(method);
			method.invoke(_instance, inputArgs);

		} catch (ClassNotFoundException e) {
			System.err.format(strClassName + ":- Class not found%n");
		} catch (IllegalArgumentException e) {
			System.err.format("Method invoked with wrong number of arguments%n");
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			System.err.format("In Class " + strClassName + "::" + strMethodName + ":- method does not exists%n");
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
			System.err.format("Exception thrown by an invoked method%n");
		} catch (IllegalAccessException e) {
			System.err.format("Can not access a member of class with modifiers private%n");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err.format("Object cannot be instantiated for the specified class using the newInstance method%n");
			
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		DOMConfigurator.configure("log4j.xml");
		ExcelUtil.setExcelFile(Propertie.testData_filePath, Propertie.testData_FileName, Propertie.testData_sheetName);
		
		DriverScript_ReflectionMethod startEngine = new DriverScript_ReflectionMethod();
		
		System.out.println(ExcelUtil.getRowCount());
		for(int iRow=1; iRow<=ExcelUtil.getRowCount()-1; iRow++)
		{
			List<Object> paramList = new ArrayList<Object>();
			
			String methodName = ExcelUtil.getCellData(iRow, 3);
			
			for (int col = 4; col <= 6; col++)
			{
				if (!ExcelUtil.getCellData(iRow, col).isEmpty() & !ExcelUtil.getCellData(iRow, col).equals("null")) 
				{
					paramList.add(ExcelUtil.getCellData(iRow, col));
				}
			}

			Object[] paramListObject = new String[paramList.size()];
			paramListObject = paramList.toArray(paramListObject);

			startEngine.runReflectionMethod("KeywordActionLibrary.KeywordAction2", methodName, paramListObject);
			
		}

	}
}
