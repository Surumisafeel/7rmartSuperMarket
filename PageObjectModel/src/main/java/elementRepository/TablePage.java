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
	int j=0;

	Utility utility;
	By table_header = By.xpath("//a[contains(text(),'Table')]");
	@FindBy(xpath = "")
	WebElement element;
	@FindBy(xpath = "//table[@class='table table-striped table-bordered table-sm dataTable']//td[6]")
	List<WebElement> salaryColoum;
	
//	@FindBy(xpath="//tbody/tr[" + j + "]/td[3]")
//	WebElement textElement;//this is not possible since it is not a constant.

	@FindBy(xpath = "//tbody//tr//td[1]")
	List<WebElement> nameElements;

	public TablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ElementClick() {
		WebElement TableHeader = driver.findElement(table_header);
		TableHeader.click();

	}

	public List<String> getEmployeeNames() {
		utility = new Utility(driver);
		List<String> names = new ArrayList<String>();
		names = utility.getTextOfElements(
				"//table[@class='table table-striped table-bordered table-sm dataTable']//tbody//tr//td[1]");
		return names;

	}

	public void printSalaries() {

		utility = new Utility(driver);
		List<String> salarytable = new ArrayList<String>();
		salarytable = utility.getTextOfElements(salaryColoum);
		System.out.println(salarytable);

	}

	public String getPersonsOffice(String personName) {
		//// ] -cedric
		int i;
		utility = new Utility(driver);
		List<String> names = new ArrayList<String>();
		names = utility.getTextOfElements(nameElements);
		// System.out.println(names);
		for (i = 0; i < names.size(); i++) {
			if (names.get(i).equals(personName)) {
				i++;
				break;
			}
		}

		WebElement officeElement = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]"));
		return officeElement.getText();
	}
}
