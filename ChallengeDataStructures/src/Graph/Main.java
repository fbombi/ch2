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
        GraphWeight grafo = new GraphWeight();
        TreeMap<String, TreeMap<String, Integer>> city = new TreeMap<>();

        try{
            File f = new File("C:/Users/fbombiela/Documents/CH2/ch2-master/ch2-master/preciosv1.txt");
            Scanner s = new Scanner(f);
            int j=1;
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
                j++;
            }

        }catch(FileNotFoundException e){
            System.out.println("El archivo no existe...");
        }

        grafo.setGraph(city);
        System.out.println(grafo.shortedDistance("colombia"));
         System.out.println(grafo.shortedPath("colombia", "rusia"));
        System.out.println(grafo.shortedPath("colombia", "rusia"));
    }
}
