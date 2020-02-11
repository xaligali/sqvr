package pages;

import org.openqa.selenium.WebDriver;

public class CreateMeetingPage extends MainPage {
	public final static String choose_template_css = "[class='act tt_choose_template']";
	public final static String overhaul_css = "[class='btn btn-blue btn-sm tt_overhaul']";

	public CreateMeetingPage(WebDriver driver) {
		super(driver);
	}
}
