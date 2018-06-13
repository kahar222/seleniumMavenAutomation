package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "/Users/anaf/Documents/Selenium Dependencies/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		//fullscreen
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dice.com");
		driver.findElement(By.id("search-field-keyword")).sendKeys("java developer");
		driver.findElement(By.id("search-field-location")).sendKeys("22102");
		driver.findElement(By.id("findTechJobs")).submit();
		String count=driver.findElement(By.id("posiCountMobileId")).getText();
		//ensure count is more than 0
		String keyword="java developer";
		String location="22102";
		System.out.println(count);
		int countResult=Integer.parseInt(count.replace(",", ""));
		if(countResult>0){
			System.out.println("Step PASS: "+keyword+" search return "+countResult+" result in "+location);
			
		}else{
			System.out.println("Step FAIL: "+keyword+" search return "+countResult+" result in "+location);
		}
		driver.close();
	}

}
