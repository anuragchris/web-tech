package webtech;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser {

	private File file;

	protected File selectCSV() {
		JFileChooser jf = new JFileChooser();
		jf.setDialogTitle("Select CSV");
		jf.setMultiSelectionEnabled(false);
		jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jf.setFileHidingEnabled(true);

		if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			file = jf.getSelectedFile();

		if (this.file == null)
			throw new NullPointerException("Please Choose a Valid CSV File");

		StringBuilder path = new StringBuilder(file.getAbsolutePath());

		if (path.substring(path.length() - 3).equalsIgnoreCase("csv"))
			return file;

		throw new UnsupportedOperationException("Choosen file is not CSV type");
	}

	protected File selectXML() {
		JFileChooser jf = new JFileChooser();
		jf.setDialogTitle("Select or Create XML File");
		jf.setMultiSelectionEnabled(false);
		jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jf.setFileHidingEnabled(true);

		if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			file = jf.getSelectedFile();

		if (this.file == null)
			throw new NullPointerException("Please Choose a Valid XML File");

		StringBuilder path = new StringBuilder(file.getAbsolutePath());

		if (path.substring(path.length() - 3).equalsIgnoreCase("xml"))
			return file;

		throw new UnsupportedOperationException("Choosen file is not XML type");
	}
}
