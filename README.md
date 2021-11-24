# Selenium-FB-Maven-TestNg-Invygo-Assignment



# Running from Command Prompt 

    

C:\Users\admin>cd C:\Users\admin\Desktop\Java Project\Invygo\Facebook

C:\Users\admin\Desktop\Java Project\Invygo\Facebook>mvn clean
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------< com.invygo:Facebook >-------------------------
[INFO] Building Facebook 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ Facebook ---
[INFO] Deleting C:\Users\admin\Desktop\Java Project\Invygo\Facebook\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.584 s
[INFO] Finished at: 2021-11-24T10:01:36+04:00
[INFO] ------------------------------------------------------------------------

C:\Users\admin\Desktop\Java Project\Invygo\Facebook>mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------< com.invygo:Facebook >-------------------------
[INFO] Building Facebook 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Facebook ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\admin\Desktop\Java Project\Invygo\Facebook\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ Facebook ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 10 source files to C:\Users\admin\Desktop\Java Project\Invygo\Facebook\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Facebook ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\admin\Desktop\Java Project\Invygo\Facebook\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ Facebook ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\admin\Desktop\Java Project\Invygo\Facebook\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:3.0.0-M5:test (default-test) @ Facebook ---
[WARNING] The parameter forkCount should likely not be 0, not forking a JVM for tests reduce test accuracy, ensure to have a <forkCount> >= 1.
[INFO] Running TestSuite
[TestNGContentHandler] [WARN] It is strongly recommended to add "<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >" at the top of your file, otherwise TestNG may fail or not work as expected.
Starting ChromeDriver 95.0.4638.69 (6a1600ed572fedecd573b6c2b90a22fe6392a410-refs/branch-heads/4638@{#984}) on port 28426
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
[1637733726.758][WARNING]: This version of ChromeDriver has not been tested with Chrome version 96.
Nov 24, 2021 10:02:12 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
facebooklogin test case started
The name of the testcase passed is :facebooklogin
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 76.506 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:27 min
[INFO] Finished at: 2021-11-24T10:03:14+04:00
[INFO] ------------------------------------------------------------------------

