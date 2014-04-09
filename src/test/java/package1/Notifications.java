package package1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Notifications extends BrowserHelper {
	

	
  @Test
  public void twitter_notifications() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//li[contains(@class, 'notifications')]//span[@class='text']/../../a")).click();
	  Thread.sleep(5000);
  }
  
}
