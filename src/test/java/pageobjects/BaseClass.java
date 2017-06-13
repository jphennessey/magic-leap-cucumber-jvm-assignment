package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
	public static WebDriver driver;

	public BaseClass(WebDriver driver){
		this.driver = driver;
		initPage(driver);
	}
	public void initPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	//----------- H E A D E R   L I N K S ----------------------------------------|
	private static final String XPATH_headerPrefix = "//div[@id='nav-wrapper']";

	@FindBy(xpath = "//div[@id='logo-wrapper']/a")
    @CacheLookup
    public static WebElement LINK_TOP_returnHome;

	@FindBy(xpath = XPATH_headerPrefix + "//a[text()='ABOUT US']")
    @CacheLookup
    public static WebElement LINK_TOP_aboutUs;

	@FindBy(xpath = XPATH_headerPrefix + "//a[text()='DEVELOPERS']")
    @CacheLookup
    public static WebElement LINK_TOP_developers;

	@FindBy(xpath = XPATH_headerPrefix + "//a[text()='BLOG']")
    @CacheLookup
	public static WebElement LINK_TOP_blog;

	@FindBy(xpath = XPATH_headerPrefix + "//a[text()='WIZARDS WANTED']")
    @CacheLookup
	public static WebElement LINK_TOP_careers;

	@FindBy(xpath = XPATH_headerPrefix + "//a[text()='PRESS']")
    @CacheLookup
	public static WebElement LINK_TOP_press;

	@FindBy(xpath = XPATH_headerPrefix + "//a[text()='CONTACT']")
    @CacheLookup
	public static WebElement LINK_TOP_contact;

	//----------- F O O T E R   L I N K S ---------------------------------------------->
	private static final String XPATH_footerPrefix = "//div[@id='footer-nav-wrapper']";

	@FindBy(xpath = XPATH_footerPrefix + "//a[text()='ABOUT US']")
    @CacheLookup
	public static WebElement LINK_BOTTOM_aboutUs;

	@FindBy(xpath = XPATH_footerPrefix + "//a[text()='DEVELOPERS']")
    @CacheLookup
	public static WebElement LINK_BOTTOM_developers;

	@FindBy(xpath = XPATH_footerPrefix + "//a[text()='BLOG']")
    @CacheLookup
	public static WebElement LINK_BOTTOM_blog;

	@FindBy(xpath = XPATH_footerPrefix + "//a[text()='WIZARDS WANTED']")
    @CacheLookup
	public static WebElement LINK_BOTTOM_careers;

	@FindBy(xpath = XPATH_footerPrefix + "//a[text()='PRESS']")
    @CacheLookup
	public static WebElement LINK_BOTTOM_press;

	@FindBy(xpath = XPATH_footerPrefix + "//a[text()='CONTACT']")
    @CacheLookup
	public static WebElement LINK_BOTTOM_contact;

	//----------- l e g a l    l i n k s  ----------------------------------------|
	@FindBy(linkText = "privacy policy")
    @CacheLookup
	public static WebElement LINK_privacyPolicy;

	@FindBy(linkText = "terms of use")
    @CacheLookup
	public static WebElement LINK_termsOfUse;
}
