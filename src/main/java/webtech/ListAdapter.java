package webtech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class ListAdapter extends XmlAdapter<ListWrapper, Map<String, String>> {

	@Override
	public Map<String, String> unmarshal(ListWrapper v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListWrapper marshal(Map<String, String> v) throws Exception {

		ListWrapper wrapper = new ListWrapper();
		List<JAXBElement<String>> elements = new ArrayList<JAXBElement<String>>();
		for (Map.Entry<String, String> property : v.entrySet()) {
			elements.add(new JAXBElement<String>(new QName(property.getKey()), String.class, property.getValue()));
		}
		wrapper.properties = elements;
		return wrapper;
	}

	public ListWrapper convert(Data data, Header header) throws Exception {
		for (int i = 0; i < data.getData().size(); i++) {
			int count = 1;
			Map<String, String> rowdata = new HashMap<>();
			for (int j = 0; j < data.getData().get(i).length; j++) {
				rowdata.put(header.getHeader().get(j), data.getData().get(i)[j]);

			}
			marshal(rowdata);

		}

		return null;
	}
}
