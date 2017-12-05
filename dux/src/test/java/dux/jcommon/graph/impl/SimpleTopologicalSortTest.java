package dux.jcommon.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import jcommon.graph.CyclicGraphException;
import jcommon.graph.IEdge;
import jcommon.graph.IVertex;
import jcommon.graph.ObjectVertex;
import jcommon.graph.impl.AdjacencyList;
import jcommon.graph.impl.Edge;
import jcommon.graph.impl.SimpleTopologicalSort;

public class SimpleTopologicalSortTest extends AbstractTest {

	@Test
	public void test() throws CyclicGraphException {

		Map<String, String> m = new HashMap<>();
		m.put("a", "b");
		m.put("b", "c");

		Set<IVertex<String>> vertices = new HashSet<>();
		Set<IEdge<IVertex<String>>> edges = new HashSet<>();

		for (Entry<String, String> e : m.entrySet()) {
			ObjectVertex<String> vk = new ObjectVertex<>(e.getKey());
			ObjectVertex<String> vv = new ObjectVertex<>(e.getValue());
			vertices.add(vk);
			vertices.add(vv);
			edges.add(new Edge<>(vk, vv));
		}

		aeq(3, vertices.size());

		SimpleTopologicalSort<IVertex<String>, String, String> sts = new SimpleTopologicalSort<>();
		List<String> result = sts.sort(new AdjacencyList<>(vertices, edges));
		for (String r : result) {
			System.out.println(r);
		}
	}

}
