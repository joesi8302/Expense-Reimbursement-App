import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.ReimbPOM;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Thread.sleep(5000);

        driver.get("http://localhost:9000");

        ReimbPOM pom = new ReimbPOM(driver);

        pom.userLogin("test","password", "123.50","Selenium Reimbursement", "LODGING");



        pom.createReimb("123.50","Selenium Reimbursement", "LODGING");



        driver.quit();

    }
}
