package package1;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class TwitterTest extends BrowserHelper {
	
	@Test

	public void verifySearch() throws InterruptedException {
		getDriver().findElement(By.xpath("//table[@summary='Profile stats']/thead/tr/th[1]")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[contains(@class,'js-preview-profile-linkk')]")).click();
	}
}
