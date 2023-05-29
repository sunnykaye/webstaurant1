import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebstaurantStoreAutomation {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver d = new ChromeDriver();

        try {
            driver.get("https://www.webstaurantstore.com/");

            WebElement search = d.findElement(By.id("searchval"));
            search.sendKeys("stainless work table");
            search.submit();

            boolean allTable = true;
            java.util.List<WebElement> titles = d.findElements(By.xpath("//a[@class='description']"));
            for (WebElement t : titles) {
                if (!t.getText().toLowerCase().contains("table")) {
                    allTable = false;
                    break;
                }
            }
            System.out.println("Table is in all titles: " + allTable);
