package tests.trello_ui;

import api.utils.UtilsMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrelloUiTest{
    private static final Logger log = Logger.getLogger(TrelloUiTest.class);
    private static final String USER_PASSWORD = UtilsMethod.getValue("USER_PASSWORD");
    private static final String USER_EMAIL = UtilsMethod.getValue("USER_EMAIL");

    @Test(priority = 1,description = "auth")
    public void auth() {
        open("https://trello.com/login");
        $(By.id("user")).setValue(USER_EMAIL);
        $(By.xpath("//input[@value = 'Войти с помощью Atlassian']")).click();
        $(By.id("password")).setValue(USER_PASSWORD);
        $(By.id("login-submit")).click();
    }

    @Test(priority = 2,description = "checked a Card on the list")
    public void checkedCard() {
        $(By.xpath("//div[@title = 'KanbanTool']")).click();
        if ($(By.xpath("//div/textarea[@aria-label= 'Done']/../following-sibling::div//span[contains(text(), 'Карточка для изучения API')]")).shouldBe(exist).isDisplayed()) {
            log.info("Карточка \"Карточка для изучения API\" присутствует в коленке \"Backlog\"");
        } else {
            log.error("Карточка \"Карточка для изучения API\" не находится в коленке \"Backlog\"");
        }
    }

    @Test(priority = 3,description = "checked a checkList on the Card is complete")
    public void checkedCheckList() {
            $(By.xpath("//div[contains(@class, 'checkitems-badge is-complete')]")).shouldBe(exist);
    }

    @Test(priority = 4,description = "Set cover with green color")
    public void setCover() {
        $(By.xpath("//div[contains(@class, 'is-covered')]")).click();
        $(By.xpath("//a[contains(@class, 'cover-menu-button')]")).click();
        $(By.xpath("//button[contains(@class, '-LRBw8')]")).click();
    }

    @Test(priority = 5,description = "Indicate that the task was completed")
    public void setTaskCompleted() {
        $(By.xpath("//span[contains(@class, 'complete-icon')]")).click();
        $(By.xpath("//a[contains(@class, 'close-button-dark')]")).click();
    }

    @Test(priority = 6,description = "Set color of Board fon")
    public void setBoardFon() {
        $(By.xpath("//a[contains(@class, 'mod-show-menu')]")).click();
        $(By.xpath("//a[contains(@class, 'change-background')]")).click();
        $(By.xpath("//div[contains(@class, 'bg-colors')]")).click();
        $(By.xpath("//div[contains(@style, 'rgb(81, 152, 57)')]")).click();
        $(By.xpath("//a[contains(@title, 'Закрыть меню доски.')]")).click();
    }

    @Test(priority = 7,description = "Make the board a team and educational one")
    public void setBoardEducational() {
        $(By.xpath("//a[contains(@class, 'board-header-btn-without-icon')]")).click();
        $(By.xpath("//a[contains(@class, 'js-change-org')]")).click();
        $(By.xpath("//a[contains(@class, 'right-of-button-link')]")).click();
        $(By.id("org-display-name")).setValue("Ученики");
        $(By.xpath("//div[contains(@class, 'css-191o3mb')]")).click();
        $(By.xpath("//li[contains(text(), 'Образование')]")).click();
        $(By.xpath("//input[@value='Создать']")).click();
    }

    @Test(priority = 8,description = "Change workspace name")
    public void updateWorkspaceName() {
        $(By.xpath("//button[contains(@class , '_3nslPxx5w1nLQy _3TTqkG5muwOzqZ')]")).click();
        $(By.id("displayName")).setValue("Только для образования");
        $(By.xpath("//button[contains(text(), 'Сохранить')]")).click();
    }
}
