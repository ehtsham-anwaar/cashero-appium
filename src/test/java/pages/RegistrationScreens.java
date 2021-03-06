package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegistrationScreens extends AbstractPageObject{

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") private MobileElement locationAccessWhileUsingApp;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button") private MobileElement locationAccessOnlyThisTime;
	@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button") private MobileElement locationAccessDeny;
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button") private MobileElement contactAccessAllow;
	@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button") private MobileElement contactAccessDeny;
	@FindBy(className = "android.widget.Button") private MobileElement nextButton;
	@FindBy(xpath = "//android.view.View[@index='4']") private MobileElement countryDropdown;
	@FindBy(xpath = "//android.widget.EditText[@index='1']") private MobileElement countrySearchBar;
	@FindBy(xpath = "//android.view.View[@bounds='[0,428][1080,626]']") private MobileElement firstCountry;
	
    public RegistrationScreens(AppiumDriver driver){
        super(driver);
    }

	public void tapAllowLocationWhileUsingApp() throws Exception {
        try {
        	wait.until(ExpectedConditions.visibilityOf(locationAccessWhileUsingApp));
        	locationAccessWhileUsingApp.click();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
	
	public void tapAllowContacts() throws Exception {
        try {
        	wait.until(ExpectedConditions.visibilityOf(contactAccessAllow));
        	contactAccessAllow.click();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
	
	public void tapNextButton() throws Exception {
        try {
        	wait.until(ExpectedConditions.visibilityOf(nextButton));
        	nextButton.click();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
	
	public void tapCountryDropdown() throws Exception {
        try {
        	wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        	countryDropdown.click();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
	
	public void enterCountryName(String countryName) throws Exception {
        try {
        	wait.until(ExpectedConditions.visibilityOf(countrySearchBar));
        	countrySearchBar.click();
        	countrySearchBar.sendKeys(countryName);
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
	
	public void selectFirstCountry() throws Exception {
        try {
        	wait.until(ExpectedConditions.visibilityOf(firstCountry));
        	firstCountry.click();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
	
}
