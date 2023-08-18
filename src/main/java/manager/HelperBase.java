package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface HelperBase extends AppManager {


    default void click(By locator) {
        wd.findElement(locator).click();
    }

    default void type(By locator, String fill) {
        WebElement element = wd.findElement(locator);
        element.click();

        element.clear();
        element.sendKeys(fill);
    }

    default void typeBD(By locator, String fill) {

        WebElement element = wd.findElement(locator);
        element.click();
        element.sendKeys(Keys.CLEAR);
        element.sendKeys(fill);
        element.click();
        for (int i = 0; i < 11; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(Keys.ENTER);
    }

    default void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {

        }
    }

    default void chooseday(By locator) {
        WebElement element = wd.findElement(locator);
        click(locator);

    }

    default void chooseyear(By locator, String str) {
        WebElement element = wd.findElement(locator);
        click(locator);
        WebElement selectEl = wd.findElement(locator);
        Select select = new Select(selectEl);
        select.selectByValue(str);
//        element.sendKeys(Keys.ENTER);

    }

    default void choosemonth(By locator, String str) {
        WebElement element = wd.findElement(locator);

        WebElement selectEl = wd.findElement(locator);
        Select select = new Select(selectEl);
        select.selectByValue(str);
        element.sendKeys(Keys.ENTER);

    }

    default void RemoveAdd() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#adplus-anchor').style.display='none';");

    }
    default void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");

    }
  default void hideDiv() {
      JavascriptExecutor js = (JavascriptExecutor) wd;
      js.executeScript("document.querySelector('#fixedban').style.zIndex=-1");

    }

    default boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }
}
