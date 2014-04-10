package package1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Discovery extends BrowserHelper{

   @Test
  public void twitter_discovery() throws InterruptedException {

	  getDriver().findElement(By.xpath("//li[contains(@class, 'topics')]//span[@class='text']/../../a")).click();
      Thread.sleep(5000);
  }
}
