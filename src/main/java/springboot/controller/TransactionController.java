package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.TransactionDto;
import springboot.model.Transaction;
import springboot.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/transaction/{transact}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTransaction(@PathVariable("transact") long id, @RequestBody TransactionDto transactionDto) {
		// transactionService.updateTransaction(transactionDto);
		Transaction transaction = transactionService.updateTransaction(id, transactionDto);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@RequestMapping(value = "/transaction/{transact}", method = RequestMethod.GET)
	public ResponseEntity<?> getTransaction(@PathVariable("transact") long id) {
		Transaction transaction = transactionService.getTransactionById(id);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);

	}

	@RequestMapping(value = "/types/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Long>> getTypes(@PathVariable("type") String type) {
		List<Long> transaction = transactionService.getTransactionByType(type);
		return new ResponseEntity<List<Long>>(transaction, HttpStatus.OK);

	}

	@RequestMapping(value = "/sum/{transact}", method = RequestMethod.GET)
	public ResponseEntity<?> getSum(@PathVariable("transact") long id) {
		Double transaction = transactionService.getSum(id);
		return new ResponseEntity<Double>(transaction, HttpStatus.OK);

	}

}
