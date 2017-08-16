package libs;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import static libs.ConfigData.ui;;

public class WebElementsOnPage {
	WebDriver driver;
	Logger log;
	WebDriverWait wait;

	public WebElementsOnPage(WebDriver externalDriver) {
		this.driver = externalDriver;
		log = Logger.getLogger(getClass());
		wait = new WebDriverWait(driver, 30);
	}

	/**
	 * Method opens Browser and Url
	 * 
	 * @param url
	 */
	public void openBrowserAndUrl(String url) {
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			log.info("Browser was opened and url also " + url);
		} catch (Exception e) {
			log.error("Can't open browser or url " + e);
			Assert.assertTrue(false);
		}
	}

	/**
	 * Method closes browser
	 */
	public void closeBrowser() {
		driver.quit();
		log.info("Browser was closed");
	}

	/**
	 * Method types text into element
	 * 
	 * @param keyInputLocator
	 * @param text
	 * @return
	 */
	public boolean typeTextIntoInput(String keyInputLocator, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyInputLocator))));
			
			WebElement tempElement = driver.findElement(ui(keyInputLocator));
			tempElement.clear();
			tempElement.sendKeys(text);
			log.info("In element was typed " + text);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	/**
	 * Method clicks link by locator
	 * 
	 * @param keyLinkLocator
	 * @return
	 */
	public boolean clickLinkByLocator(String keyLinkLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyLinkLocator))));
			
			driver.findElement(ui(keyLinkLocator)).click();
			log.debug("Element was clicked with locator " + keyLinkLocator);
			return true;
		} catch (Exception e) {
			log.error("Unable to click element");
			return false;
		}
	}

	/**
	 * Method clicks on button by xpath
	 * 
	 * @param keyButtonLocator
	 * @return
	 */
	public boolean clickButton(String keyButtonLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyButtonLocator))));
			
			driver.findElement(ui(keyButtonLocator)).click();
			log.debug("Button was clicked with locator " + keyButtonLocator);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	/**
	 * Method set state in checkbox
	 * 
	 * @param keyCheckboxLocator
	 * @param stateFromPC
	 *            (should be only "Checked" or "UnChecked")
	 * @return
	 */
	public boolean setStateCheckbox(String keyCheckboxLocator, String stateFromPC) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyCheckboxLocator))));
			
			WebElement checkbox = driver.findElement(ui(keyCheckboxLocator));

			if (checkbox.isSelected() && stateFromPC.equals("Checked")) {
				log.info("Checkbox is already checked");
			} else if (checkbox.isSelected() && stateFromPC.equals("UnChecked")) {
				checkbox.click();
				log.info("Checkbox was UnChecked");
			} else if (!checkbox.isSelected() && stateFromPC.equals("Checked")) {
				checkbox.click();
				log.info("Checkbox was Checked");
			} else if (!checkbox.isSelected() && stateFromPC.equals("UnChecked")) {
				log.info("Checkbox is already UnChecked");
			} else {
				log.error("This will never happen, but ...");
			}
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	
	/**
	 * Method selects radio button
	 * @param keyRadioLocator
	 * @return
	 */
	public boolean selectRadioButton(String keyRadioLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyRadioLocator))));
			
			driver.findElement(ui(keyRadioLocator)).click();
			log.debug("RadioButton was selected");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	
	/**
	 * Method select text in DD
	 * @param keyDDLocator
	 * @param text
	 * @return
	 */
	public boolean selectTextInDD(String keyDDLocator, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyDDLocator))));
			
			WebElement mainDD;
			mainDD = driver.findElement(ui(keyDDLocator));			
			Select selectFromDD = new Select(mainDD);
			selectFromDD.selectByVisibleText(text);
			log.info(text + " was selected in DD");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	
	/**
	 * Method select value in DD
	 * @param keyDDLocator
	 * @param value
	 * @return
	 */
	public boolean selectValueInDD(String keyDDLocator, String value) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyDDLocator))));
			
			WebElement mainDD;
			mainDD = driver.findElement(ui(keyDDLocator));			
			Select selectFromDD = new Select(mainDD);
			selectFromDD.selectByValue(value);
			log.info(value + " was selected in DD");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	
	/**
	 * Method check element on the page
	 * @param keyElementLocator
	 * @return
	 */
	public boolean isElementPresent(String keyElementLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyElementLocator))));
			
			WebElement tempElement = driver.findElement(ui(keyElementLocator));
			if (tempElement.isEnabled() && tempElement.isDisplayed()){
				log.info("Element presents");
				return true;
			} else {
				log.info("Element is not Enabled or not Displayed");
				return false;
			}
		} catch (Exception e) {
			log.info("Element not found");
			return false;
		}
	}
}
