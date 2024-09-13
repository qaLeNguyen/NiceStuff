package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuiltInAction {
    private static final Logger logger = LogManager.getLogger(BuiltInAction.class);

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final WebDriverWait waitClickable;
    protected final Actions actions;
    protected final JavascriptExecutor jsExecutor;

    public BuiltInAction() {
        this.driver = WebDriverUtil.getDriver();
        this.wait = WebDriverUtil.getWait();
        this.waitClickable = WebDriverUtil.getClick();
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    /**
     * Gets an Element and ensures it is visible. Usage: interact with WebElement by seeing it.
     *
     * @param locator Located by CSS|XPath
     */
    public WebElement getElementVisible(By locator) {
        try {
            logger.debug("Attempting to wait for the element '{}' to be visible", locator);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Exception occurred when waiting for the element" +
                    " '{}' to be visible: {}", locator.toString(), e.getMessage());
        }
        return null;
    }

    /**
     * Gets an Element and ensures it is visible and clickable. Usage: interact with WebElement by clicking it.
     *
     * @param locator Located by CSS|XPath
     */
    public WebElement getElementClickable(By locator) {
        try {
            logger.debug("Attempting to wait for the element '{}' to be clickable", locator);
            return waitClickable.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            logger.error("Exception occurred when waiting for the element" +
                    " '{}' to be clickable: {}", locator.toString(), e.getMessage());
        }
        return null;
    }

    /**
     * Checks if an element exists on the page.
     *
     * @param locator The locator used to find the element
     * @return true if the element exists, false otherwise
     */
    public boolean isElementDisplayed(By locator) {
        try {
            logger.debug("Attempting to wait for element '{}' is displayed", locator);
            WebElement element = getElementVisible(locator);
            boolean isElementPresent = element.isDisplayed();
            if (isElementPresent) {
                logger.debug("Element found and is displayed: {}", locator);
            }
            return isElementPresent;
        } catch (NoSuchElementException e) {
            logger.debug("Element not found: {}", locator);
            return false;
        } catch (Exception e) {
            logger.error("Exception occurred while checking for element: {}", locator, e);
            return false;
        }
    }

    /**
     * Click on an element that is expected to be visible and clickable.
     *
     * @param locator Locator for the element, typically identified by CSS or XPath
     */
    public void click(By locator) {
        WebElement element = getElementClickable(locator);
        if (element != null) {
            try {
                element.click();
                logger.debug("Clicked element located '{}' successfully", locator);
            } catch (Exception e) {
                logger.error("Exception occurred while clicking to element located '{}'", locator);
            }
        }
    }

    /**
     * Attempt to click on an element with retries if the first attempt fails.
     *
     * @param locator    Locator for the element, identified by CSS or XPath
     * @param maxRetries Maximum number of retry attempts
     */
    public void clickWithRetry(By locator, int maxRetries) {
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                click(locator);
                return;
            } catch (NoSuchElementException e) {
                logger.debug("Element not found for locator: {}", locator, e);
            } catch (StaleElementReferenceException e) {
                logger.error("Stale element reference for locator: {}", locator, e);
            }
            attempt++;
        }
        logger.error("Failed to click on Element located" +
                " '{}' after '{}'", locator, maxRetries);
    }

    /**
     * Inputs value into a specified field after clearing it.
     *
     * @param locator The locator used to find the input field
     * @param text    The text to input into the field
     */
    public void input(By locator, String text) {
        WebElement element = getElementClickable(locator);
        if (element != null) {
            try {
                element.clear();
                logger.debug("Cleared up the locator '{}'", locator);
                element.sendKeys(text);
                logger.debug("Inputted '{}' in Element located" +
                        " '{}' successfully", text, locator);
            } catch (Exception e) {
                logger.error("Exception occurred while inputting" +
                        " '{}' to element located '{}'", text, locator);
            }
        }
    }

    /**
     * Method to replace text in an input field.
     * @param locator The locator of the input field.
     * @param newValue The new value to enter into the input field.
     */
    public void replaceValue(By locator, String newValue) {
        WebElement inputField = getElementClickable(locator);
        if (inputField != null) {
            try {
                inputField.click();
                inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                inputField.sendKeys(newValue);
                logger.debug("Replaced '{}' in Element located" +
                        " '{}' successfully", newValue, locator);
            } catch (Exception e) {
                logger.error("Exception occurred while replacing" +
                        " '{}' to element located '{}'", newValue, locator);
            }
        }
    }

    /**
     * Hovers over a specified element to display a dropdown or menu.
     *
     * @param locator The locator used to find the element to hover over
     */
    public void hoverOver(By locator) {
        WebElement element = getElementVisible(locator);
        if (element != null) {
            try {
                actions.moveToElement(element).perform();
                logger.debug("Hovered over element located '{}'", locator);
            } catch (Exception e) {
                logger.error("Exception occurred while" +
                        " hovering over element '{}'", locator);
            }
        }
    }

    /**
     * Scrolls to the specified element and brings it into view.
     *
     * @param locator The locator used to find the element to scroll to.
     */
    public void scrollToView(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.debug("Scrolled to Element located '{}'", locator);
        } catch (Exception e) {
            logger.error("Exception occurred while" +
                    " scrolling to Element located '{}'", locator);
        }
    }

    public String getPageTitle() {
        try {
            String title = driver.getTitle();
            logger.debug("Page title is '{}'", title);
            return title;
        } catch (Exception e) {
            logger.error("Exception occurred while getting page title", e);
            return null;
        }
    }



}


