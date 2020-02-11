package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MainPage {
	private static WebDriver driver;
	final static String url = "https://sqvr.ru/";
	public final static String create_meeting_xpath = "(//*[text()='Провести собрание'])[1]";

	public MainPage(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * Метод вызывает главную страницу
	 */
	public void open() {

		driver.get(url);
	}

	/**
	 * Поиск элемента и клик на него
	 *
	 * @param str - css элемента
	 */
	public static void click_xpath(String str) {

		driver.findElement(By.xpath(str)).click();
	}

	/**
	 * Поиск элемента и клик на него
	 *
	 * @param str - css элемента
	 */
	public static void click_css(String str) {

		driver.findElement(By.cssSelector(str)).click();
	}

}
