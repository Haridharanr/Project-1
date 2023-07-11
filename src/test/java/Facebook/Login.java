package Facebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Baseclass;

public class Login extends Baseclass  {
	
	public Login() {
        
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement  username;
    
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
	public void login(String user, String pass) {
		sendkeys(getUsername(), user);
		sendkeys(getPassword(), pass);
		click(getLogin());

	}


}
