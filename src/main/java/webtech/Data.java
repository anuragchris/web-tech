package webtech;

import java.util.ArrayList;

public class Data {

	private ArrayList<String[]> data;

	public Data() {
		this.data = new ArrayList<String[]>();
	}

	public void setData(String st[]) {
		data.add(st);
	}

	public ArrayList<String[]> getData() {
		return this.data;
	}
}
