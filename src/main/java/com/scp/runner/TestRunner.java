package com.scp.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

    @RunWith(Cucumber.class)
	@CucumberOptions(
	 features = "Features/GetCall.feature",
	 glue="Steps",
//	 dryRun=true,
//	 strict=true,
	 monochrome=true
	 )
	 
	public class TestRunner {
	 
	
	}


