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
 * Verify APN Search Record number match between UI and DB
 * @author Bilguun Amarsaikhan
 */

def apnValue = '0333032190000';

CustomKeywords.'com.database.databaseUtility.connectDB'()

String query = '''
DECLARE	@recordeddocnumber int

EXEC	@recordeddocnumber = [dbo].[sto_searchtASRIndex]
		@recordeddocnumber = NULL,
		@recordeddocnumberhi = NULL,
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
		@apn = '0333032190000',
		@rowlimit = 100,
		@sortcolumn = 1,
		@sortdirection = 1,
		@activecompleteboth = 1,
		@pagenumber = 1
		
SELECT @@ROWCOUNT

Go
'''
def resultSet = CustomKeywords.'com.database.databaseUtility.storeDataFromDB'(query)

String recordNum = String.valueOf(CustomKeywords.'com.database.databaseUtility.size'())

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Search Page Objectory/US8325/Search APN'), apnValue)

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'));

def txt = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325- Database/ResultMsg'));

def actualMsg = txt.substring(txt.lastIndexOf(' ')+1);

assertTrue(actualMsg.equals(recordNum));

WebUI.closeBrowser()