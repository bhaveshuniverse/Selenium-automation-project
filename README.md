# Selenium-automation-project

 Domain: E-Commerce
 
 Objective:
 This project aims at developing a Page Object Model framework and being able
 to use this framework to login and buy a product from www.flipkart.com and www.amazon.com.
 Data fetching ,storing the same into excel files and automated different scenarios of an eCommerce site.
 
 Pre-requisites: Create an account in ‘flipkart.com’ manually that should be
 used for this project. (Not through automation as you may end up creating a new
 account every time you run this script)
 
 Description of the Dataset:
 ● Login data used in pre-requisite for logging into the site
 ● ‘iPhone 12’ is the product that needs to be searched
 ● A256GBphoneneeds to be selected out of other variants available in the
 list of phones
 ● Firefox and Chrome as browsers
 
 Case 1:
 ● Search for ‘Mobile Phone’ on the ‘flipkart.com’ homepage
 ● Fetch all the mobile phones listed in the product listing page along with
 their prices and output them to an excel file and store them inside folder
 ‘testresult’ in ‘src/java/resources’.
 
 Case 2:
 ● Do login and validate if Login is successful
 ● Search for ‘iPhone 12’ and select a 256GB phone on the product details
 page after selecting the phone from the product listing page
 ● Add the product to cart and validate if the product is added and available in
 Cart
 ● Same test is repeated on Chrome browser (assuming you’re using
 Firefox as default browser else vice-versa)
 
 Lab Environment:
 ● JDK21 is already installed in the system
 ● Intellije with Maven and Cucumber(BDD) plug-ins installed
 ● Selenium, Cucumber, Apache poi and every other dependency is handled in pom.xml
