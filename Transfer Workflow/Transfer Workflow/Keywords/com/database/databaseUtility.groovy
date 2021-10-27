package com.database

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class databaseUtility {

	private static String dbUrl = GlobalVariable.dbUrl;
	private static String dbUserName = GlobalVariable.dbUsername;
	private static String dbPassword = GlobalVariable.dbPassword;
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static ResultSetMetaData rsMetadata;
	private static List<Map<String, String>> listData;


	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//Establishing a connection to the DataBase

	@Keyword

	def connectDB(){
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace()
		}
		System.out.println("Connection Successful");
	}

	/**
	 * This method stores the data from the DB into a List of Maps
	 * @param sqlQuery
	 * @return 
	 */

	//Executing the constructed Query and Saving results in resultset

	@Keyword

	public static List<Map<String, String>> storeDataFromDB(String sqlQuery) {

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			rsMetadata = rs.getMetaData();
			listData = new ArrayList<>();


			while(rs.next()) {
				Map<String, String> mapData = new LinkedHashMap<>();
				for(int i = 1; i <= rsMetadata.getColumnCount(); i++) {
					mapData.put(rs.getMetaData().getColumnName(i), rs.getObject(i).toString());
				}
				listData.add(mapData);
			}
		} catch (SQLException e) {

			e.printStackTrace()
		}
		return listData;
	}

	//Closing the connection

	@Keyword

	def closeDatabaseConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace()
		}
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */

	@Keyword

	def execute(String queryString) {

		Statement stm = conn.createStatement();

		boolean result = stm.execute(queryString);

		return result;

	}

}
