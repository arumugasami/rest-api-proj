package springboot.dto;

public class TransactionDto {

	public double amount;

	public String type;

	public Long parent_id = null;

	public TransactionDto() {

	}

	public TransactionDto(double amount, String type, Long parent_id) {
		this.amount = amount;
		this.type = type;
		this.parent_id = parent_id;
	}

}
