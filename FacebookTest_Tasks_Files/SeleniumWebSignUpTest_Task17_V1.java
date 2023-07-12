import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


/*
        1. Verify the user input the right url and is on the right webpage DONE
        2. Verify that the user clicks on the sign up button, the user is directed to the signup page DONE
        3. Verify that user cannot signup with username less than 3 characters DONE
        4. Verify that user cannot sign up with invalid email    .... DO THIS
        5. Verify that user cannot login with password less than or equal to one character DO THIS
        6. Verify that user cannot signup with either / all of the field blank  DO THIS
        7. Verify that user is successfully signed up when valid details are inputted DONE
        8. Verify that user1 item is present on the item list page DO THIS
        9. Verify that the item searched for on the user1 page is present DONE
        10. Verify that when the user logout, he/she is directed back to the home page DONE


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
            //Pass
            System.out.println("This is the correct webpage");
        else
            // Fail
            System.out.println("This is the wrong webpage");

        // page loads / waits
        Thread.sleep(5000);
        // 3. Maximize the browser
        driver.manage().window().maximize();
        // 4. Click on Signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
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
        driver.findElement(By.id("user_username")).sendKeys("tofgflh567");
        // 6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("vthho489@gmail.com");
        // 7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 1)
    public void clickMeaghanItem() throws InterruptedException {
        // TESTCASE 2: Verify that the user clicks on the sign up button, the user is directed to the dashboard page

        // Click on the sign up button
        //driver.findElement(By.id("submit")).click();


        // 9. Click on meaghan item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
      //  RECHECK THIS STEP below
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
            System.out.println("Alpha blog title is present");
        else
            // Fail
            System.out.println("Alpha blog title is not present");


        Thread.sleep(5000);
    }
    @Test (priority = 3)
    public void logoutSuccessfully(){
        // 11. Click on Logout
        // TESTCASE 10 : Verify that when the user logs out, he/she is directed back to the home page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

        String expectedLogOutUrl = "https://selenium-blog.herokuapp.com/";
        String actualLogOutUrl = driver.getCurrentUrl();

        /*  ALTERNATIVELY THEN TRY THE BELOW:
        String expectedTitle = "SELENIUM BLOG";
        String actualTitle = driver.getTitle();
        */

        if(actualLogOutUrl.contains(expectedLogOutUrl))
            // Pass
            System.out.println("User was directed to the home page after logging out / correct page");
        else
            // Fail
            System.out.println("User was not directed to the home page after logging out / wrong page");


    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        // Click on Signup button to open the signup page --- since we logged out in the positive test
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // TESTCASE 3 : Verify that user cannot sign up with username less than 3 characters
        // 5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Ag");
        // 6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("vocas0319@msback.com");
        // 7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. Click on the sign up button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        // Quit browser
        driver.quit();



    }


}
