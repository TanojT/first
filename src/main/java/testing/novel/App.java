package testing.novel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args ) throws IOException
    {   
        final String path = "src/drivers/chromedriver.exe";
        final String url  ="https://novelfull.net/emperors-domination/chapter-1-three-demon-master-1.html";
        final String outputPath="src/output/Emperor_Domination.txt";
        BufferedWriter writer= new BufferedWriter(new FileWriter(outputPath ));
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);
        List<WebElement> element=driver.findElement(By.xpath("//*[@id='chapter-content']")).findElements(By.tagName("p"));
        for(WebElement e:element){
            writer.write(e.getText());
            writer.write("\n");
        }
        writer.close();
        driver.quit();
        
    }
}
