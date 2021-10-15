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
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.SQLException
import java.util.ArrayList
import java.util.List
import static org.junit.Assert.*


CustomKeywords.'com.utility.DBUtils.connectDB'();

String query = '''declare @salesParcelNbr varchar(20) = '0312073190000'

SELECT TOP 2 SALE_PARCEL_NBR,
SALE_SALE_DATE AS Sale_Date,
EVNT_MULTI_PARC AS Multi,
SALE_BAD_SALE AS Bad,-
SALE_DOC_AMT AS Doc_Amount,
SALE_CONF_AMT AS Conf_Amount,
SALE_ADJUST_AMT As Adj_Amount,
SALE_SALE_USE AS "Use"
FROM NP.NPTSALE1, NP.NPTEVNT1
WHERE SALE_PARCEL_NBR = @salesParcelNbr
AND SALE_EVENT_KEY = EVNT_EVENT_KEY AND
SALE_PARCEL_NBR = EVNT_PARCEL_NBR  
ORDER BY SALE_SALE_DATE DESC;'''
                    
def resultSet = CustomKeywords.'com.utility.DBUtils.storeDataFromDB'(query);

System.out.println(resultSet + " ");

CustomKeywords.'com.utility.DBUtils.closeDatabaseConnection'();

WebUI.callTestCase(findTestCase('00 Supporting Scripts/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/02 Queue Grid Column Elements/Detail button'));

String dataSaleTable = WebUI.getText(findTestObject('Object Repository/01 Residential Property Appraisal/Sale Data table'));

System.out.println(dataSaleTable);

assertEquals(resultSet, dataSaleTable);


WebUI.closeBrowser();