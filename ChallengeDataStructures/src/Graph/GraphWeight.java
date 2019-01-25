package Graph;

import javafx.util.Pair;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;

public class GraphWeight {

    public void

    private TreeMap<String,TreeMap<String, Integer>> graph;

    GraphWeight() {
        graph = new TreeMap<String,TreeMap<String, Integer>>();
    }

    public void setGraph(TreeMap<String,TreeMap<String, Integer>> graph) {
        this.graph = graph;
    }

    public void addNode(String node) {
        if (!graph.containsKey(node))
            graph.put(node, new TreeMap<String, Integer>());
    }

    public void addEdge(String source, String destination, int weight) {
        if (graph.containsKey(source)) {
            graph.get(source).put(destination, weight);
        }
    }

    public TreeMap<String, Integer> shortedDistance(String source) {
        TreeMap<String, Boolean> visited = new TreeMap<>();
        TreeMap<String, Integer> distance = new TreeMap<>();


        for (String node: this.graph.keySet()) {
            visited.put(node, false);
            distance.put(node, Integer.MAX_VALUE);
        }

        distance.replace(source, 0);
        PriorityQueue<Pair<Integer, String>> nodeList = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        nodeList.add(new Pair<>(0, source));

        String currentNode;
        int size;

        while (!nodeList.isEmpty()) {
            currentNode = nodeList.poll().getValue();

            if (visited.get(currentNode))
                continue;

            visited.replace(currentNode, true);

            for (String link: graph.get(currentNode).keySet()) {
                size = graph.get(currentNode).get(link);


                if (distance.get(currentNode) + size < distance.get(link)) {
                    distance.replace(link, distance.get(currentNode) + size);
                    nodeList.add(new Pair<>(distance.get(link), link));
                }
            }

        }

        return distance;
    }


    public ArrayList<String> shortedPath(String source, String destination) {
        TreeMap<String, Boolean> visited = new TreeMap<>();
        TreeMap<String, Integer> distance = new TreeMap<>();
        TreeMap<String, String> path = new TreeMap<>();


        for (String node: this.graph.keySet()) {
            visited.put(node, false);
            distance.put(node, Integer.MAX_VALUE);
        }

        distance.replace(source, 0);
        path.put(source, null);
        PriorityQueue<Pair<Integer, String>> nodeList = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        nodeList.add(new Pair<>(0, source));

        String currentNode;
        int size;

        while (!nodeList.isEmpty()) {
            currentNode = nodeList.poll().getValue();

            if (visited.get(currentNode))
                continue;

            visited.replace(currentNode, true);

            for (String link: graph.get(currentNode).keySet()) {
                size = graph.get(currentNode).get(link);


                if (distance.get(currentNode) + size < distance.get(link)) {
                    distance.replace(link, distance.get(currentNode) + size);
                    path.put(link, currentNode);
                    nodeList.add(new Pair<>(distance.get(link), link));
                }
            }

        }

        ArrayList<String> shortPath = new ArrayList<>();
        String aux = destination;
        while(path.get(aux) != null) {
            shortPath.add(aux);
            aux = path.get(aux);
        }
        shortPath.add(source);
        Collections.reverse(shortPath);
        return shortPath;
    }
}
