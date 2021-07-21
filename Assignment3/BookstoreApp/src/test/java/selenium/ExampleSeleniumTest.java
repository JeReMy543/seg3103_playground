package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }
/*
  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }
*/
  public void addBook(){
    driver.get("http://localhost:8080/admin");
    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(By.id("loginPasswd"));
    password.sendKeys("password");
    WebElement loginButton = driver.findElement(By.id("loginBtn"));
    loginButton.click();
    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("science");
    WebElement id = driver.findElement(By.id("addBook-id"));
    id.sendKeys("abcdef");
    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("X");
    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Y");
    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.5");
    WebElement addbtn = driver.findElement(By.name("addBook"));
    addbtn.click();
  }

  @Test
  public void test1() {
    driver.get("http://localhost:8080/admin");
    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(By.id("loginPasswd"));
    password.sendKeys("password");
    WebElement loginButton = driver.findElement(By.id("loginBtn"));
    loginButton.click();

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("science");
    WebElement id = driver.findElement(By.id("addBook-id"));
    id.sendKeys("abcdef");
    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("X");
    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Y");
    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.5");
    WebElement addbtn = driver.findElement(By.name("addBook"));
    addbtn.click();

    WebElement feedback = driver.findElement(By.id("feedback"));
    String actual = feedback.getText();
    String expectedResult = "Successfully added book";
    assertEquals(expectedResult, actual);
}



@Test
public void test2() {
  driver.get("http://localhost:8080/admin");
  WebElement username = driver.findElement(By.id("loginId"));
  username.sendKeys("admin");
  WebElement password = driver.findElement(By.id("loginPasswd"));
  password.sendKeys("password");
  WebElement loginButton = driver.findElement(By.id("loginBtn"));
  loginButton.click();

  WebElement id = driver.findElement(By.id("addBook-id"));
  id.sendKeys("abcdef");
  WebElement title = driver.findElement(By.id("addBook-title"));
  title.sendKeys("X");
  WebElement author = driver.findElement(By.id("addBook-authors"));
  author.sendKeys("Y");
  WebElement cost = driver.findElement(By.id("cost"));
  cost.sendKeys("10.5");
  WebElement addbtn = driver.findElement(By.name("addBook"));
  addbtn.click();

  WebElement feedback = driver.findElement(By.id("feedback"));
  String actual = feedback.getText();
  String expectedResult = "Validation errors\nA category is mandatory";
  assertEquals(expectedResult, actual);
}


@Test
public void test3() {
  addBook();
  driver.get("http://localhost:8080");
  WebElement search = driver.findElement(By.id("search"));
  search.sendKeys("science");
  WebElement searchbtn = driver.findElement(By.id("searchBtn"));
  searchbtn.click();
  WebElement booktitle = driver.findElement(By.id("title-abcdef"));
  String expectedResult = "X";
  String actual = booktitle.getText();
  assertEquals(expectedResult,actual);
}

@Test
public void test4() {
  driver.get("http://localhost:8080");
  WebElement searchbtn = driver.findElement(By.id("searchBtn"));
  searchbtn.click();
  WebElement addCart = driver.findElement(By.id("order-hall001"));
  addCart.click();

  WebElement cart = driver.findElement(By.id("cartLink"));
  cart.click();

  WebElement bookcost = driver.findElement(By.id("tothall001"));
  String expectedResult = "$39.95";
  String actual = bookcost.getText();
  assertEquals(expectedResult,actual);
}

@Test
public void test5() {
  driver.get("http://localhost:8080");
  WebElement searchbtn = driver.findElement(By.id("searchBtn"));
  searchbtn.click();
  WebElement addCart = driver.findElement(By.id("order-hall001"));
  addCart.click();

  WebElement cart = driver.findElement(By.id("cartLink"));
  cart.click();

  WebElement number = driver.findElement(By.id("hall001"));
  number.sendKeys("0");

  WebElement update = driver.findElement(By.name("updateOrder"));
  update.click();

  WebElement bookcost = driver.findElement(By.id("tothall001"));

  String expectedResult = "$399.50";
  String actual = bookcost.getText();
  assertEquals(expectedResult,actual);
}

@Test
public void test6() {
  driver.get("http://localhost:8080");
  WebElement searchbtn = driver.findElement(By.id("searchBtn"));
  searchbtn.click();
  WebElement addbook1 = driver.findElement(By.id("order-lewis001"));
  addbook1.click();
  WebElement addbook2 = driver.findElement(By.id("order-alexander001"));
  addbook2.click();

  WebElement cart = driver.findElement(By.id("cartLink"));
  cart.click();

  WebElement checkout = driver.findElement(By.name("checkout"));
  checkout.click();

  WebElement date = driver.findElement(By.id("order_date"));
  WebElement total = driver.findElement(By.id("order_total"));
  WebElement tax = driver.findElement(By.id("order_taxes"));
  WebElement shipping = driver.findElement(By.id("order_shipping"));

  String expectedResult = "2021/07/21$57.08$5.19$12.00";
  String actual = date.getText()+total.getText()+tax.getText()+shipping.getText();
  assertEquals(expectedResult,actual);

}
/*
@Test
public void test8() {
  addBook();
  WebElement searchbtn = driver.findElement(By.id("searchBtn"));
  searchbtn.click();

  WebElement delbtn = driver.findElement(By.id("del-abcdef"));
  delbtn.click();

  WebElement bookname = driver.findElement(By.className("content"));

  String expectedResult = "";
  String actual = bookname.getText();
  assertEquals(expectedResult,actual);
}*/
@Test
public void test7() {
  driver.get("http://localhost:8080/admin");
  WebElement username = driver.findElement(By.id("loginId"));
  username.sendKeys("admin");
  WebElement password = driver.findElement(By.id("loginPasswd"));
  password.sendKeys("abcdef");
  WebElement loginButton = driver.findElement(By.id("loginBtn"));
  loginButton.click();

  WebElement error = driver.findElement(By.className("content"));
  String expectedResult = "Invalid username and/or password\nUser Name\nPassword";
  String actual = error.getText();
  assertEquals(expectedResult,actual);
}

@Test
public void test8() {
  driver.get("http://localhost:8080/admin");
  WebElement username = driver.findElement(By.id("loginId"));
  username.sendKeys("admin");
  WebElement password = driver.findElement(By.id("loginPasswd"));
  password.sendKeys("password");
  WebElement loginButton = driver.findElement(By.id("loginBtn"));
  loginButton.click();

  WebElement logoutButton = driver.findElement(By.xpath("//input[@value='Sign out']"));
  logoutButton.click();
  WebElement msg = driver.findElement(By.className("content"));

  String expectedResult = "You have been logged out\nUser Name\nPassword";
  String actual = msg.getText();
  assertEquals(expectedResult,actual);


}

@Test
public void test9() {
  addBook();
  WebElement addbtn = driver.findElement(By.name("addBook"));
  addbtn.click();

  WebElement feedback = driver.findElement(By.id("feedback"));

  String expectedResult = "Book with same id already exist";
  String actual = feedback.getText();
  assertEquals(expectedResult,actual);


}

@Test
public void test10() {
driver.get("http://localhost:8080");
Select language = new Select(driver.findElement(By.id("locales")));
language.selectByIndex(2);

String expectedResult = "http://localhost:8080/?lang=fr-CA";
String actual = driver.getCurrentUrl();
assertEquals(expectedResult,actual);
}
  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}
