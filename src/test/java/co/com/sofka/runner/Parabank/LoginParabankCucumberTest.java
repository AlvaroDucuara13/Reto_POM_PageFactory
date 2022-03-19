package co.com.sofka.runner.Parabank;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/Features/Parabank/ParabankLogin.feature"},
        glue = "co.com.sofka.StepDefinition.parabankstep"
)
public class LoginParabankCucumberTest {
}
