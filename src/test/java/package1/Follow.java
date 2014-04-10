package package1;

import org.openqa.selenium.By;

import org.testng.annotations.Test;


public class Follow extends BrowserHelper {
	
	@Test	
  public void twitter_following() throws InterruptedException {
	  driver.findElement(By.xpath("//table[@summary='Profile stats']/thead/tr/th[2]")).click();
	  
	  driver.findElement(By.xpath("//a[contains(@class,'js-preview-profile-linkk')]")).click();
  }
}
