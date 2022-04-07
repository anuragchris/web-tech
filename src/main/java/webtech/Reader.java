package webtech;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Reader {

	public void readCSV() throws IOException {

		File csv = selectCSV();
		CSVReader read = new CSVReader(new FileReader(csv));

		try {
			List<String[]> al = read.readAll();
			Header head = new Header();

			for (String str : al.get(0))
				head.setHeader(str);

			Data data = new Data();

			for (int i = 1; i < al.size(); i++) {
				String str[] = al.get(i);
				data.setData(str);
			}

			FileChooser fc = new FileChooser();
			File xml = fc.selectXML();

			@SuppressWarnings("unused")
			XMLConverter convert = new XMLConverter(xml, head, data);

		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	private File selectCSV() {
		FileChooser fc = new FileChooser();
		File file = fc.selectCSV();

		return file;
	}
}
