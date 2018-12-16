package xmlParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

import contact.receipt;
import contact.vatTotal;

public class processor extends xmlParser {

	
	
	
	
	
	
	
	public boolean proc(String url) {

		String head = "Z No FişNo      Fiş Tarihi    Toplam    Kdv [Oran  Tutar    Kdv; Oran  Tutar    Kdv; Oran  Tutar    Kdv; Oran  Tutar    Kdv; ]";

     writeTxt(head, url+"output.txt");

		
		for (receipt r : sortingList(parsingDoc(ReadingDoc(url)))) {

			 writeTxt(resize(String.valueOf(r.getzNo()),4,digit(r.getzNo()))+" "
					 +resize(String.valueOf(r.getReceiptNo()), 5, digit(r.getReceiptNo()))+"   "
					 +r.getReceiptDate()
					 +resizeSpace(String.valueOf(r.getTotal()),7)
					 +resizeSpace(String.valueOf(r.getVat()),7)+" [ "
					 +"%"
					 +resize(String.valueOf(r.getVatTotals().get(0).getVatRate()),2,digit(r.getVatTotals().get(0).getVatRate()))
					 +resizeSpace(String.valueOf(r.getVatTotals().get(0).getSaleAmount()),7)
					 +resizeSpace(String.valueOf(r.getVatTotals().get(0).getVatAmount()),7)+";  "
					 +"%"
					 +resize(String.valueOf(r.getVatTotals().get(1).getVatRate()),2,digit(r.getVatTotals().get(1).getVatRate()))
					 +resizeSpace(String.valueOf(r.getVatTotals().get(1).getSaleAmount()),7)
					 +resizeSpace(String.valueOf(r.getVatTotals().get(1).getVatAmount()),7)+";  "
					 +"%"
					 +resize(String.valueOf(r.getVatTotals().get(2).getVatRate()),2,digit(r.getVatTotals().get(2).getVatRate()))
					 +resizeSpace(String.valueOf(r.getVatTotals().get(2).getSaleAmount()),7)
					 +resizeSpace(String.valueOf(r.getVatTotals().get(2).getVatAmount()),7)+";  "
					 +"%"
					 +resize(String.valueOf(r.getVatTotals().get(3).getVatRate()),2,digit(r.getVatTotals().get(3).getVatRate()))
					 +resizeSpace(String.valueOf(r.getVatTotals().get(3).getSaleAmount()),7)
					 +resizeSpace(String.valueOf(r.getVatTotals().get(3).getVatAmount()),7)+"; "
					 +"]"
					 ,url+"output.txt");
			 
			
		}
		 return true;
	}

	private int digit(int getzNo) {
		// TODO Auto-generated method stub
		int x = 1;
		int digit = 1;
		while (getzNo / x > 9) {
			x = x * 10;
			digit++;
		}

		return digit;
	}

	private String resize(String getzNo, int i, int j) {
		while (i - j > 0) {
			getzNo = "0" + getzNo;
			i--;
		}
		return getzNo;
	}
	private String resizeSpace(String getzNo, int size) {
		
		int length=getzNo.length();
		for(int i=0;i<size-length;i++)
			getzNo = " " + getzNo;
			
		
		return getzNo;
	}
private String resizeSpaceEnd(String getzNo, int size) {
		
		for(int i=0;i<size-getzNo.length();i++)
			getzNo = getzNo+" ";
			
		
		return getzNo;
	}

	@Override
	public ArrayList<receipt> parsingDoc(Document document) {
		// TODO Auto-generated method stub
		Element classElement = document.getRootElement().getChild("Receipts");

		List<Element> receiptList = classElement.getChildren();

		ArrayList<receipt> receiptArrayList = new ArrayList<>();
		for (Element receipt : receiptList) {

			List<Element> vatList = receipt.getChild("VatTotals").getChildren();

			ArrayList<vatTotal> vatTotalList = new ArrayList<>();
			for (Element vat : vatList) {
				// System.out.println(vat.getChild("VatRate").getText());
				vatTotalList.add(new vatTotal(Integer.parseInt(vat.getChild("VatRate").getText()),
						Double.parseDouble(vat.getChild("SaleAmount").getText()),
						Double.parseDouble(vat.getChild("VatAmount").getText())));
			}
			receiptArrayList.add(new receipt(Integer.parseInt(receipt.getChild("ZNo").getText()),
					Integer.parseInt(receipt.getChild("ReceiptNo").getText()),
					receipt.getChild("ReceiptDate").getText(), Double.parseDouble(receipt.getChild("Vat").getText()),
					Double.parseDouble(receipt.getChild("Total").getText()), vatTotalList));

		}
		return receiptArrayList;
	}

	@Override
	public ArrayList<receipt> sortingList(ArrayList list) {
		// TODO Auto-generated method stub

		ArrayList<receipt> rlist = list;
		int n = list.size();
		receipt temp;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (rlist.get(j - 1).getTotal() > rlist.get(j).getTotal()) {
					Collections.swap(rlist, j - 1, j);
				}

			}
		}

		return rlist;
	}

}
