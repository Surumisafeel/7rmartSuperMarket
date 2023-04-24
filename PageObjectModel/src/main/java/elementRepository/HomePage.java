package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.Utility;

public class HomePage {
	WebDriver driver;
	
	Utility utility;
	
	By obsqura_logo =By.xpath("//img[@alt='logo']");

//	public void printTitle() {
//		String title= driver.getTitle();
//		System.out.println(title);
//	}
public HomePage(WebDriver driver) {
	this.driver = driver;
	
}

public boolean isObsquralogoDisplayed() {
	WebElement logo=driver.findElement(obsqura_logo);
	return logo.isDisplayed();
}

public void getHomePageHeaders() {
	utility= new Utility(driver);
	List <String> headers = new ArrayList<String>();
	headers =utility.getTextOfElements("//ul[@class='navbar-nav']//li//a");
	System.out.println(headers);
	
	
}

}
//WebElement element= driver.findElement(By.xpath(""));