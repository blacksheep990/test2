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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('https://soda-int.e.corpintra.net/soda/')

// WebUI.setViewPortSize(1550, 1050)
WebUI.maximizeWindow()

String ExpectedValue = 'VBH1 PhosSG'

WebUI.click(findTestObject('Messwerte/Kontrollgang'))

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//table[@mkr="dataTbl.hdn"]/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

// println(Rows.size())
table: for (int i = 0; i < Rows.size(); i++) {
    'To locate columns(cells) of that specific row'
    List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

    // println(Cols.size())
    for (int j = 0; j < Cols.size(); j++) {
        //	 Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)
        //  println(Cols.get(j).getText())
        'Verifying the expected text in the each cell'
        if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)) {
            Cols.get(j).click()

            break table 
            
            //println('Wert gefunden '+Cols.get(j).getText())
            // Cols.get(3).click()
            'To locate anchor in the expected value matched row to perform action'
        }
    }
}

WebUI.scrollToElement(findTestObject('Messwerte/MenuKontrollgang/Button Filter'), 1000)

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/Button Filter'))

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TabelleMessstellen/FirstRow'))

WebUI.waitForElementPresent(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TopRowButtons/ButtonErfassen'), 
    1000)

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TopRowButtons/ButtonErfassen'))

WebUI.scrollToElement(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'), 
    1000)

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'))

WebUI.setText(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'), '3')

WebUI.mouseOver(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

Thread.sleep(1000)

WebUI.verifyElementText(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TabelleMessstellen/MesswertFieldReihe1'), 
    '3,2')

WebUI.scrollToElement(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'), 
    1000)

WebUI.sendKeys(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'), '2')

WebUI.mouseOver(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.verifyElementPresent(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/Fehlermeldung'), 0)

WebUI.sendKeys(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/UrsacheMasnahme'), 'test')

WebUI.mouseOver(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.mouseOver(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TabelleMessstellen/MesswertFieldReihe2'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TabelleMessstellen/MesswertFieldReihe2'), 
    '1,9')

Thread.sleep(1000)

WebUI.scrollToElement(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'), 
    1000)

WebUI.setText(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/FieldMesswert'), '1,3')

WebUI.mouseOver(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.waitForElementPresent(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/Fehlermeldung'), 1000)

WebUI.verifyElementText(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/Fehlermeldung'), 'Der berechnete Messwert 1,401380 hat die Grenzen überschritten. Zur Berechnung wurde die Formel f(x) = 0,1110 + 0,9926x + 0,0000x² verwendet. Ändern Sie den Messwert oder geben Sie eine \'Ursache/Maßnahme\' ein.')

WebUI.sendKeys(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/UrsacheMasnahme'), 'test1')

WebUI.mouseOver(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.click(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/BottomTable/ButtonSpeichern'))

WebUI.verifyElementText(findTestObject('Messwerte/MenuKontrollgang/SpezifischerKontrollgangMenu/TabelleMessstellen/MesswertFieldReihe3'), 
    '1,4')

WebUI.closeBrowser()

