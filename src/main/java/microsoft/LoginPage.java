package microsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage(AndroidDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
    }
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	public WebElement emailElement;
	
	@FindBy(id = "i0118")
	public WebElement inserirSenhaElement;
	
	@FindBy(id = "com.microsoft.todos:id/sign_in_button")
	public WebElement botaoEntrarElement;
	
	public void inserirEmail(String email) {
		emailElement.sendKeys(email);
	}
	
	public void inserirSenha(String senha) {
		inserirSenhaElement.sendKeys(senha);
	}
	
	public void acionarBotaoEntrar() {
		botaoEntrarElement.click();
	}
}
