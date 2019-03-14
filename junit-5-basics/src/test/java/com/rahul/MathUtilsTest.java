package com.rahul;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {
	
	MathUtils mathUtils;
	TestInfo info;
	TestReporter reporter;
	
	
	@BeforeEach
	void init(TestInfo info,TestReporter reporter)
	{	this.info=info;
		this.reporter=reporter;
		mathUtils=new MathUtils();
		reporter.publishEntry("Running .. "+info.getDisplayName()+" with .tags "+info.getTags());
	}
	
	@AfterEach
	void cleanup()
	{
		assertEquals(1, 1);
	}
	
	
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Linux Test")
	@Tag("OS TeSt")
	void testDisplayonOS() {
		
		int expected=2;
		int actual=mathUtils.add(1, 1);
		assertEquals(expected, actual,"The add method should add two numbers");
	
	}
	
	
	
	@Test
	@Tag("Circle Test")
	void testComputeCircleRadius()
	{
		
		double expected=mathUtils.computeCircleArea(10);
		double actual=Math.PI*10*10;
		assertEquals(expected, actual,"The method should return area of 10");
	}
	
	@Test
	@Tag("Math")
	void testDivide()
	{
		
		
		assertThrows(ArithmeticException.class,()-> mathUtils.divide(1,0),"This method checks divide by zero");
	}
	
	@Test
	@DisplayName("Should not be run")
	@Disabled
	@Tag("Math")
	void testAddFail() {
		
		fail("This test should fail");
	
	}
	
	
	@Test
	@DisplayName("Assumptions Test")
	void assumptionsTest() {
		boolean isServerUp=false;
		assumeTrue(isServerUp);
		// write test case
		System.out.println("This should not be printed");
		
	}
	
	
	@Test
	@DisplayName("assertAll Test")
	void assertAllTest() {
		assertAll(
				
				()->{assertEquals(mathUtils.multiply(2,2), 4);
				},

				()->{assertEquals(mathUtils.multiply(2,1), 2);
				}
				
				
				);
		
	}
	
	
	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class AddTest
	{

		@Test
		@DisplayName("when adding two positive numbers")
		void testAdd() {
			
			int expected=2;
			int actual=mathUtils.add(1, 1);
			assertEquals(expected, actual,"should return the right sum");
		
		}
		
		
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddnegative() {
			
			int expected=0;
			int actual=mathUtils.add(1, -1);
			assertEquals(expected, actual,"should return the right sum");
		
		}
		
	}
	
	
	@RepeatedTest(3)
	@DisplayName("Repetion Test")
	void testRepeated(RepetitionInfo info) {
		info.getCurrentRepetition();
		int expected=2;
		int actual=mathUtils.add(1, 1);
		assertEquals(expected, actual,"should return the right sum");
	
	}
	
	
}
