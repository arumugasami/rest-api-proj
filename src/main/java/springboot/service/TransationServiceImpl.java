package springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.dto.TransactionDto;
import springboot.model.Transaction;
import springboot.repository.TransactionRepository;

@Service("transactionService")
public class TransationServiceImpl implements TransactionService {

	TransactionRepository repository = new TransactionRepository();

	public Transaction updateTransaction(long id, TransactionDto transactionDto) {
		Double amount = transactionDto.amount;
		String type = transactionDto.type;
		Long parent_id = transactionDto.parent_id;
		Transaction transaction;
		if (parent_id != null) {
			transaction = new Transaction(id, amount, type, parent_id);
		} else {
			transaction = new Transaction(id, amount, type);
		}
		repository.addTransaction(transaction);
		return transaction;

	}

	public Transaction getTransactionById(long id) {
		return repository.getTransaction(id);

	}

	public List<Long> getTransactionByType(String type) {
		List<Transaction> transactionList = getTransactionList();
		List<Long> transactionIdList = new ArrayList<Long>();

		for (int i = 0; i < transactionList.size(); i++) {
			if (transactionList.get(i).getType().equalsIgnoreCase(type)) {
				transactionIdList.add(transactionList.get(i).getTransaction_id());
			}
		}

		return transactionIdList;
	}

	public Double getSum(long id) {
		List<Transaction> transactionList = getTransactionList();
		Double sum = 0.0;
		for (int i = 0; i < transactionList.size(); i++) {

			if (transactionList.get(i).getTransaction_id() == id) {
				sum = sum + transactionList.get(i).getAmount();
			}

			if (transactionList.get(i).getParent_id() == id) {
				sum = sum + transactionList.get(i).getAmount();
			}
		}

		return sum;

	}

	private List<Transaction> getTransactionList() {
		List<Transaction> updatedTransactionList = new ArrayList<Transaction>();
		Iterator<Transaction> transactionIterator = TransactionRepository.transactionMap.values().iterator();
		while (transactionIterator.hasNext()) {
			updatedTransactionList.add(transactionIterator.next());
		}
		return updatedTransactionList;
	}

}
