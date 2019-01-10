# UnitTestExample2

This is a [JMockit](http://jmockit.github.io/) Unit Test example for Java, coded in JUnit 4.

It is expected to work in JDK 8 and above, and Maven 3.6.0 or newer.



JMockit is an automated testing toolkit for Java. Here is the official tutorial: http://jmockit.github.io/tutorial/Introduction.html



To run all test cases in the package, run this command:

```shell
mvn test
```

You will see a test report like below:

```shell
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< com.mycompany.utest:UnitTestExample2 >----------------
[INFO] Building UnitTestExample2 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ UnitTestExample2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ UnitTestExample2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ UnitTestExample2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample2\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ UnitTestExample2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.21.0:test (default-test) @ UnitTestExample2 ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.math.IntOperationsTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.156 s - in com.example.math.IntOperationsTest
[INFO] Running com.example.mock.AddCalculatorTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.003 s - in com.example.mock.AddCalculatorTest
[INFO] Running com.example.mock.SumMachineTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.014 s - in com.example.mock.SumMachineTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:resources (default) @ UnitTestExample2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default) @ UnitTestExample2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\bobyuan\scm\gitlab\cloudappdevtech\unit_test\UnitTestExample2\src\test\resources
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.815 s
[INFO] Finished at: 2019-01-09T21:04:24+08:00
[INFO] ------------------------------------------------------------------------

```



----

Last modified by bobyuan on 2019-01-09. 

