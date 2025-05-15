package imdb.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class WaitUtils {

    public static boolean waitUntil(SelenideElement element, Condition condition, long timeoutSeconds) {
        try {
            element.should(condition, Duration.ofSeconds(timeoutSeconds));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

