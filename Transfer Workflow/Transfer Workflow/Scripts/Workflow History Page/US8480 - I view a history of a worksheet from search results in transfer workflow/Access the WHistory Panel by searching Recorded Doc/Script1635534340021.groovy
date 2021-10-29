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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.testobject.TestObject as TestObject

/**
 * 
 * Access the Workflow History Panel on the Workflow History Page through Search Page  by History Button
 * @author bilguun.amarsaikhan
 *
 */

WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/div_Search'))

WebUI.waitForPageLoad(10)

WebUI.waitForElementVisible(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case 8369/Recorded Doc number from field'), 10);

def recordedDocValue = "20200477552";

WebUI.setText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case 8369/Recorded Doc number from field'), recordedDocValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'));

WebUI.waitForElementVisible(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case 8369/History button'), 10);

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case 8369/History button'))

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Workflow History title'));

def sectionTitle = "Workflow History";

def existingTitle = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Workflow History title'));

assertTrue(sectionTitle.equals(existingTitle));

def beginDate = 'Step Begin Date';

def existingBeginDate = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Begin Date'));

assertTrue(beginDate.equals(existingBeginDate));

def completeDate =  'Step Complete Date';

def existingCompleteDate = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Complete Date'));

assertTrue(completeDate.equals(existingCompleteDate));

def stepName = 'Step Name'; 

def existingStepName = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Step Name'));

assertTrue(stepName.equals(existingStepName));

// Currently skipping the following step. Existing column name is Reason Key

//def reason = 'Reason';

//def existingReason = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Reason'));

//assertTrue(reason.equals(existingReason));

def completeBy = 'Complete By';

def existingcompleteBy = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Complete By'));

assertTrue(completeBy.equals(existingcompleteBy));

WebUI.closeBrowser();