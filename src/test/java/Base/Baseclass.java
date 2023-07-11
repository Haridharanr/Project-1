package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
		
	 public static WebDriver driver;
	   
		public static  WebDriver chromeBrowser() {     // Chromebrowser launch 
			WebDriverManager.chromedriver().setup();
			 driver =new ChromeDriver();
			return driver;
		}
		
		public static void urllaunch(String url) {     //Url launch
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		public static void timeout(int time) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

		}
		
		public static void sendkeys(WebElement a, String b) {
			a.sendKeys(b);

		}
		
		public static void click(WebElement a) {
			a.click();
		}
			
		public static void clear(WebElement a) {
			a.clear();
		}
		
		public static void quit() {
			driver.quit();
		}
		
		public static String getcurrenturl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
		
		public static String gettitle() {
			String title = driver.getTitle();
			return title;

		}
		
		public static String gettext (WebElement a) {
			String gettext = a.getText();
			return gettext;
		}
		
		public static String getAttribute(WebElement a) {
			String attribute = a.getAttribute("value");
			return attribute;

		}
		
		public static void movetoelement(WebElement a) {
			Actions a1 = new Actions(driver);
			a1.moveToElement(a).perform();

		}
		
		public static void draganddrop (WebElement src,WebElement tar) {
			Actions a2 = new Actions(driver);
			a2.dragAndDrop(src, tar).perform();

		}
		
		public static void selectbyindex(WebElement a,int b) {
			Select s = new Select(a);
			s.selectByIndex(b);
		}
		
		public static void selectbyvalue(WebElement a,String b) {
			Select s1 =new Select(a);
			s1.selectByValue(b);

		}
		
		public static void selectbyvisibletext(WebElement a, String b) {
			Select s2 = new Select(a);
			s2.selectByVisibleText(b);
		}
		
		
		public static void Browserlaunch(String bname ) {
			if(bname.equalsIgnoreCase("chrome") ) {
				WebDriverManager.chromedriver().setup();
				driver =new ChromeDriver();
			}else if(bname.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver =new EdgeDriver();
				
			}

		}
		
		
		public static String readexcel(String Filename, String Sheet,int row,int cell) throws IOException {
			File f=new File("C:\\Users\\ADMN\\eclipse-workspace\\Maven-Launch\\src\\test\\resources\\Excel\\"+Filename+".xlsx");

			// We read a file at that function we having fileinputstream
			
			FileInputStream ft =new FileInputStream(f);
			Workbook w =new XSSFWorkbook(ft);
			Sheet s = w.getSheet(Sheet);
			Row r = s.getRow(row);
			Cell ce = r.getCell(cell);	
			int type = ce.getCellType();
			String value=null;
			if(type==1) {
				value = ce.getStringCellValue();
			}else {
				if(DateUtil.isCellDateFormatted(ce)) {
					Date dateCellValue = ce.getDateCellValue();
					SimpleDateFormat sd =new SimpleDateFormat();
					value = sd.format(dateCellValue);
				}else {
					double numericCellValue = ce.getNumericCellValue();
					long num=(long)numericCellValue;
					 value=String.valueOf(num);
					
				}
			}
			return value;

		}
		
		
		
		
		
		
		



	


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}
