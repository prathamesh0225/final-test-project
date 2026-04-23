package utils;

import java.io.File;
import java.io.IOException;

public class JMeterRunner {

    public static void runJMeterTest() {

        try {
            // Create folder structure
            File dir = new File("target/jmeter");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            ProcessBuilder pb = new ProcessBuilder(
                "jmeter",
                "-n",
                "-t", "Tree.jmx",
                "-l", "target/jmeter/results.jtl",
                "-j", "target/jmeter/jmeter.log"
            );

            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();

            System.out.println("JMeter test executed!");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}