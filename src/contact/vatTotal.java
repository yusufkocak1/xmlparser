package contact;

public class vatTotal {

	private int vatRate;
	private double saleAmount;
	private double vatAmount;
	public vatTotal(int vatRate, double saleAmount, double vatAmount) {
		super();
		this.vatRate = vatRate;
		this.saleAmount = saleAmount;
		this.vatAmount = vatAmount;
	}
	public int getVatRate() {
		return vatRate;
	}
	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}
	public double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}
	public double getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}
	
}
