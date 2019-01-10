# UnitTestExample1

This is a basic Unit Test example for Java, coded in JUnit 3.

It is expected to work in JDK 8 and above.



To run all test cases in the package, run this command:

```shell
mvn test
```

You will see a test report like below:

```shell
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building UnitTestExample1 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ UnitTestExample1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ UnitTestExample1 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample1\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ UnitTestExample1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample1\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ UnitTestExample1 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample1\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ UnitTestExample1 ---
[INFO] Surefire report directory: D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample1\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.example.math.IntOperationsTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default) @ UnitTestExample1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default) @ UnitTestExample1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample1\src\test\resources
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8.752 s
[INFO] Finished at: 2019-01-08T16:10:06+08:00
[INFO] Final Memory: 15M/122M
[INFO] ------------------------------------------------------------------------

```



----

Last modified by bobyuan on 2019-01-08. 

