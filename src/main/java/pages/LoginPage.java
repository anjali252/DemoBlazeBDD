package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="login2") WebElement login;
	@FindBy(id="loginusername") WebElement uname;
	@FindBy(id="loginpassword") WebElement pwd;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]") WebElement loginBtn;
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void login(String strName,String strPwd) {
		login.click();
//		driver.switchTo().alert();
	uname.sendKeys(strName);
	pwd.sendKeys(strPwd);
	loginBtn.click();
	}
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
}
