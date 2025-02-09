package com.logwire;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/logwire")
// @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,
// html:target/cucumber-reports.html")
public class RunCucumberTest {
}
