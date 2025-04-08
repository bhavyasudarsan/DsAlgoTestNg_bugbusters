package dsAlgo_Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {

	public static void enterCodePractice(WebDriver driver, String code, WebElement element) throws InterruptedException {
	    
	    Actions actions = new Actions(driver);

	    actions.click(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
	   
	    String[] lines = code.split("\n");

	    for (String line : lines) {
	       
	        actions.sendKeys(Keys.HOME).perform();
	        
	        int leadingSpaces = countLeadingSpaces(line);
	        int leadingTabs = countLeadingTabs(line);

	        for (int i = 0; i < leadingSpaces; i++) {
	            actions.sendKeys(Keys.SPACE).perform();
	        }

	        for (int i = 0; i < leadingTabs; i++) {
	            actions.sendKeys(Keys.TAB).perform();
	        }
	        
	        actions.sendKeys(line.trim()).perform();

	        actions.sendKeys(Keys.RETURN).perform();
	    }
	}
	private static int countLeadingSpaces(String line) {
	    int count = 0;
	    while (count < line.length() && line.charAt(count) == ' ') {
	        count++;
	    }
	    return count;
	}

	private static int countLeadingTabs(String line) {
	    int count = 0;
	    while (count < line.length() && line.charAt(count) == '\t') {
	        count++;
	    }
	    return count;
	}



}