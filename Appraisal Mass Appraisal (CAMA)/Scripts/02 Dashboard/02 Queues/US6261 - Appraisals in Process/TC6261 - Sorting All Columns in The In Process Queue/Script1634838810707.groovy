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
import CustomKeywords.CommonMethods.*

/** As an Appraiser, I want the ability to sort all columns in the New Queue - Queues - CAMA
 * @author Elian Blanco
 *  */
WebUI.callTestCase(findTestCase('00 Supporting Scripts/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/In Process Tab'));

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Parcel')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Lag')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Event')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Event')])[2]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Req')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Excl')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Use')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Resp')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Post')])[1]");

CommonMethods.columnSortingVerifier("(//table[@class='mud-table-root'])[1]/tbody/tr", "(//span[contains(text(), 'Dist')])[1]" );

WebUI.closeBrowser();