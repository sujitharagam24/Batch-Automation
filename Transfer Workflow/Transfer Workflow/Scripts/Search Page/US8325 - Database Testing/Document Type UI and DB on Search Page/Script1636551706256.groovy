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
 * Verify Document Type match in UI and Database on Search Page
 * @author Bilguun Amarsaikhan
 */

CustomKeywords.'com.database.databaseUtility.connectDB'()

String query = 
'''
Select FormID, FormLongDesc
from FormIDsWithCategoryForAppIDs
where appid = 'ASRTRNFWEB'
order by FormShortDesc asc
'''

resultSet = CustomKeywords.'com.database.databaseUtility.storeListDataDocTypeSearch'(query)

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325- Database/Dropdow of DocType'));

ArrayList<String> dropdownItems = new ArrayList<String>();

List<WebElement> elementList = WebUI.findWebElements(findTestObject('Object Repository/Search Page Objectory/US8325- Database/Dropdown items'), 5)

for(int i=27; i<340; i++) {
	dropdownItems.add(elementList.get(i).getText())
}
dropdownItems.set(dropdownItems.indexOf('NP0203 - Legal'), 'NP0203 - Legal ');
dropdownItems.set(dropdownItems.indexOf('NP0220 - Other'), 'NP0220 - Other ');
dropdownItems.set(dropdownItems.indexOf('NP0239 - Clm for Reassessment Excl for Transfer'), 'NP0239 - Clm for Reassessment Excl for Transfer ');
println(resultSet)
println(dropdownItems)

WebUI.closeBrowser();

assertTrue(resultSet.equals(dropdownItems));