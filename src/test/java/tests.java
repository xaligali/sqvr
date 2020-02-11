import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pages.ConstructorMeetingPage;
import pages.CreateMeetingPage;
import pages.MainPage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class tests {

	private static WebDriver driver;

	@BeforeClass
	public static void setupAll() {
		driver = Driver.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		driver.manage().window().maximize();
	}

	@Before
	public void setup() {
		MainPage mainPage = new MainPage(driver);
		mainPage.open();
		mainPage.click_xpath(mainPage.create_meeting_xpath);
		mainPage.click_css(CreateMeetingPage.choose_template_css);
		mainPage.click_css(CreateMeetingPage.overhaul_css);
		//ConstructorMeetingPage сonstructorMeetingPage = new ConstructorMeetingPage();
	}

	@Test
	public void check_form_archive_negative() {

		ConstructorMeetingPage constructorMeetingPage = new ConstructorMeetingPage(driver);
		MainPage.click_css(constructorMeetingPage.button_form_archive_css);
		Assert.assertEquals(constructorMeetingPage.error_mesg_name, constructorMeetingPage.getText_xpath(constructorMeetingPage.name_xpath));
		Assert.assertEquals(constructorMeetingPage.error_mesg_number, constructorMeetingPage.getText_xpath(constructorMeetingPage.number_apartment_xpath));
		System.out.println("Тест 1. Негативный тест пройден. Найдены ошибки при незаполнении обязательных полей.\n");
	}

	@Test
	public void check_form_archive_positive() {

		ConstructorMeetingPage constructorMeetingPage = new ConstructorMeetingPage(driver);
		ConstructorMeetingPage.inputText_css(ConstructorMeetingPage.input_name_css, ConstructorMeetingPage.input_name);
		ConstructorMeetingPage.inputText_css(ConstructorMeetingPage.input_number_apartment_css, ConstructorMeetingPage.input_number_apartment);
		MainPage.click_css(ConstructorMeetingPage.button_form_archive_css);
		ConstructorMeetingPage.waitCss(ConstructorMeetingPage.link_css);
		Assert.assertEquals(ConstructorMeetingPage.success_mesg, constructorMeetingPage.getText_css(ConstructorMeetingPage.success_mesg_css));
		System.out.println("Тест 2. Позитивный тест пройден. Повестку можно скачать.\n");
	}

	@Test
	public void check_address_and_email_positive() {
		ConstructorMeetingPage constructorMeetingPage = new ConstructorMeetingPage(driver);
		ConstructorMeetingPage.inputText_xpath(ConstructorMeetingPage.input_address_xpath, ConstructorMeetingPage.address);
		ConstructorMeetingPage.inputText_xpath(ConstructorMeetingPage.input_email_xpath, ConstructorMeetingPage.email);
		MainPage.click_xpath(ConstructorMeetingPage.register_line_xpath);
		Assert.assertEquals(ConstructorMeetingPage.address, ConstructorMeetingPage.getAttribute_xpath(ConstructorMeetingPage.address_xpath));
		Assert.assertEquals(ConstructorMeetingPage.email, ConstructorMeetingPage.getAttribute_css(ConstructorMeetingPage.email_css));
		System.out.println("Тест 3. Позитивный тест пройден. Значения для полей адрес объекта и email подставляются со страницы 'Общее собрание собственников о формировании фонда капитального ремонта'.\n");
	}


	@AfterClass
	public static void quit() {
		driver.manage().timeouts().implicitlyWait(10, SECONDS);
		driver.close();
	}

}