 package Niit;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RolePlay {

			public static void main(String[] args) throws InterruptedException  {
				// TODO Auto-generated method stub

				
				System.setProperty("webdriver.chrome.driver","G:/WorkSpace/Myproject1/exefiles/chromedriver.exe");
				WebDriver driver = new ChromeDriver(); 	
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			    driver.get("https://metlifedap.niit-mts.com/en/");
			    driver.findElement(By.name("username"));
			    WebElement email = driver.findElement(By.name("username"));							

		        // Get the WebElement corresponding to the Password Field		
		        WebElement password = driver.findElement(By.name("password"));
			    
			    email.sendKeys("MIPPRD_IT05");					
		        password.sendKeys("Metlife1");
		        driver.findElement(By.id("send2")).click();
		        Thread.sleep(5000);
		        driver.findElement(By.id("box-3")).click();
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("//a[contains(text(),'Asignar a la usuaria')]")).click();
		        Select category = new Select(driver.findElement(By.id("category")));
		        category.selectByVisibleText("Enfoque");
		        Thread.sleep(5000);
		        
		        Select scenario = new Select(driver.findElement(By.id("scenario_title")));
		        scenario.selectByVisibleText("Approach Scenario 1");
		        
		        Thread.sleep(5000);
		        //Select Month
		        driver.findElement(By.id("target_d")).click();
		        String expMonth="Diciembre";
		        
		        String CurrentMon=driver.findElement(By.xpath("//div[contains(@class,'xdsoft_label xdsoft_month')]//span")).getText();
		        System.out.println(CurrentMon);
		        if(expMonth.equals(CurrentMon))
		        {
		        	System.out.println("Month is already selected");
		        }
		        else
		        {
		        	for(int i=1;i<12;i++)
		        	{
		        		driver.findElement(By.xpath("(//button[contains(@class,'xdsoft_next')])[1]")).click();
		        		Thread.sleep(1000);
		        		CurrentMon=driver.findElement(By.xpath("//div[contains(@class,'xdsoft_label xdsoft_month')]//span")).getText();
		        		if(expMonth.equals(CurrentMon))
		        		{
		        			System.out.println("Month selected");
		        			break;
		        			
		        		}
		        	}
		        }
		        //Select Date
		        Thread.sleep(1000);
		        WebElement datepicker=driver.findElement(By.xpath("//div[contains(@class,'xdsoft_calendar')]//table//tbody"));
		        List<WebElement> dates=datepicker.findElements(By.tagName("td"));
		        for(WebElement date : dates)
		        {
		        	String calDate=date.getAttribute("data-date");
		        	if(calDate.equals("31"))
		        	{
		        		date.click();
		        		break;
		        		
		        	}
		        }
		        
		        
		       
		       try {
		            File src= new File("G:/WorkSpace/Myproject1/inputdata/testData.xlsx");

		            FileInputStream fis=new FileInputStream(src);

		            XSSFWorkbook wb=new XSSFWorkbook(fis);

		            XSSFSheet Sheet1=wb.getSheetAt(0);

		            int rowcount=Sheet1.getLastRowNum();

		            for(int i=1;i<rowcount;i++) {

		            String data0=Sheet1.getRow(i).getCell(0).getStringCellValue(); 
		            driver.findElement(By.xpath("//span[contains(text(),'Participantes')]")).click();
				       Thread.sleep(2000);
				       driver.findElement(By.id("partSearch")).click();
		            driver.findElement(By.id("partSearch")).sendKeys(data0);
		           
		            driver.findElement(By.id("partSearchSub")).click();
		            Thread.sleep(2000);
		            driver.findElement(By.id("participant_1")).click();
				    driver.findElement(By.id("participant_close")).click();
		            
				    Thread.sleep(4000);
		            //print the value from excel to textbox and split the data in textbox 
		           
		                 for(int j=i;j<=i;j++) {

			            String data1=Sheet1.getRow(j).getCell(1).getStringCellValue(); 
			           System.out.println(data1);
			            driver.findElement(By.xpath("//span[contains(text(),'Revisoras')]")).click();
			            Thread.sleep(2000);
			            driver.findElement(By.id("reviewSearch")).sendKeys(data1);
			            Thread.sleep(2000);
			            driver.findElement(By.id("revSearchSub")).click();
			            Thread.sleep(1000);
			            driver.findElement(By.id("reviewer_1")).click();
					    driver.findElement(By.id("reviewer_close")).click();
			            }
		            }
  
		            wb.close();
		            //close of try catch block    
		            
		        } catch (IOException e) {
		        }
		       
		       
		    
		   


	}

			

}
