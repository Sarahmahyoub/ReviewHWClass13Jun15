package HW;

import Utils.Constants;
import Utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

//Create an Excel file for these fields store the data in Excel,
// read it, and insert on this webpage using selenium.
public class HW01 extends Constants {
    public static void main(String[] args) throws InterruptedException {

        List<Map<String, String>> empData = ExcelReader.read(EXCEL_FILE_PATH, "Sheet1");

        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();


        for (Map<String, String> map : empData) {

            driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
            driver.findElement(By.xpath("  //a[@id='menu_pim_addEmployee']")).click();
            String firstName = map.get("FirstName");
            String middleName = map.get("MiddleName");
            String lastName = map.get("LastName");
            driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);

            driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(middleName);

            driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);

            driver.findElement(By.xpath(" //input[@id='btnSave']")).click();

            driver.findElement(By.xpath("//input[@value='Edit']")).click();

            String DL = map.get("DL");
            String SSN = map.get("SSN");
            String sinNum = map.get("SIN NUM");
            String milService = map.get("MILITARY SER");
            String Nationality = map.get("Nationality");
            String maritalStatus = map.get("Marital Status");
            String nickName = map.get("Nick Name");

            driver.findElement(By.xpath("//input[@id='personal_txtLicenNo']")).sendKeys(DL);

            driver.findElement(By.xpath("//input[@id='personal_txtLicExpDate']")).click();

            WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            Select sel = new Select(monthDropdown);
            sel.selectByVisibleText("Aug");

            WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
            Select sel1 = new Select(yearDropdown);
            sel1.selectByVisibleText("2027");

            WebElement day=driver.findElement(By.xpath("//*[text()='10']"));
            day.click();

            driver.findElement(By.xpath("//input[@id='personal_txtNICNo']")).sendKeys(SSN);
            driver.findElement(By.xpath("//input[@id='personal_txtSINNo']")).sendKeys(sinNum);

            driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();

            driver.findElement(By.xpath("//select[@name='personal[cmbNation]']")).sendKeys(Nationality);
            driver.findElement(By.xpath("//select[@name='personal[cmbMarital]']")).sendKeys(maritalStatus);

           driver.findElement(By.xpath("//input[@id='personal_DOB']")).click();

           WebElement monthDropdown2 = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

           Select sel2 = new Select(monthDropdown2);
          sel2.selectByVisibleText("Aug");

          WebElement yearDropdown2 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

          Select sel3 = new Select(yearDropdown2);
          sel3.selectByVisibleText("2027");

          WebElement day1=driver.findElement(By.xpath("//*[text()='10']"));
          day1.click();

          driver.findElement(By.xpath("//input[@name='personal[txtEmpNickName]']")).sendKeys(nickName);

          driver.findElement(By.xpath("//input[@id='personal_txtMilitarySer']")).sendKeys(milService);


          driver.findElement(By.xpath(" //input[@id='btnSave']")).click();


        }


           }

      }

