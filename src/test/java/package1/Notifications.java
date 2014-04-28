package package1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Notifications extends BrowserHelper {
	
  @Test
  public void twitter_notifications() throws InterruptedException {
	  
	  getDriver().findElement(By.xpath("//li[contains(@class, 'notifications')]//span[@class='text']/../../a")).click();
	  Thread.sleep(5000);
	  //getDriver().findElement(By.xpath("//a[contains(@class,'js-preview-profile-linkk')]")).click();
  }
  
}
