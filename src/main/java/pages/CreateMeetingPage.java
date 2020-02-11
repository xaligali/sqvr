package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateMeetingPage {
	private static WebDriver driver;
	private final static String choose_template_css = "[class='act tt_choose_template']";
	private final static String overhaul_css = "[class='btn btn-blue btn-sm tt_overhaul']";

	public CreateMeetingPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Переход на страницу ConstructorMeetingPage
	 * @return {@link ConstructorMeetingPage}
	 */
	public ConstructorMeetingPage goToConstructorMeetingPage() {
		driver.findElement(By.cssSelector(choose_template_css)).click();
		driver.findElement(By.cssSelector(overhaul_css)).click();
		return new ConstructorMeetingPage(driver);
	}
}
