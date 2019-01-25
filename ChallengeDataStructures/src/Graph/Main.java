package Graph;

import javafx.util.Pair;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        GraphWeight city = new GraphWeight();

        for (int i = 1; i < 6; i++)
            city.addNode(Integer.toString(i));

        city.addEdge("1", "2", 5);
        city.addEdge("1", "3", 2);
        city.addEdge("3", "4", 1);
        city.addEdge("1", "4", 6);
        city.addEdge("3", "5", 5);

        System.out.println(city.shortedPath("1"));

    }
}
