
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/steps_azul.feature",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = true,
        dryRun = false,
        strict = true
        )
public class RunTests {

}
