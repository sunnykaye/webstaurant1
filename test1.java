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
            d.get("https://www.webstaurantstore.com/");

            WebElement search = d.findElement(By.id("searchval"));
            search.sendKeys("stainless work table");
            search.submit();

            // Validate all  titles have "table"
            boolean allTable = true;
            java.util.List<WebElement> titles = d.findElements(By.xpath("//a[@class='description']"));
            for (WebElement t : titles) {
                if (!t.getText().toLowerCase().contains("table")) {
                    allTable = false;
                    break;
                }
            }
            System.out.println("Table is in all titles: " + allTable);


            // Add last item to cart
            WebElement product = titles.get(titles.size() - 1);
            product.click();
            WebElement addButton = d.findElement(By.id("buyButton"));
            addButton.click();

            WebDriverWait wait = new WebDriverWait(d, 10);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cartItemCountSpan"), "1"));



            // Empty Cart
            WebElement cartButton = d.findElement(By.id("cartItemCountSpan"));
            cartButton.click();
            WebElement emptyButton = d.findElement(By.xpath("//a[@class='emptyCartButton']"));
            emptyButton.click();

            
            System.out.println("Cart is clear");
        } finally {      
             d.quit();
        } 
    }

    /* Hi there! I usually code with JavaScript & Mocha, 
    but here is my submission in Java with Maven. 
    Thank you for your time and consideration.
    Sunny Khandokar.
    */ 

}
