import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


/*
        1. Verify the user input the right url and is on the right webpage
        2. Verify that the user clicks on the sign up button, the user is directed to the signup page
        3. Verify that user cannot signup with username less than 3 characters
        4. Verify that user cannot sign up with invalid email    ....
        5. Verify that user cannot login with password less than or equal to one character
        6. Verify that user cannot signup with either / all of the field blank
        7. Verify that user is successfully signed up when valid details are inputted
        8. Verify that user1 item is present on the item list page
        9. Verify that the item searched for on the user1 page is present
        10. Verify that when the user logout, he/she is directed back to the home page


        */


public class SeleniumWebSignUpTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start () throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // 1. Open your chrome driver
        driver = new ChromeDriver();
        // 2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");
        // TESTCASE 1 : Verify the user input the right url and is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            // Pass
            System.out.println("This is the correct webpage");
        else
            // Fail
            System.out.println("This is the wrong webpage");
        // ensure the page loads / waits a bit
        Thread.sleep(5000);
        // 3. Maximize the browser
        driver.manage().window().maximize();
        // 4. Click on Signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        // user should be directed to the sign up/ registration page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was directed to the sign up page");
        else
            // Fail
            System.out.println("User was not directed to the sign up page");
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {

        // TESTCASE 7 : Verify that user is successfully signed up when valid details are inputted
        // 5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("agapeakpokodjee");
        // 6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("agapeakpokodjee@mailinator.com");
        // 7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);

        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was successfully registered");
        else
            // Fail
            System.out.println("User was not successfully registered");

        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickMeaghanItem() throws InterruptedException {
        // TESTCASE 2: Verify that the user clicks on the sign up button, the user is directed to the dashboard page showing list of all users

        /*
        ALTERNATIVE TEST
        // Click on the sign up button
        //driver.findElement(By.id("submit")).click();
        */


        // 9. Click on meaghan item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
      //  RECHECK THIS STEP below, remove the users with users with number.......
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
                if(actualUrl.contains(expectedUrl))
                    // Pass
                    System.out.println("User was directed to all users page");
                else
                    // Fail
                    System.out.println("User was not directed to all users page");

        Thread.sleep(5000);
// confirm above
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        // 10. Search for an item (Using Python with Selenium) and confirm it is present
        // TESTCASE 9 : Verify that the item searched for on the user1 page is present (Selenium Blog)
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageTitle = "AlphaBlog";
        String actualPageTitle = driver.getTitle();

        /*  ALTERNATIVELY THEN TRY THE BELOW:
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        */

        if (actualPageTitle.contains(expectedPageTitle))
            // Pass
            System.out.println("Alpha blog title and user1 page are present");
        else
            // Fail
            System.out.println("Alpha blog title and user1 page are present");


        Thread.sleep(5000);
    }
    @Test (priority = 3)
    public void logoutSuccessfully(){
        // 11. Click on Logout
        // TESTCASE 10 : Verify that when the user logs out, he/she is directed back to the home page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

        String expectedLogOutUrl = "https://selenium-blog.herokuapp.com/";
        String actualLogOutUrl = driver.getCurrentUrl();

        /*  ALTERNATIVELY  TRY THE BELOW:
        String expectedTitle = "SELENIUM BLOG";
        String actualTitle = driver.getTitle();
        */

        if(actualLogOutUrl.contains(expectedLogOutUrl))
            // Pass
            System.out.println("User was logged out and directed to the correct home page");
        else
            // Fail
            System.out.println("User was not logged out or directed to the correct home page");


    }

    @Test (priority = 4)
    public void negativeSignup1() throws InterruptedException {
        // Click on Signup button to open the signup page --- since we logged out in the positive test
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // TESTCASE 3 : Verify that user cannot sign up with username less than 3 characters
        // 5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Ae");
        // 6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("agr75e80@mailinator.com");
        // 7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        // remove driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
    }

    /////////////////// Other tests /////////////////////

    @Test (priority = 5)
    public void negativeSignup2() throws InterruptedException {

        // driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Thread.sleep(5000);
        // TESTCASE 4 : Verify that user cannot sign up with an invalid email address
        // 5. Input a valid username on the username field
        driver.findElement(By.id("user_username")).sendKeys("argewei678");
        // 6. Input an invalid email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("agayrhheigmail.m");
        // 7. Input your desired password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        // remove driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();

    }

    @Test (priority = 6)
    public void negativeSignup3() throws InterruptedException {

        // remove driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Thread.sleep(5000);
        // TESTCASE 5 : Verify that user cannot sign up with a password less than or equal to one character
        // 5. Input a valid username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Agaspessr");
        // 6. Input a valid email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("agapeeeriesr@gmail.com");
        // 7. Input an invalid password (password that is less than or equal to one character)  in the password field
        driver.findElement(By.id("user_password")).sendKeys("i");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        // remove driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

    }

    @Test (priority = 7)
    public void negativeSignup4() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Thread.sleep(5000);
        // TESTCASE 6a : Verify that user cannot sign up with the name field blank
        // 5. Input a valid username on the username field
        //driver.findElement(By.id("user_username")).sendKeys(" ");
        // 6. Leave the email field blank
        driver.findElement(By.id("user_email")).sendKeys("agebyere@mailinator.com");
        // 7. Input a valid password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        // remove driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);
        // driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
    }

    @Test (priority = 8)
    public void negativeSignup5() throws InterruptedException {

        //driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Thread.sleep(5000);
        // TESTCASE 6b : Verify that user cannot sign up with the email field blank
        // 5. Input a valid username on the username field
        driver.findElement(By.id("user_username")).sendKeys("agargsar");
        // 6. Leave the email field blank
        //driver.findElement(By.id("user_email")).sendKeys(" ");
        // 7. Input a valid password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        // remove driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
    }

    @Test (priority = 9)
    public void negativeSignup6() throws InterruptedException {

        // remove driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Thread.sleep(5000);
        // TESTCASE 6a : Verify that user cannot sign up with the password field blank
        // 5. Input a valid username on the username field
        driver.findElement(By.id("user_username")).sendKeys("agapweer");
        // 6. Leave the email field blank
        driver.findElement(By.id("user_email")).sendKeys("agapster34@mailinator.com");
        // 7. Input a valid password on the password field
        //driver.findElement(By.id("user_password")).sendKeys(" ");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        // remove driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);
       driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
    }

    @Test (priority = 10)
    public void negativeSignup7() throws InterruptedException {

        //driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Thread.sleep(5000);
        // TESTCASE 6c : Verify that user cannot sign up with all of the fields blank
        // 5. Leave username field blank
        //driver.findElement(By.id("user_username")).sendKeys(" ");
        // 6. Leave email field blank
        //driver.findElement(By.id("user_email")).sendKeys(" ");
        // 7. Leave password field blank
        //driver.findElement(By.id("user_password")).sendKeys(" ");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User was not successfully registered");
        else
            // Fail
            System.out.println("User was successfully registered");
        Thread.sleep(5000);

    }



    @AfterTest
    public void closeBrowser(){
        // Quit browser
        driver.quit();



    }


}
