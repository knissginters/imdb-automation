package imdb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import imdb.utils.WaitUtils;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement searchBox = $("#suggestion-search");
    private final SelenideElement acceptCookiesButton = $(".dRCGjd");

    public void acceptCookiesIfPresent() {
        boolean cookieAppeared = WaitUtils.waitUntil(acceptCookiesButton, Condition.appear, 5);
        if (cookieAppeared) {
            acceptCookiesButton.click();
        }
    }


    public String searchAndGetFirstTitle(String query) {
        searchBox.setValue(query);
        var suggestions = $$(".searchResult__constTitle").shouldBe(sizeGreaterThan(0));
        return suggestions.first().getText();
    }

    public void clickFirstSuggestion() {
        $$(".react-autosuggest__suggestion").first().click();
    }
}
