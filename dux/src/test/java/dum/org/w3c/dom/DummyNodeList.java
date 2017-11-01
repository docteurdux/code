package dum.org.w3c.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DummyNodeList implements NodeList {

	List<Node> nodes = new ArrayList<>();

	@Override
	public Node item(int index) {
		if (index < 0 || index >= nodes.size()) {
			return null;
		}
		return nodes.get(index);
	}

	@Override
	public int getLength() {
		return nodes.size();
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

}
