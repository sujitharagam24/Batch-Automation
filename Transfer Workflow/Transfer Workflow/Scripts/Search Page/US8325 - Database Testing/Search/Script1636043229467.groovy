import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import java.util.ArrayList;
/**
 * @author Bilguun Amarsaikhan
 */
CustomKeywords.'com.database.databaseUtility.connectDB'()

//'\nSELECT COUNT(*)\nFROM [dbo].[tASRIndex]\nWHERE [RecordedDocNumber]=\'20190254823\'\n'

//String query = '\nDECLARE	@return_value int\nEXEC	@return_value = [dbo].[sto_searchtASRIndex]\n@recordeddocnumber = N\'20190254823\',\n@recordeddocnumberhi = N\'20190254833\',\n@assessordocnumber = NULL,\n@assessordocnumberhi = NULL,\n@recordeddate = NULL,\n@recordeddatehi = NULL,\n@eventdate = NULL,\n@eventdatehi = NULL,\n@grantee_owner = NULL,\n@grantorname = NULL,\n@formid = NULL,\n@tractnumber = NULL,\n@parcelmapnumber = NULL,\n@tractparcelind = NULL,\n@apn = NULL,\n@rowlimit = 100,\n@sortcolumn = 1,\n@sortdirection = 1,\n@activecompleteboth = 1,\n@pagenumber = 1\nSELECT	\'Return Value\' = @return_value\nGO'
String query = '''
DECLARE	@ROWCOUNT int

EXEC	@ROWCOUNT = [dbo].[sto_searchtASRIndex]
		@recordeddocnumber = N'20190254823',
		@recordeddocnumberhi = N'20190254833',
		@assessordocnumber = NULL,
		@assessordocnumberhi = NULL,
		@recordeddate = NULL,
		@recordeddatehi = NULL,
		@eventdate = NULL,
		@eventdatehi = NULL,
		@grantee_owner = NULL,
		@grantorname = NULL,
		@formid = NULL,
		@tractnumber = NULL,
		@parcelmapnumber = NULL,
		@tractparcelind = NULL,
		@apn = NULL,
		@rowlimit = 100,
		@sortcolumn = 1,
		@sortdirection = 1,
		@activecompleteboth = 1,
		@pagenumber = 1

SELECT	@@ROWCOUNT
GO


'''
def resultSet = CustomKeywords.'com.database.databaseUtility.storeDataFromDB'(query)

System.out.println(resultSet + ' ')

