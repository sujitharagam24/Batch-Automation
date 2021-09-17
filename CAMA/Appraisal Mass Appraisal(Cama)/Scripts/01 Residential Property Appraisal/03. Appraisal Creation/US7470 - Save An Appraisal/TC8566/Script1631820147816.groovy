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

/**
 * As an Appraiser, I should be able to move saved appraisal to the appraiser's "In Progress" work queue.  - Appraisal Details - CAMA
 * @author elian.blanco
 *
 */

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/01. Application Landing/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/01 Queue Tabs Elements/New Tab'));

def selectedNewParcelNumber = WebUI.getText(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/02 Queue Grid Column Elements/Parcel Number'));

System.out.println(selectedNewParcelNumber);

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/02 Queue Grid Column Elements/Parcel Number'));

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/01 Appraisal Tab/Save Button'));

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/01 Navigation Page Elements/div_Dashboard'));

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/01 Queue Tabs Elements/In Process Tab'));

WebDriver driver = DriverFactory.getWebDriver();

List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='mud-table-body']/tr"));
WebElement next =driver.findElement(By.xpath("(//span[@class='mud-icon-button-label'])[4]"));
boolean flag = true;

while(flag) {
	for(WebElement row: rows) {
		String rowText = row.getText();	
		if(rowText.contains(selectedNewParcelNumber)) {
			flag = false;
			System.out.println(rowText);
			System.out.println(selectedNewParcelNumber);
			assertTrue(rowText.contains(selectedNewParcelNumber));
			break;
		}
	}
	next.click();
	rows = driver.findElements(By.xpath("//tbody[@class='mud-table-body']/tr"));
}
 
WebUI.closeBrowser();
