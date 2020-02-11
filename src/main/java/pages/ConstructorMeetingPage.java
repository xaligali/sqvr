package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorMeetingPage {
	private static WebDriver driver;

	private final static String button_form_archive_css = "[class='download-link tt_form_archive']";
	private final static String error_mesg_name = "Фамилия и имя являются обязательными";
	private final static String error_mesg_number = "Поле является обязательным";
	private final static String name_xpath = "(//*[@class='error__text'])[1]";
	private final static String number_apartment_xpath = "(//*[@class='error__text'])[2]";
	private final static String input_name = "Ivanov Ivan";
	private final static String input_number_apartment = "15";
	private final static String input_name_css = "[name = 'full_name']";
	private final static String input_number_apartment_css = "[name = 'apartment']";
	private final static String success_mesg = "Ваш архив с документами сформирован и доступен по этой ссылке";
	private final static String success_mesg_css = "[class='sub-info']";
	private final static String link_css = "[class='link tt_download_link']";
	private final static String email = "xgr@mailinator.com";
	private final static String input_email_xpath = "//*[@id='eid_meeting_creator_email']";
	private final static String email_css = "[class='field4 filled ']";
	private final static String address = "Moscow, Sculptora Muhinoi str.";
	private final static String input_address_xpath = "//*[@name='long_name']";
	private final static String address_xpath = "(//*[@name='long_name'])[2]";
	private final static String register_line_xpath = "//*[text()='Заказать реестр']";

	public ConstructorMeetingPage(WebDriver driver) {

		this.driver = driver;
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

	/**
	 * Проверка сообщений на незаполнение обязательных  полей ФИО и номер помещение
	 *
	 */
	public static void checkNameAndNumberApartment() {
		driver.findElement(By.cssSelector(button_form_archive_css)).click();

		Assert.assertEquals(error_mesg_name, driver.findElement(By.xpath(name_xpath)).getText());
		Assert.assertEquals(error_mesg_number,  driver.findElement(By.xpath(number_apartment_xpath)).getText());
	}

	/**
	 * Проверка cкачивания повестки
	 *
	 */
	public static void checkDownloadFormArchive() {
		inputText_css(input_name_css,input_name);
		inputText_css(input_number_apartment_css,input_number_apartment);

		driver.findElement(By.cssSelector(button_form_archive_css)).click();
		waitCss(link_css);
		Assert.assertEquals(success_mesg, driver.findElement(By.cssSelector(success_mesg_css)).getText());
	}

	/**
	 * Проверка автозаполнения полей адрес и email
	 *
	 */
	public static void checkAddressAndEmail() {
		inputText_xpath(input_address_xpath,address);
		inputText_xpath(input_email_xpath,email);

		driver.findElement(By.xpath(register_line_xpath)).click();

		Assert.assertEquals(address, driver.findElement(By.xpath(address_xpath)).getAttribute("value"));
		Assert.assertEquals(email, driver.findElement(By.cssSelector(email_css)).getAttribute("value"));
	}

}
