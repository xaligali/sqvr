package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorMeetingPage {
	private static WebDriver driver;

	public final static String button_form_archive_css = "[class='download-link tt_form_archive']";
	public final static String error_mesg_name = "Фамилия и имя являются обязательными";
	public final static String error_mesg_number = "Поле является обязательным";
	public final static String name_xpath = "(//*[@class='error__text'])[1]";
	public final static String number_apartment_xpath = "(//*[@class='error__text'])[2]";
	public final static String input_name = "Ivanov Ivan";
	public final static String input_number_apartment = "15";
	public final static String input_name_css = "[name = 'full_name']";
	public final static String input_number_apartment_css = "[name = 'apartment']";
	public final static String success_mesg = "Ваш архив с документами сформирован и доступен по этой ссылке";
	public final static String success_mesg_css = "[class='sub-info']";
	public final static String link_css = "[class='link tt_download_link']";
	public final static String email = "xgr@mailinator.com";
	public final static String input_email_xpath = "//*[@id='eid_meeting_creator_email']";
	public final static String email_css = "[class='field4 filled ']";
	public final static String address = "Moscow, Sculptora Muhinoi str.";
	public final static String input_address_xpath = "//*[@name='long_name']";
	public final static String address_xpath = "(//*[@name='long_name'])[2]";
	public final static String register_line_xpath = "//*[text()='Заказать реестр']";
	public final static String modal_css = "[class='modal-content']";
	public final static String modal_xpath = "//*[text()='Заказать реестр собственников']";

	public ConstructorMeetingPage(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * Получение текста с элемента
	 *
	 * @param str - xpath элемента
	 */
	public String getText_xpath(String str) {

		return driver.findElement(By.xpath(str)).getText();
	}

	/**
	 * Получение текста с элемента
	 *
	 * @param str - css элемента
	 */
	public String getText_css(String str) {
		return driver.findElement(By.cssSelector(str)).getText();
	}

	/**
	 * Получение текста с элемента
	 *
	 * @param str - css элемента
	 */
	public static String getAttribute_css(String str) {
		return driver.findElement(By.cssSelector(str)).getAttribute("value");
	}

	public static String getAttribute_xpath(String str) {
		return driver.findElement(By.xpath(str)).getAttribute("value");
	}

	/**
	 * Ввод данных в поле
	 *
	 * @param locator - xpath элемента,
	 * @param input   - строка с данными
	 */
	public static void inputText_xpath(String locator, String input) {

		driver.findElement(By.xpath(locator)).sendKeys(input);
	}

	/**
	 * Ввод данных в поле
	 *
	 * @param locator - css элемента,
	 * @param input   - строка с данными
	 */
	public static void inputText_css(String locator, String input) {

		driver.findElement(By.cssSelector(locator)).sendKeys(input);
	}

	/**
	 * Ожидание появления элемента
	 *
	 * @param css - css элемента
	 */
	public static void waitCss(String css) {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
	}

	/**
	 * Ожидание появления элемента
	 *
	 * @param xpath - css элемента
	 */
	public static void waitXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
}
