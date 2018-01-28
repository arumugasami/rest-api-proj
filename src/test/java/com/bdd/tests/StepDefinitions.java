package com.bdd.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.junit.Assert;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import springboot.model.Transaction;

public class StepDefinitions {

	Response response;
	RequestSpecification rspec;
	Transaction transaction;
	int transactionId;

	@Given("^There is transactions api$")
	public void There_is_transactions_api() {
		baseURI = "http://localhost:8080/SpringBootRestApi/api";
	}

	@Given("^there is a standalone (\\d+)$")
	public void there_is_a_standalone(int transactionId) {
		this.transactionId = transactionId;
		transaction = new Transaction(transactionId, 50, "car");
	}

	@Given("^there is a linked (\\d+)  with (\\d+)$")
	public void there_is_a_linked_with(int transactionId, int parentId) {
		this.transactionId = transactionId;
		transaction = new Transaction(transactionId, 50, "car", parentId);
	}

	@When("^the user posts the transaction$")
	public void the_user_posts_the_transaction() {
		response = given().contentType("application/json").body(transaction).when().put("transaction/" + transactionId);

	}

	@Then("^the new transaction is saved$")
	public void the_new_transaction_is_saved() {
		response.then().assertThat().statusCode(HttpStatus.SC_OK);

	}

	@When("^the user requests the transaction$")
	public void the_user_requests_the_transaction() {
		response = given().contentType("application/json").body(transaction).when().get("transaction/" + transactionId);

	}

	@Then("^the transaction is returned$")
	public void the_transaction_is_returned() {
		response.then().body("transaction_id", equalTo(transactionId));

	}

	@When("^the user requests the transaction car$")
	public void the_user_requests_the_transaction_car() throws URISyntaxException {
		response = when().get(new URI("/types/car"));

	}

	@Then("^all the same type of transactions are returned$")
	public void all_the_same_type_of_transactions_are_returned() {
		String result = response.thenReturn().body().asString();
		Assert.assertEquals("[1,2]", result);
	}

	@When("^the user requests the sum of the (\\d+)$")
	public void the_user_requests_the_sum_of_the(int transactionId) throws URISyntaxException {
		response = when().get(new URI("/sum/" + transactionId));
	}

	@Then("^the sum of all the transaction is returned$")
	public void the_sum_of_all_the_transaction_is_returned() {
		String result = response.thenReturn().body().asString();
		Assert.assertEquals("100.0", result);
	}

}
