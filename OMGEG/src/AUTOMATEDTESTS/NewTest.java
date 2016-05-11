package AUTOMATEDTESTS;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewTest {
  @Test
  public void function() throws InterruptedException {
     
      //Instantiate the driver
      FirefoxDriver driver = new FirefoxDriver();
     
      //set the timeout so that the script wont fail if the object on page is not loaded imidiately
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     
      //start the browser and launch home page www.omgeo.com
      driver.navigate().to("http://www.omgeo.com");
     
      //Go to click the About tab 	
      driver.findElement(By.xpath("//a[@href='/aboutomgeo']")).click();
      
      //On the About Omgeo page select click
      driver.findElement(By.xpath("//span[contains(text(),'select')]")).click();
     
      Thread.sleep(2000);
      //Select the ALERT option from Select drop down
      driver.findElement(By.xpath("//div[@id='selectContainerProduct']//li[contains(text(),'ALERT')]")).click();
     
     //Verify that 	page navigated to the Omgeo Alert page
      Assert.assertEquals( (driver.findElements(By.xpath("//h1/span[contains(text(),'Omgeo ALERT')]")).size() > 0 ) , true , "text Omgeo ALERT not found") ;
     
      //Navigate to leadership team page 
      driver.findElement(By.xpath("//a[contains(text(),'Leadership Team')]")).click();
     
      //choose the link for Tony
      driver.findElement(By.xpath("//a[contains(@href,'/page/tony-freeman-bio')]")).click();
     
      Thread.sleep(2000);
     
     List<WebElement> MatchingWebElements = driver.findElements(By.xpath("//table/tbody/tr/td/em"));
     WebElement descriptionOfTony = (WebElement) MatchingWebElements.get(3);
     
     System.out.println("the designation of Tony is "+descriptionOfTony.getText());
     
     driver.quit();
     
     
  }
}