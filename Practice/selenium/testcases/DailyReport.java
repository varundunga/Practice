package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DailyReport {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vdunga\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait d=new WebDriverWait(driver,20);
		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.get("http://botestapp/BOE/portal/1610272218/InfoView/logon.faces ");
		driver.findElement(By.cssSelector("input[id='_id0:logon:USERNAME']")).sendKeys("vdunga");
		driver.findElement(By.cssSelector("input[id='_id0:logon:PASSWORD']")).sendKeys("2019D0rm@n");
		driver.findElement(By.cssSelector("input[id='_id0:logon:logonButton']")).click();
		driver.findElement(By.cssSelector("a[title='Documents']")).click();
		// driver.switchTo().frame(driver.findElement(By.id("_yuiResizeMonitor")));
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@class='yui-layout-wrap']//iframe)[2]")));// id("_yuiResizeMonitor")));
		// driver.switchTo().frame(0);
		// // //Thread.sleep(10000);
		// driver.findElement(By.xpath("//a[@title='Expand Folders']")).click();

		 Thread.sleep(10000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Folders']")));//.click();
		 Thread.sleep(10000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='ygtvt8']/a[@class='ygtvspacer' ]")));//.click();
		 Thread.sleep(10000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='ygtvt36']/a[@class='ygtvspacer' ]")));//).click();
		 Thread.sleep(10000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='ygtvt41']/a[@class='ygtvspacer' ]")));//.click();
		 Thread.sleep(10000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='ygtvt46']/a[@class='ygtvspacer' ]")));//.click();
		 Thread.sleep(10000);
		d.until(ExpectedConditions.elementToBeClickable(By.id("accordionNavigationView_drawer1_treeView_treeNode51_name")));

		/*
		 * Actions a = new Actions(driver);
		 * a.moveToElement(driver.findElement(By.xpath("//a[text()='Folders']"))
		 * ).click() .moveToElement(driver
		 * .findElement(By.xpath("//td[@id='ygtvt8']/a[@class='ygtvspacer' ]")))
		 * .click() .moveToElement(driver
		 * .findElement(By.xpath("//td[@id='ygtvt36']/a[@class='ygtvspacer' ]"))
		 * ) .click() .moveToElement(driver
		 * .findElement(By.xpath("//td[@id='ygtvt41']/a[@class='ygtvspacer' ]"))
		 * ) .click() .moveToElement(driver
		 * .findElement(By.xpath("//td[@id='ygtvt46']/a[@class='ygtvspacer' ]"))
		 * ) .click() .moveToElement(driver.findElement(By.id(
		 * "accordionNavigationView_drawer1_treeView_treeNode51_name")))
		 * .click().build().perform(); //
		 * driver.findElement(By.xpath("//a[text()='Folders']")).click();//(
		 * "a#yui-gen0-2-label.yui-accordion-toggle")).click(); //
		 * td[@id='ygtvt8']/a[@class='ygtvspacer' ]
		 */

	}

}