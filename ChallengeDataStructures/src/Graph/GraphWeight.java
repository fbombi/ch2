package Graph;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

public class GraphWeight implements Serializable {


    private TreeMap<String,TreeMap<String, Integer>> graph;

    GraphWeight() {
        graph = new TreeMap<String,TreeMap<String, Integer>>();
    }

    public void setGraph(TreeMap<String,TreeMap<String, Integer>> graph) {
        this.graph = graph;
    }


    public void loadgraph(String address){
        TreeMap<String,TreeMap<String, Integer>> city=graph;


        try{
            File f = new File(address);
            Scanner s = new Scanner(f);

            while(s.hasNextLine()){
                String line = s.next();
                String [] parts=line.split(",");
                if(parts.length!=1){
                    if(city.containsKey(parts[0])&&city.containsKey(parts[1])) {
                        city.get(parts[0]).put(parts[1], Integer.parseInt(parts[2]));
                        city.get(parts[1]).put(parts[0], Integer.parseInt(parts[2]));
                    }
                    else{
                        if(!city.containsKey(parts[0])){
                            city.put(parts[0], new TreeMap<>());
                            city.get(parts[0]).put(parts[1], Integer.parseInt(parts[2]));

                            if(!city.containsKey(parts[1])){
                                city.put(parts[1], new TreeMap<>());
                                city.get(parts[1]).put(parts[0], Integer.parseInt(parts[2]));
                            }
                            else{
                                city.get(parts[1]).put(parts[0], Integer.parseInt(parts[2]));
                            }
                        }
                        else{
                            city.put(parts[1], new TreeMap<>());
                            city.get(parts[0]).put(parts[1], Integer.parseInt(parts[2]));
                            city.get(parts[1]).put(parts[0], Integer.parseInt(parts[2]));
                        }

                    }
                }
                else{
                    city.put(line, new TreeMap<>());
                }

            }

        }catch(FileNotFoundException e){
            System.out.println("El archivo no existe...");
        }
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
        //
    }
}
