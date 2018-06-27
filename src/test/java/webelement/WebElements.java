package webelement;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {
	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	@Test
	public void myLinks(){
		driver.get("https://github.com");
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int numberoflinksongithub=links.size();
		System.out.println("Number of links: "+numberoflinksongithub);
	    for(WebElement str :links){
	    	if(!str.getText().isEmpty()){
	    	System.out.println(str.getText());
	    	}
	    	
	    }
	    //add each link tag text into a list of Stings
		List<String> ls=new ArrayList<>();
		 for(WebElement str :links){
			 if(!str.getText().isEmpty()){
		      // ls.add(links.iterator().toString());
				 ls.add(str.getText());
			 }
		 }
		 System.out.println(ls.toString());
		 List<WebElement> elems=driver.findElements(By.className(""));
		 assertEquals(elems.size(),10);
	}
	//=======================================
	@Test
	public void SeleniumWebEelementsForm(){
		//Homework:
	        /*  Loop through each inputbox and enter random names
	         *  Loop through each dropDown and randomly select by index
	         *  Loop through each checkBoxes and select each one
	         *  Loop through each radioButton and click one by one by waiting one second intervals
	         *  click all buttons
	         */
	
		driver.get("https://forms.zohopublic.com/murodil/form"
				+ "/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> inputBox=driver.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> dropDown=driver.findElements(By.tagName("select"));
		List<WebElement> checkBox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> radioButton=driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> button=driver.findElements(By.tagName("button"));
		assertEquals(inputBox.size(),2);
		assertEquals(dropDown.size(),3);
		assertEquals(checkBox.size(),9);
		assertEquals(radioButton.size(),9,"Message will show if it fails");
		assertEquals(button.size(),1,"Message will show if it fails");
		Faker f=new Faker();
		
		 for(WebElement str : inputBox ){
			 str.sendKeys(f.name().fullName());			 
		 }
		 for(WebElement str : dropDown){
			 Select st=new Select(str);
			 st.selectByIndex(f.number().numberBetween(1, 4));
		 }
		
		 for(int i=0 ;i<checkBox.size() ;i+=3 ){
			
			 checkBox.get(f.number().numberBetween(0, 3)+i).click();;
			 
		 }
		 for(int i=0 ;i<radioButton.size() ;i+=3 ){
			 radioButton.get(f.number().numberBetween(0, 3)+i).click();		 	
	     }
		 button.get(0).click();
	}
	//===============================================
	@Test
    public void slideShow() throws InterruptedException {
        driver.get("https://www.hbloom.com/Gifts/birthday-flowers");
        List<WebElement> images = driver.findElements(By.tagName("img"));
        List<String> srcs = new ArrayList<>();
        
        for(WebElement flower: images) {
            srcs.add(flower.getAttribute("src"));
        }
        
        for (String link : srcs) {
            driver.get(link);
            Thread.sleep(1234);
        }
	}
}
