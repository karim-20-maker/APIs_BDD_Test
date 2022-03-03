package cucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions( features="src/test/java/features",glue={"steps"},tags = "@Test_BDD_SCRIPT",
        plugin={"pretty", "html:target/reports/cucumber/html.html",
                "json:target/cucumber.json", "usage:target/usage.jsonx",
                "testng:target/junit.xml"},monochrome=true)
public class TestRunner extends AbstractTestNGCucumberTests {



}



