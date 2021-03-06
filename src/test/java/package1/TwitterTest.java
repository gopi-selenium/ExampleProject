package package1;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TwitterTest extends BrowserHelper {
	static Logger log = Logger.getLogger(
			TwitterTest.class.getName());
	
	@Test
	public void twitterTest() throws InterruptedException {
		getDriver().findElement(By.xpath("//table[@summary='Profile stats']/thead/tr/th[1]")).click();
		Reporter.log("Pass test with Reporter.log");
		log.info("Twiiter test with Logger");
		Thread.sleep(5000);
	}
}
