package modules;

import pageobjects.ContactPage;

public class ContactFormAction {

    public static void InputSampleData(ContactPage contactPage) {
        contactPage.INPUT_contactFirstname.sendKeys("Joe");
        contactPage.INPUT_contactLastname.sendKeys("Hennessey");
        contactPage.INPUT_contactCompany.sendKeys("Hennessey Worldwide");
        contactPage.INPUT_contactEmail.sendKeys("4jp.hennessey@gmail.com");
        contactPage.INPUT_contactPhone.sendKeys("561.423.1415");
        contactPage.selectContactInquiryType(ContactPage.INQUIRY_TYPE.GENERAL);
        contactPage.TEXTAREA_contactMessage.sendKeys("Testing only....please disregard or delete.  Thanks!");
    }
}
