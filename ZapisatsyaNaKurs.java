package pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import libs.WebElementsOnPage;
import static libs.ConfigData.getCfgValue;

import java.io.IOException;
public class ZapisatsyaNaKurs {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
	public ZapisatsyaNaKurs(WebDriver externalDriver) {
		this.driver = externalDriver;
		log = Logger.getLogger(getClass());
		webElementsOnPage = new WebElementsOnPage(driver);
	}
	
	/**
	 * Method opens Browser and Page Zapisatsya
	 */
	public void openPageZapisatsya() {
		try {
			webElementsOnPage.openBrowserAndUrl(getCfgValue("SITE_URL") + "/zapisatsya-na-kurs/");
		} catch (IOException e) {
			log.error("File config,properties is not found");
		}
		log.info("Page Zapisatsya was opened");
	}
	
	/**
	 * Method closes Page Zapisatsya and Browser
	 */
	public void closePageZapisatsya() {
		webElementsOnPage.closeBrowser();
		log.info("Page Zapisatsya and Browser were closed");
	}
	
	/**
	 * Method selects text from DD Kurs
	 * @param text
	 * @return
	 */
	public boolean selectTextInDDKurs(String text) {
		return webElementsOnPage.selectTextInDD("ZapisatsyaNaKurs.Kurs.Select", text);
	}
	
	/**
	 * Method types text in LastName field
	 * @param lastname
	 * @return
	 */
	public boolean typeLastName(String lastname) {
		return webElementsOnPage.typeTextIntoInput("ZapisatsyaNaKurs.LastName.Input", lastname);
	}
	
	/**
	 * Method types text in FirstName field
	 * @param firstName
	 * @return
	 */
	public boolean typeFirstName(String firstName) {
		return webElementsOnPage.typeTextIntoInput("ZapisatsyaNaKurs.FirstName.Input", firstName);
	}
	
	/**
	 * Method types text in PhoneNumber field
	 * @param phoneNumber
	 * @return
	 */
	public boolean typePhoneNumber(String phoneNumber) {
		return webElementsOnPage.typeTextIntoInput("ZapisatsyaNaKurs.PhoneNumber.Input", phoneNumber);
	}
	
	/**
	 * Method types text in Email field
	 * @param email
	 * @return
	 */
	public boolean typeEmail(String email) {
		return webElementsOnPage.typeTextIntoInput("ZapisatsyaNaKurs.Email.Input", email);
	}
	
	/**
	 * Method types text in Skype field
	 * @param skype
	 * @return
	 */
	public boolean typeSkype(String skype) {
		return webElementsOnPage.typeTextIntoInput("ZapisatsyaNaKurs.Skype.Input", skype);
	}
	
	/**
	 * Method types text in TextArea
	 * @param text
	 * @return
	 */
	public boolean typeTextInTextArea(String text) {
		return webElementsOnPage.typeTextIntoInput("ZapisatsyaNaKurs.Comments.Textarea", text);
	}
	
	/**
	 * Method submits form zapisatsya na kurs
	 * @return
	 */
	public boolean clickElementSubmit() {
		return webElementsOnPage.clickLinkByLocator("ZapisatsyaNaKurs.SubmitButton.Input");
	}
	
	/**
	 * Method resets form zapisatsya na kurs
	 * @return
	 */
	public boolean clickElementsReset() {
		return webElementsOnPage.clickLinkByLocator("ZapisatsyaNaKurs.ResetButton.Input");
	}
	
	/**
	 * Method check Message Sent Mail Ok
	 * @return
	 */
	public boolean isMessageMailSentOk() {
		return webElementsOnPage.isElementPresent("ZapisatsyaNaKurs.SubmitOk.Text");
	}
	
	public boolean setStateCheckBoxInPageZapisatsya(String stateFromTCFromTest) {
		return webElementsOnPage.setStateCheckbox("", stateFromTCFromTest);
	}
}
