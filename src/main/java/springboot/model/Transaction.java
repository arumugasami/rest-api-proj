package springboot.model;

public class Transaction {

	private final long transaction_id;

	private double amount;

	private String type;

	private long parent_id;

	public Transaction(long transaction_id, double amount, String type, long parent_id) {
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.type = type;
		this.parent_id = parent_id;
	}

	public Transaction(long transaction_id, double amount, String type) {
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getTransaction_id() {
		return transaction_id;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

}
