package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import static libs.ExcelDriver.getData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.testng.log4testng.Logger;

import libs.ConfigData;
import pages.ZapisatsyaNaKurs;

public class Test1 extends ParentTest{
	ZapisatsyaNaKurs zapisatsyaNaKurs;
	Logger log;
	
	public Test1(String browser) throws MalformedURLException {
		  super(browser);
		  
		 }
	
	@Test
	public void test1(){
		Map dataForTest = null;
		try {
			dataForTest = getData(ConfigData.getCfgValue("DATA_FILE"), "Test1");
		} catch (IOException e) {
			log.error("Can't find file");
			e.printStackTrace();
			Assert.fail("Can't find file");
		}
		zapisatsyaNaKurs = new ZapisatsyaNaKurs(driver);
		log = Logger.getLogger(getClass());
	
		zapisatsyaNaKurs.openPageZapisatsya();
		
		Assert.assertTrue(
		zapisatsyaNaKurs.selectTextInDDKurs(dataForTest.get("kurs").toString())&
		zapisatsyaNaKurs.typeLastName(dataForTest.get("lastName").toString())&
		zapisatsyaNaKurs.typeFirstName(dataForTest.get("firstName").toString())&
		zapisatsyaNaKurs.typePhoneNumber(dataForTest.get("phone").toString())&
		zapisatsyaNaKurs.typeEmail(dataForTest.get("email").toString())&
		zapisatsyaNaKurs.typeSkype(dataForTest.get("skype").toString())&
		zapisatsyaNaKurs.clickElementSubmit());
				
		Assert.assertTrue(zapisatsyaNaKurs.isMessageMailSentOk());
	}
	
	@After
	public void tearDown(){
		zapisatsyaNaKurs.closePageZapisatsya();
	}
	

}
