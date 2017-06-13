package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BaseClass{
	
	public ContactPage(WebDriver driver)
	{
		super(driver);
		initPage(driver);
	}

	//-----------  A D D R E S S  ------------------------------------------------------------|
	@FindBy(css = "h1.ng-binding")
	private WebElement TEXT_fullCompanyAddress;
	public boolean isFullCompanyAddressDisplayed() {
		return TEXT_fullCompanyAddress.isDisplayed();
	}
	public String getFullCompanyAddress() {
		return TEXT_fullCompanyAddress.getText().trim();
	}
	public boolean companyAddressContains(String expected) {
		String fullAddress = getFullCompanyAddress();
		return (fullAddress.contains(expected));
	}
	public String[] parseCompanyAddress() {
		String fullAddress = getFullCompanyAddress();
		String[] addressComponents = fullAddress.split("/");
		return addressComponents;
	}
	public enum ADDRESS_ELEMENT {STREET, CITY, STATE, ZIP};
	public String getCompanyAddressElement(ADDRESS_ELEMENT address_element) {
		String[] elements = parseCompanyAddress();
		String result = "NOT FOUND!";
		int index = address_element.ordinal();
		int size = elements.length;
		if (size > index) {
			result = elements[index].trim();
		} else {
			throw new IllegalStateException("Parsed string array of address elements only has size " + elements.length);
		}
		return result;
	}
	public boolean addressElementMatches(ADDRESS_ELEMENT address_element, String expected) {
		return (getCompanyAddressElement(address_element).equals(expected));
	}

	//-----------  C O N T A C T   F O R M  ----------------------------------------------------|
	@FindBy(id = "firstname")
	public WebElement INPUT_contactFirstname;

	@FindBy(id = "lastname")
	public WebElement INPUT_contactLastname;

	@FindBy(id = "email")
	public WebElement INPUT_contactEmail;

	@FindBy(id = "phone")
	public WebElement INPUT_contactPhone;

	@FindBy(id = "company")
	public WebElement INPUT_contactCompany;

	@FindBy(id = "message")
	public WebElement TEXTAREA_contactMessage;

	@FindBy(xpath = "//select")
	public WebElement PROTOSELECT_contactInquiryType;

	public enum INQUIRY_TYPE {
		UNSELECTED("*Inquiry Type"),
		EDUCATION("Education"),
		PARTNERSHIP("Partnership"),
		PUBLIC_RELATIONS("Public Relations"),
		GENERAL("General");

		private String optionValue;
		INQUIRY_TYPE(String optionValue) {
			this.optionValue = optionValue;
		}
		public String getOptionValue() {
			return this.optionValue;
		}
	}
	public void selectContactInquiryType(INQUIRY_TYPE inquiry_type) {
		Select SELECT_inquiryType = new Select(PROTOSELECT_contactInquiryType);
		SELECT_inquiryType.selectByValue(inquiry_type.getOptionValue());
	}

	@FindBy(css = "[type='submit']")
	public WebElement BUTTON_contactFormSubmit;


}
