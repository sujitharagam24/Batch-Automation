import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

import java.awt.RenderingHints.Key

import org.openqa.selenium.Keys

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 *
 * Search results Verify Lead APN Field Edited on the Accessor Panel
 * @author menen.Desta
 *
 */

WebUI.callTestCase(findTestCase('My Work Page/US8761 - As a SBC user I can sort items in my work queue/Access the My Work Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Work Queue Document Open'));

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Work Queue Accessor Panel'));

WebUI.setText(findTestObject('Object Repository/My Work Page Objectory/US8761/Lead APN Field'),
	'5548@@@def!!!%123');

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Update Button'));

def expectedMsg = 'APN must be exactly 13 numeric characters'

def actualMsg = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US0002/Lead APN Validation Message'));

assertTrue(actualMsg.contains(expectedMsg));

WebUI.sendKeys(findTestObject('Object Repository/My Work Page Objectory/US8761/Lead APN Field'),Keys.chord(Keys.CONTROL, 'a'));

WebUI.sendKeys(findTestObject('Object Repository/My Work Page Objectory/US8761/Lead APN Field'),Keys.chord(Keys.BACK_SPACE));

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Update Button'));

def expectedResult = 'The LeadAPN field is required'

def actualResult= WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US0002/Lead APN field required message'));

assertTrue(actualResult.contains(expectedResult));

WebUI.closeBrowser();


