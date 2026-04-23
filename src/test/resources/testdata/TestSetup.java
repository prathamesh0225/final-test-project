package runners;

import org.testng.annotations.BeforeSuite;
import utils.FeatureFileGenerator;

public class TestSetup {

    @BeforeSuite
    public void generateFeature() {
        FeatureFileGenerator.generateFeatureFile();
    }
}