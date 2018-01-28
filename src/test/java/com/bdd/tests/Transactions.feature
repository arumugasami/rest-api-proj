Feature: Webservice Testing of countries
  
  Background: 
    Given There is transactions api
    
   Scenario Outline: Saving a standalone transactiom
  
     Given there is a standalone <transaction>
     When the user posts the transaction
     Then the new transaction is saved
      
    Examples:
    | transaction |
    |1|
     
   Scenario Outline: Saving a linked transaction
     Given there is a linked <transaction>  with <parent>
     When the user posts the transaction
     Then the new transaction is saved
     
     Examples:
    | transaction |parent|
    |2|1|
      
    Scenario Outline: User requests for an existing transaction
    Given there is a standalone <transaction>
    When the user requests the transaction
    Then the transaction is returned
    Examples:
    |transaction|
    |1|
    
    Scenario Outline: User requests for the same transaction type
    When the user requests the transaction <type>
    Then all the same type of transactions are returned
    Examples:
    |type|
    |car|
    
    Scenario Outline: User requests for the sum of transactions
    When the user requests the sum of the <transaction>
    Then the sum of all the transaction is returned
    Examples:
    |transaction|
    |1|
 