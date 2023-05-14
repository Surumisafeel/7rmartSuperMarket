package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Utility;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DatePickersPage {
	WebDriver driver;
	Utility utility;
	@FindBy(xpath = ("(//a[@class='nav-link'])[3]"))
	WebElement datePickerHeader;
	@FindBy(xpath = ("//input[@id='single-input-field']"))
	WebElement enterDate;
	@FindBy(xpath = ("//span[@id='basic-addon1']"))
	WebElement calendar;
	@FindBy(xpath = ("//thead//tr[2]//th[@class='prev']"))
	WebElement datePickerPrev;
	@FindBy(xpath = ("//thead//tr[2]//th[@class='next']"))
	WebElement datePickerNext;
	@FindBy(xpath = ("//div[@class='datepicker-days']//th[@class='datepicker-switch']"))
	WebElement monthYearElement;

	public DatePickersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void datePickerHeaderClick() {
		datePickerHeader.click();

	}

	public void selectDate(String date) {
		calendar.click();
		monthYearElement.getText();
		String split[] = date.split("-");
		String year = split[2];
		String day = split[0];
		String monthNumber = split[1];
		String month = "";
		int m = Integer.parseInt(monthNumber);
		int y=Integer.parseInt(year);
		switch (m) {
		case 01:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";

		}
		String month_year= month+" "+year;
		while(true) {
			String currentMonthText=monthYearElement.getText();
			if(currentMonthText.equals(month_year)) {
				break;
			}
				else if(m>4 && year.equals("2023")) {
					
					datePickerNext.click();
				}
				else if(y>2023) {
					datePickerNext.click();
				}
					
				else
					datePickerPrev.click();
			}
		driver.findElement(By.xpath("//td[@class='day' and text()="+day+"]")).click();
		}
	}

