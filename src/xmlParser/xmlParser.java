package xmlParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public abstract class xmlParser {

	public Document ReadingDoc(String url) {
		try {
			File inputFile = new File(url);
			SAXBuilder saxBuilder = new SAXBuilder();

			Document document = (Document) saxBuilder.build(inputFile);

			return document;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public abstract ArrayList parsingDoc(Document doc);

	public abstract ArrayList sortingList(ArrayList list);

	public void writeTxt(String line,String url) {
		try {
			FileWriter fw=new FileWriter(url,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(line+"\n");
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
