package runners;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.FeatureFileGenerator;
import utils.JMeterRunner;
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void generateFeature() {
        FeatureFileGenerator.generateFeatureFile();
    }
    @BeforeSuite
public void runPerformanceTest() {
    JMeterRunner.runJMeterTest();
}
}