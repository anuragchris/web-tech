package webtech;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class XMLConverter {

	private PrintWriter writer;
	private File xml;

	public XMLConverter(File xml, Header head, Data d) {
		this.xml = xml;
		convert(head, d);
	}

	private void convert(Header head, Data d) {
		ArrayList<String> header = head.getHeader();

		writer = initializeXML();

		for (String data[] : d.getData())
			writeNextRow(header, data);

		finishXML();
	}

	private PrintWriter initializeXML() {
		try {
			writer = new PrintWriter(this.xml, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		writer.println("<root>");
		return writer;
	}

	private void writeNextRow(ArrayList<String> header, String[] data) {
		writer.println("    <row>");

		for (int i = 0; i < header.size(); i++)
			writer.println("        <" + header.get(i) + ">" + data[i] + "</" + header.get(i) + ">");

		writer.println("    </row>");
	}

	private void finishXML() {
		writer.println("</root>");
		writer.close();
	}
}
