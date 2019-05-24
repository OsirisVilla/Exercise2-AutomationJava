package automation;

import org.testng.Assert;

public class Execute {
	
	static Set_Up objSetup;

	public static void main(String[] args) throws InterruptedException {
		
		objSetup = new Set_Up();
		
		// Go to facebook.com
		objSetup.lauchBrowser();
		
		// Validate that URL is correct.
		String expectedURL = "https://www.facebook.com/";
		String actualURL = objSetup.validateURL();
		Assert.assertEquals(actualURL, expectedURL);
		
		// Validate the Title of the page, should be : Facebook - Log In or Sign Up.
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = objSetup.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		// Fill all Sign Up section
		objSetup.fillSignUp("Hector", "Villa", "hector@gmail.com", "hector@gmail.com", "Password");
		
		// Choose a different Birthday not the default one.
		objSetup.birthday();
		
		// Click on Female
		objSetup.selectFemaleRadioBtn();
		
		// Validate Text
		String expectedText = "Connect with friends and the\n" + 
				"world around you on Facebook.";
		String actualText = objSetup.validateText();
		Assert.assertEquals(actualText, expectedText);
		
		// Click on Forgot Account?
		objSetup.clickForgotAccount();
		
		// Validate following text is displayed: “Find Your Account”.
		String expectedFindAcc = "Find Your Account";
		String actualFindAcc = objSetup.validateTextAcc();
		Assert.assertEquals(actualFindAcc, expectedFindAcc);
		
		// Enter a valid email but non existing one and click on search.
		objSetup.enterValidEmail("kharollodepollo@gmail.com");
		
		// Validate Error message is displayed (No search Results).
		Assert.assertTrue(objSetup.errorMessage());
		
		// Wait 2 seconds
		Thread.sleep(2000);
		
		// Quit browser
		objSetup.closeBrowser();
		

	}

}
