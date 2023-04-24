package elementRepository;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Utility;



public class InputFormPage {
	WebDriver driver;
	Utility utility;
By input_Form_Link =By.xpath("//ul[@class='navbar-nav']//li[2]//a[@class='nav-link']");
////a[contains(text(),'Input Form')]
By show_Message= By.xpath("//button[@class='btn btn-primary']");
@FindBy(xpath="//a[text()='Checkbox Demo']")
WebElement checkBox;//pageObject model using pageFactory

public void clickOnCheckBoxLink()
{
	checkBox.click();
}


	public InputFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	public void callpageFactory() {
//		PageFactory.initElements(driver, this);
//	}
	public void ElementClick() {
		WebElement inputFormClick= driver.findElement(input_Form_Link);
		inputFormClick.click();
		
	}
	
	public String get_TextofShowMessageButton() {
		
		WebElement showMessageButton=driver.findElement(show_Message);
		String text=utility.get_TextOfElement(showMessageButton);
		
		return text;
		
		
	}
	
	public String showMessageButtonText() {
		
		WebElement show_Message_Element=driver.findElement(show_Message);
		String textShowMesage= show_Message_Element.getText();
		//return show_Message_Element.isDisplayed();
		return textShowMesage;
	}

}
