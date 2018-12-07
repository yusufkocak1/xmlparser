package contact;

import java.util.ArrayList;

public class receipt {
 private int zNo;
 private int receiptNo;
 private String receiptDate;
 private double vat;
 private double Total;
 private ArrayList<vatTotal> vatTotals;
public receipt(int zNo, int receiptNo, String receiptDate, double vat, double total, ArrayList<vatTotal> vatTotals) {
	super();
	this.zNo = zNo;
	this.receiptNo = receiptNo;
	this.receiptDate = receiptDate;
	this.vat = vat;
	Total = total;
	this.vatTotals = vatTotals;
}
public int getzNo() {
	return zNo;
}
public void setzNo(int zNo) {
	this.zNo = zNo;
}
public int getReceiptNo() {
	return receiptNo;
}
public void setReceiptNo(int receiptNo) {
	this.receiptNo = receiptNo;
}
public String getReceiptDate() {
	return receiptDate;
}
public void setReceiptDate(String receiptDate) {
	this.receiptDate = receiptDate;
}
public double getVat() {
	return vat;
}
public void setVat(double vat) {
	this.vat = vat;
}
public double getTotal() {
	return Total;
}
public void setTotal(double total) {
	Total = total;
}
public ArrayList<vatTotal> getVatTotals() {
	return vatTotals;
}
public void setVatTotals(ArrayList<vatTotal> vatTotals) {
	this.vatTotals = vatTotals;
}

}
