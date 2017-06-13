

# Magic Leap Quality Engineer Assignment (Tests 1 and 2)
### Demonstrate the ability to create a test of a website using BDD testing tools.

jphennessey,  13 June 2017

### Test 1:
##### Scenario 1
- [x] used Java, Selenium, and Cucumber
- [x] created a feature file with multiple scenarios
- [x] demonstrated understanding of "given, when, and, then"
- [x] used the magic leap homepage
- [x] navigated to the contact page
- [x] verified that the complete address is displayed
- [x] verified the correct street address using an assert
- [x] included results in an HTML report
##### Scenario 2
- [x] filled out the contact form
- [x] used a generic xpath as a locator
- [x] verified that the form was accepted
- [x] included results in an HTML report

### Test 2:
##### Scenario 3
- [x] created a fail test scenario in the same feature
- [x] verified that the complete address is displayed, as before
- [x] verified that the incorrect street address is not present
- [x] constructed the test such that it passes when detecting the address not being present
- [x] included results in an HTML report
 

### Running the Tests:
##### Prerequisites
- [maven](http://maven.apache.org/) 
- [git](https://git-scm.com/downloads)
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
##### Steps 
- git clone https://github.com/jphennessey/magic-leap-cucumber-jvm-assignment.git
- mvn clean compile
- mvn test 
- open output/report.html
