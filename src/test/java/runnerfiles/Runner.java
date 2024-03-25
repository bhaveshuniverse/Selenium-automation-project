package runnerfiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featurefiles/serachMobilePhones.feature","src/test/resources/featurefiles/eCommerce.feature"},
        glue = {"stepdefinition"},
        tags = "@TSC001",
        plugin = {"pretty","html:Target/cucumberReport.html"}
)
public class Runner {
}
