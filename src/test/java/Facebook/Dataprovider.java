package Facebook;

import org.testng.annotations.DataProvider;

public class Dataprovider {

	@DataProvider(name = "login")
	public Object[][] Dataslogin() {
		Object[][] obj = new Object[][] {

				{ "Hari", "98989" }

		};
		return obj;
	}
	
	@DataProvider(name="Register")
	public Object[][] RegLogin() {
		Object[][] obj= new Object[][] {
			{"Hari","Dharan","hari@gmail.com","hari@gmail.com","99889898899",}			
		};
		return obj;
	}
	
	
}
