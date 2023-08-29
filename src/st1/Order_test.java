import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Order_test {
    private static WebDriver driver;

    @Before
    public void before() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver", "/Users/mk-am14-014/Documents/selenium/chromedriver");
        driver = new ChromeDriver(ops);


        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login");

    }

    @Test
    public void login() throws InterruptedException {

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

        // 최대 10초 동안 대기
        Thread.sleep(2000);


        // 장바구니 진입
        WebElement cart_in = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/div[3]/div/div[2]/button")));
        cart_in.click();
        Thread.sleep(3000);

        // 주문서 진입
        WebElement order_bnt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[2]/div/div[3]/button[1]")));
        order_bnt.click();
        Thread.sleep(3000);

        // 페이지 스크롤
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);


        //적립금 전체선택
        WebElement point_bnt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[9]/div[1]/div[6]/div/div[1]/button")));
        point_bnt.click();
        Thread.sleep(3000);


        driver.quit();
    }
}

