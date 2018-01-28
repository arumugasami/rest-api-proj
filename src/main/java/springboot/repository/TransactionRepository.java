package springboot.repository;

import java.util.HashMap;

import springboot.model.Transaction;

public class TransactionRepository {

	public static HashMap<Long, Transaction> transactionMap = new HashMap<Long, Transaction>();

	public void addTransaction(Transaction transaction) {
		transactionMap.put(transaction.getTransaction_id(), transaction);
	}

	public Transaction getTransaction(Long id) {
		return transactionMap.get(id);
	}

}
