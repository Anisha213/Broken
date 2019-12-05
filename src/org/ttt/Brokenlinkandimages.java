package org.ttt;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Brokenlinkandimages {
		
				public static void main(String[] args) throws IOException  {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\.eclipse\\java-2019-093\\eclipse\\Ani\\Selenium\\Driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.snapdeal.com/");
List<WebElement> l = driver.findElements(By.tagName("a"));
int size = l.size();
System.out.println(size);
int count=0;
for (WebElement links : l) {
	String linkNames = links.getAttribute("href");
	if (!(linkNames==null)) {
		URL url = new URL (linkNames);
		URLConnection o = url.openConnection();
		HttpsURLConnection h= (HttpsURLConnection)o;
	int Code = h.getResponseCode();
 
if (!(Code==200)) {
	count ++;
	System.out.println(linkNames);
}
	}
	}
	System.out.println(count);
		
				}
}
