import java.util.TreeMap;
import java.util.ArrayList;

public class GraphWeight {

    private TreeMap<String,TreeMap<String, Integer>> graph;

    GraphWeight() {
        graph = new TreeMap<String,TreeMap<String, Integer>>();
    }

    public void addNode(String node) {
        if (graph.containsKey(node))
            graph.put(node, new TreeMap<String, Integer>());
    }

    public void addEdge(String source, String destination, int weight) {
        if (graph.containsKey(source)) {
            graph.get(source).put(destination, weight);
        }
    }

    public ArrayList<String> shortedPath(String source, String destination) {
        return null;
    }

    public TreeMap<String, Integer> shortLength(String source) {
        return null;
    }
}
