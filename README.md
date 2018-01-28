# Home Challenge

This project is a REST API implementation for monetory transactions. The tests are implemented using Rest Assured with cucumber


## Getting Started and installing:

This project can be imported directly as a Maven project.It is a springboot project and all the dependency needed for the project are handled in the POM. 

## TransactionController
The transaction controller provides four service calls 
-to update a transaction
-to get a transaction/s by type,sum and id

## TransactionRepository:
 Transaction repository acts as our persistence layer and it is in memory.
 
## Model:
  Transaction class is the model. There is also TransactionDto which is a data transfer object, data class for the incoming requests
  

## Tests:
The tests are written in the BDD style. By this way there is a good contract between the requirements and the code directly.
This is achieved by writing cucumber stories and translating them to step definitions.

There are 5 tests written in the Transactions.feature
Each given, when and then in the Gherkin code are directly mapped to one of the Step definitions in the Step Definitions file
RestAssured framework is used to make the assertions. It has inbuilt methods to test the response that is returned.

Only BDD tests(which are acceptance tests) are written. 
The unit test to test the specific units are not covered as part of this challenge

