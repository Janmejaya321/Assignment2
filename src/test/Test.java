import  org.openqa.*;
public class Test {

	@Test
	public void Launchbrowser() {
		System.setProperty(
	            "webdriver.chrome.driver",
	            "Users\\janmejayapradhan\\eclipse-workspace\\Test_1\\Driver\\chromedriver");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.geeksforgeeks.org/");
	}
}
