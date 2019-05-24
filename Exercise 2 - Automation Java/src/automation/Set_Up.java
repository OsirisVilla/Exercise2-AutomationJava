package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Set_Up {

	WebDriver driver = new ChromeDriver();;
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void lauchBrowser() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://facebook.com");

	}

	public String validateURL() {

		return driver.getCurrentUrl();

	}

	public String validateTitle() {

		return driver.getTitle();
	}

	public void setUserName(String strFirstName) {

		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys(strFirstName);

	}

	public void setLastName(String strLastName) {

		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys(strLastName);

	}

	public void setEmail(String strEmail, String strEmailConfirmation) {

		WebElement emailSignUp = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		emailSignUp.sendKeys(strEmail);

		wait.until(ExpectedConditions.visibilityOf(emailSignUp));
		WebElement confirmEmailSignUp = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		confirmEmailSignUp.sendKeys(strEmailConfirmation);

	}

	public void setPassword(String strPassword) {

		WebElement passwordSignUp = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		passwordSignUp.sendKeys(strPassword);

	}

	public void fillSignUp(String strFirstName, String strLastName, String strEmail, String strEmailConfirmation,
			String strPassword) {

		// Fill First Name
		this.setUserName(strFirstName);

		// Fill last name
		this.setLastName(strLastName);

		// Fill Email and Confirm email
		this.setEmail(strEmail, strEmailConfirmation);

		// Fill Password
		this.setPassword(strPassword);

	}

	public void birthday() {

		WebElement month = driver.findElement(By.id("month"));
		new Select(month).selectByIndex(11);

		WebElement day = driver.findElement(By.id("day"));
		new Select(day).selectByIndex(18);

		WebElement year = driver.findElement(By.id("year"));
		new Select(year).selectByValue("1990");

	}

	public void selectFemaleRadioBtn() {

		WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));

		wait.until(ExpectedConditions.elementToBeClickable(femaleRadioBtn));

		femaleRadioBtn.click();
	}

	public String validateText() {

		return driver.findElement(By.xpath("//h2[@class='inlineBlock _3ma _6n _6s _6v']")).getText();
	}

	public void clickForgotAccount() {

		WebElement forgotAccount = driver.findElement(By.xpath("//a[contains(text(),'Forgot account?')]"));
		boolean forgotAccountDisplayed = forgotAccount.isDisplayed();
		Assert.assertTrue(forgotAccountDisplayed);

		forgotAccount.click();
	}
	
	public String validateTextAcc() {
		
		WebElement actualText = driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']"));
		wait.until(ExpectedConditions.visibilityOf(actualText));
		return driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']")).getText();
	}
	
	public void enterEmail(String strEnterEmail) {
		
		WebElement emailTextBox = driver.findElement(By.id("identify_email"));
		emailTextBox.sendKeys(strEnterEmail);
		
	}
	
	public void clickSearch() {
		
		WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Search']"));
		searchBtn.click();
	}
	
	public void enterValidEmail(String strEnterEmail) {
		
		// Fill email
		this.enterEmail(strEnterEmail);
		
		// Click Search button
		this.clickSearch();
	}
	
	public boolean errorMessage() {
		
		return driver.findElement(By.xpath("//div[@class='pam uiBoxRed']")).isDisplayed();
		
}

	public void closeBrowser() {

		driver.quit();
	}

}
