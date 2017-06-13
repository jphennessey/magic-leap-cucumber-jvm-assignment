package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.ContactFormAction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.ContactPage;
import pageobjects.PageMessages;


public class Steps {
    public WebDriver driver;

    public Steps()
    {
    	driver = Hooks.driver;
    }

    @Given("^I load the (home|contact) page$")
    public void i_load_the_homepage(String pageName) throws Throwable {
        String url = "https://www.magicleap.com/#/" + pageName;
        driver.get(url);
    }

    private String actualStreetAddress = null;
    @When("^I inspect the address$")
    public void i_inspect_the_address() throws Throwable {
        ContactPage contactPage = new ContactPage(driver);
        boolean ready = contactPage.isFullCompanyAddressDisplayed();
        if (ready) {
            actualStreetAddress = contactPage.getCompanyAddressElement(ContactPage.ADDRESS_ELEMENT.STREET);
            System.out.println("The address retrieved from the contact page is " + actualStreetAddress);
        } else {
            throw new IllegalStateException("Contact page: cannot retrieve address when it is not displayed!");
        }
    }

    @Then("^The street address is (\\d+[\\s\\w+]+)$")
    public void the_street_address_is(String expected) throws Throwable {
        Assert.assertEquals(actualStreetAddress, expected, "No match for expected street address, " + expected + "!");
    }

    @Then("^The street address is not (\\d+[\\s\\w+]+)$")
    public void the_street_address_is_not(String notExpected) throws Throwable {
        Assert.assertNotEquals(actualStreetAddress, "NOT FOUND!", "The Contact page street address was not found!");
        Assert.assertNotEquals(actualStreetAddress, notExpected, "The Contact page street address was not supposed to be " + notExpected + "!");
    }

    @When("^I complete the contact form$")
    public void i_complete_the_contact_form() throws Throwable {
        ContactFormAction.InputSampleData(new ContactPage(driver));
    }

    @When("^I submit the contact form$")
    public void i_submit_the_contact_form() throws Throwable {
        new ContactPage(driver).BUTTON_contactFormSubmit.click();
    }

    @Then("^I get a confirmation$")
    public void i_get_a_confirmation() throws Throwable {
//        String actual = driver.findElement(By.cssSelector("#thankyou h1")).getText();
        String actual = new PageMessages(driver).getThankYouMessage();
        String expected = "thanksforreachingout...";
        Assert.assertEquals(actual, expected, "Contact Form submission did not produce the message \"" + expected + "\"");
    }
    
}