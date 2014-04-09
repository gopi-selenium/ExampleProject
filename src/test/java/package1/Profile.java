package package1;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class Profile extends BrowserHelper {
 
	
	
  @Test
  public void twitter_profile() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//li[contains(@class, 'profile')]//span[@class='text']/../../a")).click();
	  Thread.sleep(5000);
	  //Assert.assertEquals(pagetitle, title);
  }
}
