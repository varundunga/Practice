package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Objects {
	
	 @FindBy(css="id#_id0:logon:USERNAME")
	  WebElement userName;
	 
	 @FindBy(css="input#_id0:logon:PASSWORD")
	  WebElement password;
	 
	 By a=(By.cssSelector("id#_id0:logon:USERNAME"));

}
