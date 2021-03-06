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
WebUI.callTestCase(findTestCase('00 Supporting Scripts/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/New Tab'));

def selectedNewParcelNumber = WebUI.getText(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/Parcel Number'));

System.out.println(selectedNewParcelNumber);

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/Parcel Number'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/01 Appraisal Tab/Save and Next Button'));

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/01 ToolBar Elements/Hamburger button'));

WebUI.click(findTestObject('Object Repository/01 Navigation Page Elements/Dashboard Button'));

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/In Process Tab'));

String tableElement = "//tbody[@class='mud-table-body']/tr";

String nextButton = "(//span[@class='mud-icon-button-label'])[5]";

CommonMethods.tablePagination(tableElement, nextButton, selectedNewParcelNumber);

WebUI.closeBrowser();


