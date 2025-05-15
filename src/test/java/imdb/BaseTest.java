package imdb;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        open("https://www.imdb.com/");
    }
}
