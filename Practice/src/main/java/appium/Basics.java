package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			DesiredCapabilities capabilities = new DesiredCapabilities();
			        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
			        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "32085c3010e5710b");
			        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			        capabilities.setCapability("appPackage", "com.example.android.messagingservice");
			        capabilities.setCapability("appActivity","com.example.android.messagingservice.MainActivity");
					
					URL u=null;
					try {
						u = new URL("http://127.0.0.1:4723/wd/hub");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				WebDriver driver=new RemoteWebDriver(u,capabilities); 
				
				

	}

}