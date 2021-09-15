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
import com.utility.CommonMethods

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert

/** [US7871] As an Appraiser, I should be able to see specific columns in all of the Queues  - Queues - CAMA
 * @author Elian Blanco
 *  */


WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/01. Application Landing/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('01 Residential Property Appraisal/02 Dashboard Page Elements/01 Queue Tabs Elements/New Tab'));

WebDriver driver = DriverFactory.getWebDriver();

WebElement queueColumns = driver.findElement(By.xpath("(//table[@class='mud-table-root'])[1]/thead/tr"));

String actualQueueColumns = queueColumns.getText();

String expectedQueueColumns = "Dist\nResp\nParcel\nLag\nEvent Date\nEvent\nReq Type\nExcl\nUse\nEvent Key\nPost Key";

assertEquals(expectedQueueColumns, actualQueueColumns);

WebUI.closeBrowser();