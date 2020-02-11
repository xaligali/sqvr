package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	private static WebDriver driver;
	final static String url = "https://sqvr.ru/";
	private final static String create_meeting_xpath = "(//*[text()='Провести собрание'])[1]";

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
	 * Переход на страницу CreateMeetingPage
	 * @return {@link CreateMeetingPage}
	 */
	public CreateMeetingPage goToCreateMeetingPage() {
		driver.findElement(By.xpath(create_meeting_xpath)).click();
		return new CreateMeetingPage(driver);
	}
}
