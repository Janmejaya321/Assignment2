import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;


public class Assignment {
     public static WebDriver driver;
	@Before
	public void Launchbrowser() {
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				        path+"/Driver/chromedriver");
	        driver= new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://accounts.teachmint.com/");
	}
	@Test
	public void DownloadCertificate() throws Exception {
		//Precondition: for time constraint I have added implicit wait for 
		//WebDriver to wait for a certain measure of time before throwing an exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-1: Enter the Mobile Number and click on Next
		driver.findElement(By.cssSelector("input[id='user-input']")).sendKeys("0000020232");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		//Step 2: Enter OTP 120992(Due to time constraint I have hardcoded the for loop here)
		driver.findElement(By.xpath("//div[@class='otp-container']/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//div[@class='otp-container']/input[2]")).sendKeys("2");
		driver.findElement(By.xpath("//div[@class='otp-container']/input[3]")).sendKeys("0");
		driver.findElement(By.xpath("//div[@class='otp-container']/input[4]")).sendKeys("9");
		driver.findElement(By.xpath("//div[@class='otp-container']/input[5]")).sendKeys("9");
		driver.findElement(By.xpath("//div[@class='otp-container']/input[6]")).sendKeys("2");
		driver.findElement(By.id("submit-otp-btn-id")).click();
		
		//Step 3: Click on "Skip For Now" to set any password
		driver.findElement(By.xpath("//span[contains(text(),'Skip for now')]")).click();
		
		//Step 4: Click on the '>' icon of the User to Enter as Admin
		driver.findElement(By.xpath("//div[@class='profile-label']/img")).click();
		driver.navigate().refresh();
		Thread.sleep(100000);
		
		//Step 5: Move to Administrator section and Click on Certificates
		WebElement ele=driver.findElement(By.xpath("//div[@role='presentation']//span[contains(@class,'icon-administrator')]"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		driver.findElement(By.xpath("//div/a[text()='Certificates']")).click();
		
		//Step 6: Select "Study Certificate" from templates
		driver.findElement(By.xpath("//div[contains(@class,'Cards')]/h6[text()='Study Certificate']")).click();
		
		//Step 7:Click on "Generate" action button
		driver.findElement(By.cssSelector("button[body='Generate']")).click();
		
		//Step 8: Search and select the student checkbox
		driver.findElement(By.cssSelector("input[name='search']")).sendKeys("Sam");
		driver.findElement(By.cssSelector("tbody span[class]")).click();	
		
		//Step 9: Click on generate
		driver.findElement(By.xpath("//button/div[text()='Generate']")).click();
		
		//Step 10: Update Remarks
		//This text field is npt showing for me
		
		//Step 11: Genrate and download the certificate
		driver.findElement(By.xpath("//button/div[text()='Generate']")).click();
		driver.findElement(By.xpath("//button/div[text()='Download']")).click();
		
		//Step 12: validate the histry of certificate
		//Not able to find the option or button to validate the history
	}
	@After
	public void Terminate() {
		driver.quit();
	}
}
