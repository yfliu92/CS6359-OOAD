package webTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CommentTest {
    WebDriver driver;

    /**
     * Need to login first, and then click the Comments button on the sidebar
     *
     * @throws InterruptedException
     */
    @Before
    public void openCommentsPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        Assert.assertEquals("League of Courses", driver.getTitle());

        WebElement userInput = driver.findElement(By.id("username"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.className("submit-btn"));

        userInput.sendKeys("unitTest");
        pwd.sendKeys("unitTest");

        Thread.sleep(1000);
        submitBtn.click();

        WebElement commentsTag = driver.findElement(By.className("student-teacher-comments"));
        commentsTag.click();

        WebElement btn = driver.findElement(By.id("make-your-comment"));
        Assert.assertEquals("Make your comment!", btn.getText());
    }

    @Test
    public void testMakeYourComment() throws InterruptedException {
        WebElement btn = driver.findElement(By.id("make-your-comment"));
        btn.click();
        Thread.sleep(1000);

        Select commentRating = new Select(driver.findElement(By.id("comment-rating")));
        commentRating.selectByVisibleText("3");

        WebElement commentContent = driver.findElement(By.id("comment-content"));
        commentContent.sendKeys("unit test comment");

        Thread.sleep(2000);

        WebElement createComment = driver.findElement(By.className("create-comment-button"));
        createComment.click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Submit Success!", alert.getText());

        Thread.sleep(1000);
        alert.accept();

    }

    @After
    public void closePage() {
        driver.quit();
    }
}