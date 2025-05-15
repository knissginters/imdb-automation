package imdb.tests;

import imdb.BaseTest;
import imdb.pages.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Epic("IMDb Search Feature")
@Feature("Search and Cast Validation")
public class ImdbTest extends BaseTest {

    private HomePage homePage;
    private TitlePage titlePage;
    private ActorProfilePage actorProfilePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        titlePage = new TitlePage();
        actorProfilePage = new ActorProfilePage();
    }

    @Test(description = "Validate that the 3rd cast member's profile matches expected name")
    @Story("Search for a title and validate cast member details")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldValidateThirdCastMemberProfile() {
        homePage.acceptCookiesIfPresent();
        String firstTitle = homePage.searchAndGetFirstTitle("QA");
        homePage.clickFirstSuggestion();
        titlePage.verifyTitle(firstTitle);
        String actorName = titlePage.clickThirdCastMember();
        actorProfilePage.verifyProfileName(actorName);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
