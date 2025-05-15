package imdb.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TitlePage {
    private final SelenideElement titleHeading = $("h1");
    private final ElementsCollection topCast = $$(".sc-cd7dc4b7-5");



    public void verifyTitle(String expectedTitle) {
        titleHeading.shouldBe(visible).shouldHave(text(expectedTitle));
    }

    public List<SelenideElement> getTopCastMembers() {
        return topCast.shouldBe(sizeGreaterThan(3));
    }

    public String clickThirdCastMember() {
        SelenideElement third = getTopCastMembers().get(2);
        String name = third.getText();
        third.$("a").scrollTo().click();
        return name;
    }
}
