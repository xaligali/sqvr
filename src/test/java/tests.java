import org.junit.*;
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
		CreateMeetingPage createMeetingPage = mainPage.goToCreateMeetingPage();
		createMeetingPage.goToConstructorMeetingPage();
	}

	@Test
	public void check_form_archive_negative() {

		ConstructorMeetingPage.checkNameAndNumberApartment();
		System.out.println("Тест 1. Негативный тест пройден. Найдены ошибки при незаполнении обязательных полей.\n");
	}

	@Test
	public void check_form_archive_positive() {

		ConstructorMeetingPage.checkDownloadFormArchive();
		System.out.println("Тест 2. Позитивный тест пройден. Повестку можно скачать.\n");
	}

	@Test
	public void check_address_and_email_positive() {

		ConstructorMeetingPage.checkAddressAndEmail();
		System.out.println("Тест 3. Позитивный тест пройден. Значения для полей адрес объекта и email подставляются со страницы 'Общее собрание собственников о формировании фонда капитального ремонта'.\n");
	}


	@AfterClass
	public static void quit() {
		driver.manage().timeouts().implicitlyWait(10, SECONDS);
		driver.close();
	}

}