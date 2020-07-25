package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public static void main(String[] args)
	{
		try
		{
			//FileInputStream file = new FileInputStream(new File("/Users/rajak/git/repository/SAPPlatformTest/src/resources/TestData.xlsx"));
			FileInputStream file = new FileInputStream(new File("/Users/rajak/Downloads/Sumadhura Association/Sumadhura Maintenace Proposal/Maintenance Quote.xlsx"));
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			while(rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType())
					{
						case NUMERIC:
							System.out.println(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							System.out.println(cell.getStringCellValue() + "\t");
							break;
						case BOOLEAN:
							System.out.println(cell.getBooleanCellValue() + "\t");
							break;
						case FORMULA:
							System.out.println(cell.getCellFormula() + "\t");
							break;
						case _NONE:
							System.out.println(cell.getStringCellValue() + "\t");
							break;
						case BLANK:
							System.out.println(cell.getStringCellValue() + "\t");
							break;
						case ERROR:	
							System.out.println(cell.getErrorCellValue() + "\t");
							break;
					}
					
				}
				System.out.println("");
			}
			workbook.close();
			file.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	
}
