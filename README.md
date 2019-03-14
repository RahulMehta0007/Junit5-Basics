# Junit5-Basics
Junit5-Basics Course

This covers basi junit5 features:
The following steps are to be followed :

Step 1 :
Add Maven dependencies :
<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<version>${junit.jupiter.version}</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<version>${junit.jupiter.version}</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-launcher</artifactId>
			<version>1.1.0</version>
			<scope>test</scope>
		</dependency>
		
Step 2: Create MathUtils class ,then add all calc methods.
Step 3: Create Test class,annotate methods with @Test use assertions/
Step 4 : Add maven surefire plugin for unit tests.
		
***Annotations Used : 

1.@Test-- SUed on top of test methods.
2.@TestInstance(TestInstance.Lifecycle.PER_CLASS)-For changing default behaviour i.e new object will not be created for each method but will be a single instance.
So now we don't need to use static methods on beforeAll as the same instance will be there.
3.@DisplayName("")-Cool test name.
4.@Disabled-Test disabled
5.@Nested-For nested classes
6.@EnabledOnOs(OS.LINUX)
7.@RepeatedTest(3)-Repeating a test 3 times
8.@Tag-Group tests into tags


***Assertions Used
assertEquals,assertThrows,assertAll

Lifecycle Hooks:
@BeforeAll,@BeforeEach,AfterAll,@AfterEach

BeforeAll method should be static as it is executed before object of Test class is created.

--TestInfo and TestReporter----
These classes are provided by junit5 api
We can inject these classes using DI(Dependency Injection)

Example :
@BeforeEach
	void init(TestInfo info,TestReporter reporter)
	{	this.info=info;
		this.reporter=reporter;
		mathUtils=new MathUtils();
		reporter.publishEntry("Running .. "+info.getDisplayName()+" with .tags "+info.getTags());
	}
  
  With the help of TestInfo we can get information abou tests and with testReporter we can publish them.

