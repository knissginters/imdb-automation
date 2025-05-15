package imdb.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ActorProfilePage {
    private final SelenideElement actorName = $("h1");

    public void verifyProfileName(String expectedName) {
        actorName.shouldBe(visible).shouldHave(text(expectedName.split(" ")[0]));
    }
}

