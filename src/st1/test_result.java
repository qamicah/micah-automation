package st1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test_result {

    private static WebDriver driver;

    @Before
    public void before() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("webdriver.chrome.driver", "/Users/micahjang/Documents/selenium/chromedriver");
        driver = new ChromeDriver(ops);


        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 컬리 접속
        driver.get("https://www.kurly.com/member/login");

    }

    @Test
    public void Test() throws InterruptedException {

        // 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 아이디 입력
        WebElement id_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/form/div[1]/div[1]/div/input")));
        id_input.sendKeys("urmicah");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");

        // 로그인 클릭
        WebElement login_click = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/form/div[3]/button[1]")));
        login_click.click();

        // 마이컬리 클릭
        WebElement mykurly = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[1]/div[1]/a/span[1]")));
        mykurly.click();
    }

    @After
    public void After() throws InterruptedException {

        // 결과확인
        Thread.sleep(2000);
        Assert.assertEquals("장미가님", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[1]/div[1]/div/strong")).getText());
        System.out.println("test_result 참 잘했어요");




    }
}
