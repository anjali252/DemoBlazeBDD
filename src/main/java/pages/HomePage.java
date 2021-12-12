package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "(//a[@id='itemc'])[1]")
	WebElement phoneCategory;
	@FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
	WebElement addToCart;
	@FindBy(id = "cartur")
	WebElement cart;
	@FindBy(xpath = "(//a[@class='nav-link'])[1]")
	WebElement home;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectCategory() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", phoneCategory);
	}

	public void addItem(String item1, String item2) throws InterruptedException {
		String item = "";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("Ready to add item");
		for (int i = 0; i < 2; i++) {
			System.out.println("For loop with i="+i);
			item = ((i == 0) ? item1 : item2);
			System.out.println("Item = "+item);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			try {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(item)));
			driver.findElement(By.linkText(item)).click();
			}
			catch(Exception ex) {
				jse.executeScript("arguments[0].click()", driver.findElement(By.linkText(item)));
				System.out.println("Clicked on item with jse in catch");
			}
			try {
				addToCart.click();
				System.out.println("Clicked on add to cart button with jse in try");
				break;
			} catch (Exception ex1) {
				for (int j = 0; j < 2; j++) {
					System.out.println("Catching exception with j="+j);
					wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']")));
					System.out.println("Waiting untill visibility of add to cart button");
					addToCart.click();
					System.out.println("Clicking add to cart button");
				}
				System.out.println("ii ="+i);
			}
			System.out.println("i ="+i);
		}
		 wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Waiting untill visibility of alert");
			driver.switchTo().alert().accept();
			System.out.println("alert accepted");
			home.click();
//			cart.click();
//			System.out.println("checking cart");
//			wait = new WebDriverWait(driver, 60);
//			WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]")));
//			System.out.println("Waiting untill visibility of table data");
//			System.out.println(cartItem.getText());
//			System.out.println(item);
//			Assert.assertTrue(cartItem.getText().equals(item));
//			System.out.println("Done");
	}
}
