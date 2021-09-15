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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert

/** As an Appraiser, I want the ability to sort all columns in the New Queue - Queues - CAMA */


//Opening browser to URL and navigating to the dashboard
WebUI.openBrowser(GlobalVariable.Url, FailureHandling.STOP_ON_FAILURE);
WebUI.maximizeWindow();
WebUI.waitForPageLoad(20);
WebUI.click(findTestObject('01 Residential Property Appraisal/1 Navigation Page Elements/div_Dashboard'));
WebUI.click(findTestObject('01 Residential Property Appraisal/2 Queue Page Elements/Queue Tabs Elements/NewTab'));

WebDriver driver = DriverFactory.getWebDriver();

List<WebElement> newQueueRows = driver.findElements(By.xpath("(//table[@class='mud-table-root'])[1]/tbody/tr"));
String[] beforeSort_row = new String[newQueueRows.size()];

//Get the text into the array
for(int i=0; i < newQueueRows.size(); i++) {
	beforeSort_row[i] =  newQueueRows.get(i).getText().trim();
}

CustomKeywords.'com.utility.CommonMethods.print'(beforeSort_row);


WebUI.waitForElementPresent(findTestObject('01 Residential Property Appraisal/2 Queue Page Elements/Queue Grid Column Elements/Parcel Column'), 20);
WebUI.click(findTestObject('01 Residential Property Appraisal/2 Queue Page Elements/Queue Grid Column Elements/Parcel Column'));
//WebUI.click(findTestObject('01 Residential Property Appraisal/2 Queue Page Elements/Queue Grid Column Elements/Parcel Column'));

newQueueRows = driver.findElements(By.xpath("(//table[@class='mud-table-root'])[1]/tbody/tr"));
String[] afterSort_row = new String[newQueueRows.size()];

//Get the text into the array
for(int i=0; i < newQueueRows.size(); i++) {
	afterSort_row[i] =  newQueueRows.get(i).getText().trim();
}
System.out.println("***After clicking on column header***");
CustomKeywords.'com.utility.CommonMethods.print'(afterSort_row);

assertArrayEquals(beforeSort_row, afterSort_row );

WebUI.closeBrowser();

