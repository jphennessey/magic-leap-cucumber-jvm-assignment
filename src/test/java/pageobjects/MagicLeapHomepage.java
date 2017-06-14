package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MagicLeapHomepage extends BaseClass {

    public MagicLeapHomepage(WebDriver driver) {
        super(driver);
    }

    //-----------  S O C I A L    L I N K S  ----------------------------------------|
    private static final String XPATH_socialPrefix = "//div[@id='signup']";

    @FindBy(xpath = XPATH_socialPrefix + "//a[contains(@href,'facebook')]")
    public static WebElement LINK_facebook;

    @FindBy(xpath = XPATH_socialPrefix + "//a[contains(@href,'twitter')]")
    public static WebElement LINK_twitter;

    @FindBy(xpath = XPATH_socialPrefix + "//a[contains(@href,'plus.google')]")
    public static WebElement LINK_googlePlus;

    @FindBy(xpath = XPATH_socialPrefix + "//a[contains(@href,'linkedin')]")
    public static WebElement LINK_linkedIn;


    @FindBy(id = "volume-control")
    private WebElement DIV_toggleVolume;

    public boolean isVolumeMuted() {
        return (DIV_toggleVolume.getAttribute("class").contains("hide-mute") == false);
    }

    public void muteVolume() {
        if (!isVolumeMuted()) {
            DIV_toggleVolume.click();
        }
    }

    public void unMuteVolume() {
        if (isVolumeMuted()) {
            DIV_toggleVolume.click();
        }
    }
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	