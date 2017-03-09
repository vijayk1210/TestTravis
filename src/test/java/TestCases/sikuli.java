
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class sikuli {
	
	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\workspace\\chromedriver\\"
				+ "chromedriverlatest.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://cloudsovercuba.com/");
		
		driver.manage().window().maximize();
		 
		Screen screen = new Screen();
		
		Pattern image1 = new Pattern("E:\\sikuliImages\\flashBegin.png");
		Pattern image2 = new Pattern("E:\\sikuliImages\\flashJFkennedy.png");
		
		try {
			screen.wait(image1,5000);
			screen.click(image1);
			
			screen.wait(image2,4000);
			screen.click(image2);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.quit();
		
	}

}
