package com.bdd.tests;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "com.bdd.tests" }

)
public class RunTest {

}
