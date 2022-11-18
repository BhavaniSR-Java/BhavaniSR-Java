package testPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IMDBWIKI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Bhavani\\CodingTest\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.imdb.com/");
		System.out.println("Details In IMDB");
		driver.findElement(By.id("suggestion-search")).sendKeys("Pushpa");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
		//driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
		//Thread.sleep(10000);
		
		//WebElement details=driver.findElement(By.xpath("//*[text()='Details']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Details']")));
		// Extract country name
		WebElement countryName1=driver.findElement(By.xpath("//*[text()='Country of origin']//parent::li//child::a"));
		
		String country=countryName1.getText();
		System.out.println("IMDB : Coutry name:");
		System.out.println(country);
		// Extract Release Date
WebElement releaseDate1=driver.findElement(By.xpath("(//a[text()='Release date']//parent::li//child::a[contains(@href,'releaseinfo?ref_=tt_dt_rdat')])[2]"));
		
		String release=releaseDate1.getText();
		System.out.println("IMDB Release Date:");
		System.out.println(release);
		
		// Wiki Program
		System.out.println();
		System.out.println("Details In Wiki");
		
driver.get("https://en.wikipedia.org/");
		
		driver.findElement(By.name("search")).sendKeys("Pushapa 1");
		driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='mw-search-result-heading']//a)[1]")).click();
		String releaseDate=driver.findElement(By.xpath("//div[text()='Release date']")).getText();
		
		String date=driver.findElement(By.xpath("//div[text()='Release date']//parent::th//following-sibling::td")).getText();
		
		System.out.println(releaseDate+":"+date);
		String countryText=driver.findElement(By.xpath("//th[text()='Country']")).getText();
		
		String countryName=driver.findElement(By.xpath("//th[text()='Country']//parent::th//following-sibling::td")).getText();
		System.out.println(countryText+"="+countryName);
		

	}

}
