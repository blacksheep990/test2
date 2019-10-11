import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

WebUI.openBrowser('https://soda-int.e.corpintra.net/soda/')

String ExpectedValue = 'VBH1 PhosSG'

WebUI.click(findTestObject('Messwerte/Kontrollgang'))

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//table[@mkr="dataTbl.hdn"]/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

println(Rows.size())

loop:

table: for (int i = 0; i < Rows.size(); i++) {
	
   'To locate columns(cells) of that specific row'
   
  
	
   List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
   
 println(Cols.size())
	
 for (int j = 0; j < Cols.size(); j++) {
	 
//	 Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)
	
   'Verifying the expected text in the each cell'
	
   println(Cols.get(j).getText())
   	   
			   if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)) {
				   
					  
					  //println('Wert gefunden '+Cols.get(j).getText())
					  Cols.get(j).click()
					  
					 
					 
				  'To locate anchor in the expected value matched row to perform action'
				  
				 
				 // Cols.get(3).click()
				 
				
				   
				  break loop
				  
			   
		   } }
}   
		
   
   
	  
   

 




