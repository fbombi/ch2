package Graph;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File a = new File("normal.tmp");
        File b = new File("zip.tmp");

        if(!a.exists()) {  //Question if the program has normal.tmp
        GraphWeight grafo=new GraphWeight();
        grafo.loadgraph("cities.txt");
        //Writing normal
        FileOutputStream in1 = new FileOutputStream("normal.tmp");
        ObjectOutputStream p = new ObjectOutputStream(in1);
        p.writeObject(grafo);
        //Writing zipped code from normal code
        FileInputStream in2 = new FileInputStream("normal.tmp");
        FileOutputStream out2 = new FileOutputStream("zip.tmp");
        DeflaterOutputStream zip2=new DeflaterOutputStream(out2);
        int data;
            while ((data=in2.read())!=-1)
            {
                zip2.write(data);
            }
            zip2.close();
        }
        else {
            //Read normal code from normal
            FileInputStream input = new FileInputStream("normal.tmp");
            ObjectInputStream p = new ObjectInputStream(input);
            GraphWeight read = (GraphWeight) p.readObject();
            //Read zipped code from zip.tmp
            FileInputStream input2 = new FileInputStream("zip.tmp");
            InflaterInputStream iis=new InflaterInputStream(input2);
            ObjectInputStream p2 = new ObjectInputStream(iis);
            GraphWeight read2 = (GraphWeight) p2.readObject();

            System.out.println(read2.shortedDistance("japon"));






        }
    }


}
