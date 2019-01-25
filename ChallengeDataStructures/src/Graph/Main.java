package Graph;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {


        GraphWeight grafo=new GraphWeight();
        grafo.loadgraph("C:/Users/fbombiela/ch2/cities.txt");
        System.out.println(grafo.shortedDistance("colombia"));
         System.out.println(grafo.shortedPath("colombia", "rusia"));
    }
}
