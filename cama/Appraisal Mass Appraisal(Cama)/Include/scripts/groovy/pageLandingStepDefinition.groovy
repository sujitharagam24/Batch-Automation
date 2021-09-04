import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class pageLandingStepDefinition {
	
	@Given("I am a user of the system")
	def I_am_a_user_of_the_system() {
		
	}
	
	@When("I open URL to the main page")
	def I_open_URL_to_the_main_page() {
		WebUI.openBrowser(GlobalVariable.Url);
	}

	@Then("I see the Dashboard link on the Navigation Bar")
	def I_see_the_Dashboard_link_on_the_Navigation_Bar() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/01 Residential Property Appraisal/1 Navigation Page Elements/div_Dashboard'), 0);
	}

	@Then("I see the Logout link on the Navigation Bar")
	def I_see_the_Logout_link_on_the_Navigation_Bar() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/01 Residential Property Appraisal/1 Navigation Page Elements/div_Logout'), 0);
		WebUI.closeBrowser();
	}
}