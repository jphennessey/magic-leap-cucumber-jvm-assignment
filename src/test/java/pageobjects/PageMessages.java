package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageMessages extends BaseClass {

	public PageMessages(WebDriver driver) {
		super(driver);
	}

	private static final String expectedThankYouMessage = "thanks for reaching out...";
	private List getWordLengths(String message) {
		List<Integer> result = new ArrayList<Integer>();
		int index = 0;
		for (String word: message.split(" ")) {
			result.add(word.length());
		}
		return result;
	}
	private String CSS_thankYouCharPattern = "#thankyou h1 .word%d span.char%d";
	private void waitForCompleteMessage(WebDriver driver, List<Integer> wordLengths) {
		int totalWords = wordLengths.size();
		WebDriverWait wait = new WebDriverWait(driver, 1, 50);
		for (int wordIndex=1; wordIndex<=totalWords; wordIndex++) {
			Integer length = wordLengths.get(wordIndex-1);
			for (int charIndex=1; charIndex<=length; charIndex++) {
				String css = String.format(CSS_thankYouCharPattern, wordIndex, charIndex); // length);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
			}
		}
	}

	private By BY_thankYouMessage = By.cssSelector("#thankyou h1");
	public String getThankYouMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		List<Integer> expectedWordLengths = getWordLengths(expectedThankYouMessage);
		waitForCompleteMessage(driver, expectedWordLengths);
		String result = driver.findElement(BY_thankYouMessage).getText();
		return result;
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	