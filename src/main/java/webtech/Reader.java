package webtech;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Reader {

	public void readCSV() throws IOException {

		String loc = "C:\\Users\\Anurag PC\\Desktop\\data.csv";
		CSVReader read = new CSVReader(new FileReader(loc));

		try {
			List<String[]> al = read.readAll();

			for (int i = 0; i < 1; i++) {
				
				for (String[] str : al) {
					
					for (int j = 0; j < str.length; j++)
						System.out.print(str[j] + " ");
					
					System.out.println();
				}
			}
		} catch (CsvException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws IOException {
		Reader read = new Reader();
		read.readCSV();
	}
}
