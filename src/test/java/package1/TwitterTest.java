package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TwitterTest {
	@Test

	public void verifySearch() {
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.twitter.com/");
	driver.quit();
	}
}
