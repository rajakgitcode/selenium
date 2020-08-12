package TestExecutionEngine;

import java.io.IOException;

import KeywordActionLibrary.KeywordAction;
import Utility.ExcelUtil;
import Utility.Propertie;

public class DriverScript 
{
	public static void main(String[] args) throws IOException 
	{
		String excelActionKeywordValue;
		
		//KeywordAction KeywordAction = new KeywordAction();
		
		ExcelUtil.setExcelFile(Propertie.testData_filePath, Propertie.testData_FileName, Propertie.testData_sheetName);
		
		for(int iRow=1; iRow <= ExcelUtil.getRowCount()-1; iRow++)
		{
			excelActionKeywordValue = ExcelUtil.getCellData(iRow, 3);
			
			if(excelActionKeywordValue.equalsIgnoreCase("OpenBrowser"))
			{
				KeywordAction.openBrowser();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("openUrl"))
			{
				KeywordAction.openURL(Propertie.applicationURL);
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("click_CookieOKButton"))
			{
				KeywordAction.clickOnCookieOKButton();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("click_SignUpButton"))
			{
				KeywordAction.clickOnSignUpButton();;
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("SwitchToIFrame"))
			{
				KeywordAction.switchToIframe();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("enter_FirstName"))
			{
				KeywordAction.enterFirstName("ABCEF");
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("enter_LastName"))
			{
				KeywordAction.enterLastName("DDDDE");
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("enter_Email"))
			{
				KeywordAction.enterMail("ABCEF@yahoo.com");
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("enter_Password"))
			{
				KeywordAction.enterNewPassword("123@Qwert");
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("enter_RetypePassword"))
			{
				KeywordAction.enterRetypePassword("123@Qwert");
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("click_PDAccept"))
			{
				KeywordAction.clickOnPDAccept();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("click_ToutAccept"))
			{
				KeywordAction.clickOnTouAccept();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("click_RegisterButton"))
			{
				KeywordAction.clickOnRegisterButton();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("verify_SuccessMessage"))
			{
				KeywordAction.verifySuccessMessage();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("verify_SuccessText"))
			{
				KeywordAction.verifyConfirmationMailMessage();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("click_CloseButton"))
			{
				KeywordAction.clickOnCloseButton();
			}
			else if(excelActionKeywordValue.equalsIgnoreCase("close_Browser"))
			{
				KeywordAction.closeBrowser();
			}
			
		}
	}

}
