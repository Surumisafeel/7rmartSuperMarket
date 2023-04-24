package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Utility;

public class TablePage {

		WebDriver driver;
		
		Utility utility;
		By table_header =By.xpath("//a[contains(text(),'Table')]");
		@FindBy (xpath= "")
		WebElement element;
		@FindBy (xpath="//table[@class='table table-striped table-bordered table-sm dataTable']//td[6]")
		List<WebElement> salaryColoum;
		public TablePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public void ElementClick() {
			WebElement TableHeader= driver.findElement(table_header);
			TableHeader.click();
			
		}
		public List<String> getEmployeeNames() {
			utility= new Utility(driver);
			List <String> names = new ArrayList<String>();
			names =utility.getTextOfElements("//table[@class='table table-striped table-bordered table-sm dataTable']//tbody//tr//td[1]");
			return names;
			
			
		}
		
		public void printSalaries() {
			
			utility = new Utility(driver);
			List<String> salarytable = new ArrayList<String>();
			salarytable = utility.getTextOfElements(salaryColoum);
			System.out.println(salarytable);
			
		}

	}

