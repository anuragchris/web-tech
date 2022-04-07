package webtech;

import java.util.ArrayList;

public class Header {

	private ArrayList<String> header;

	public Header() {
		this.header = new ArrayList<String>();
	}

	public void setHeader(String head) {
		header.add(head);
	}

	public ArrayList<String> getHeader() {
		return this.header;
	}
}
