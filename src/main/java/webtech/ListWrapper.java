package webtech;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;

public class ListWrapper {

	@XmlAnyElement
	public List<JAXBElement<String>> properties = new ArrayList<JAXBElement<String>>();
}
