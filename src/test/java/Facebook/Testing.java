package Facebook;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Testing extends Baseclass {

	@BeforeClass
	private void beforeclass() {
		Browserlaunch("Chrome");
		timeout(20);

	}
	@AfterClass
	private void afterclass() {
		quit();

	}
	
	
	@Test(dataProvider="login",dataProviderClass=Dataprovider.class)
	private void Loginpage(String user, String pass) {
		
		urllaunch("https://www.facebook.com/");
		Login l = new Login();
		l.login(user, pass);
		WebElement ass = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String asser = ass.getText();
		System.out.println(asser);
		Assert.assertEquals(asser, "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
	}
	
	
	
	
	
	
	
	
	
	

}
