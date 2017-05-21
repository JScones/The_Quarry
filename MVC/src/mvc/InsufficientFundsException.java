package mvc;

public class InsufficientFundsException extends Exception{
	
	private double amount;
	public InsufficientFundsException(double amountOver){
		amount = amountOver;
	}
	public double getAmount(){
		return amount;
	}

}
