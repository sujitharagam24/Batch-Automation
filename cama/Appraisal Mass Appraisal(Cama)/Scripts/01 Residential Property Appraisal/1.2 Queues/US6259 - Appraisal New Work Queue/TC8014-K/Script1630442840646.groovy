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

WebUI.openBrowser(GlobalVariable.Url, FailureHandling.STOP_ON_FAILURE);
WebUI.click(findTestObject('01 Residential Property Appraisal/1 Navigation Page Elements/div_Dashboard'));
WebUI.click(findTestObject('01 Residential Property Appraisal/2 Queue Page Elements/Queue Tabs Elements/NewTab'));

WebDriver driver = DriverFactory.getWebDriver();

WebElement distHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[1]"));
WebElement respHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[2]"));
WebElement parcelHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[3]"));
WebElement lagHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[4]"));
WebElement eventDateHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[5]"));
WebElement eventTypeHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[6]"));
WebElement reqTypeHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[7]"));
WebElement exclHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[8]"));
WebElement useHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[9]"));
WebElement eventKeyHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[10]"));
WebElement postKeyDateHeaders = driver.findElement(By.xpath("(//span[@class='mud-button-root mud-table-sort-label'])[11]"));

assertEquals("Dist", distHeaders.getText());
distHeaders.click();

assertEquals("Resp", respHeaders.getText());
respHeaders.click();

assertEquals("Parcel", parcelHeaders.getText());
parcelHeaders.click();

assertEquals("Lag", lagHeaders.getText());
lagHeaders.click();

assertEquals("Event Date", eventDateHeaders.getText());
eventDateHeaders.click();

assertEquals("Event", eventTypeHeaders.getText());
eventTypeHeaders.click();

assertEquals("Req Type", reqTypeHeaders.getText());
reqTypeHeaders.click();

assertEquals("Excl", exclHeaders.getText());
exclHeaders.click();

assertEquals("Use", useHeaders.getText());
useHeaders.click();

assertEquals("Event Key", eventKeyHeaders.getText());
eventKeyHeaders.click();

assertEquals("Post Key", postKeyDateHeaders.getText());
postKeyDateHeaders.click();

WebUI.closeBrowser();



