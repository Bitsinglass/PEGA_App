package com.big.TestRunners;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.big.utils.TestReusables;
import com.big.utils.Utilities;

public class TestRunner {

	public static void main(String[] args) {
		
		try {
			Utilities util = new Utilities();
			String mode = util.getProeprty("Execution-Type");
			TestNG testNG = new TestNG();
			if(mode.equalsIgnoreCase("Cucumber")) {
				testNG.setTestClasses(new Class[] {CucumberRunner.class});
				testNG.run();
			}
			else {  
				util.builTestNgXML();
				
				  List<String> suites = new ArrayList<String>();
				  suites.add(""+System.getProperty("user.dir")+"\\testng.xml");
				  testNG.setTestSuites(suites); testNG.run();				 	 
			}
		}
		catch(Exception e) {
			//System.out.println("OKOKOKOKO");
			e.printStackTrace();
		}
	}
}