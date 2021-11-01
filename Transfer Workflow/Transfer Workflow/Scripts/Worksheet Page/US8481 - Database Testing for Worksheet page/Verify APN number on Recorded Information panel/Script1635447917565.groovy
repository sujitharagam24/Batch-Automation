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

/**
 * Verify Database APN number on Recorded Information panel
 * @author bilguun.amarsaikhan
 *
 */

CustomKeywords.'com.database.databaseUtility.connectDB'()

String query = '''
	SELECT TOP(1) APN
	FROM [dbo].[tASRIndex]
	WHERE [RecordedDocNumber]='20190254823'
'''

def resultSet = CustomKeywords.'com.database.databaseUtility.storeDataFromDB'(query)

System.out.println(resultSet + ' ')

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

def recordedDocNumber = '20190254823';

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Record Doc number From field'), recordedDocNumber)

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'))

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325- Database/Open button for 1 record'))

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Recorder Information title'))

WebUI.click(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Read Only'))

def apnValue = WebUI.getAttribute(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/APN'), 'value')

def apnValueTitle = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325- Database/APN label'))

def uiApnValue = apnValue.replaceAll('-', '')

List<Map<String, String>> listData = new ArrayList<>();

Map<String, String> mapData = new LinkedHashMap<>();

mapData.put(apnValueTitle, uiApnValue); 

listData.add(mapData)

WebUI.closeBrowser();

assertEquals(resultSet, listData);

CustomKeywords.'com.database.databaseUtility.closeDatabaseConnection'()