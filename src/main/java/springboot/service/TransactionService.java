package springboot.service;

import java.util.List;

import springboot.dto.TransactionDto;
import springboot.model.Transaction;

public interface TransactionService {

	Transaction updateTransaction(long id, TransactionDto transactionDto);

	Transaction getTransactionById(long id);

	List<Long> getTransactionByType(String type);

	Double getSum(long id);

}
