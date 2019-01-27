package Graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.io.*;
import java.io.DataOutput;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File af = new File("t.tmp");
        if(!af.exists()) {
        GraphWeight grafo=new GraphWeight();
        grafo.loadgraph("cities.txt");
        System.out.println(grafo.shortedDistance("colombia"));
         System.out.println(grafo.shortedPath("colombia", "rusia"));
        FileOutputStream ostream = new FileOutputStream("t.tmp");
        ObjectOutputStream p = new ObjectOutputStream(ostream);
        p.writeObject(grafo);

        }
        else {
            FileInputStream istream = new FileInputStream("t.tmp");
            ObjectInputStream p = new ObjectInputStream(istream);
            GraphWeight vuelta;
            vuelta = (GraphWeight) p.readObject();
            System.out.println(vuelta.shortedDistance("rusia"));

        }
    }


}
