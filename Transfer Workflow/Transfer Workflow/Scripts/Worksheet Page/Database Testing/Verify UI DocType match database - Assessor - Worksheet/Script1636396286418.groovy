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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import java.util.ArrayList as ArrayList

/**
 * Verify UI Document Type match Database Document Type
 * @author Bilguun Amarsaikhan
 */

CustomKeywords.'com.database.databaseUtility.connectDB'()

String query = '\nSELECT TOP (1000) [ShortDescription]\nFROM [dbo].[rptDocumentType]\n\n  Order By [ShortDescription] ASC\n'

resultSet = CustomKeywords.'com.database.databaseUtility.storeListDataFromDB'(query)

WebUI.callTestCase(findTestCase('Workflow History Page/US8314 - As an SBC user I can complete a document in Transfer workflow/Access the Workflow History Page'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Assessor Information title')); 

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325- Database/Dropdow of DocType'));

ArrayList<String> dropdownItems = new ArrayList<String>();

List<String> elementList = WebUI.findWebElements(findTestObject('Object Repository/Search Page Objectory/US8325- Database/Dropdown items'), 5)

for (WebElement we : elementList) {
    dropdownItems.add(we.getText())
}

dropdownItems.removeAll('');
println(dropdownItems.size())

System.out.println(resultSet)
println(dropdownItems)

WebUI.closeBrowser();
//This step will be uncommented once Doc Type is complete
//assertTrue(dropdownItems.containsAll(resultSet));