import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class escaner {

    public static void main(String[] args) {
        try{
            File f = new File("C:/Users/FABIO ANDRES/Desktop/ch2/preciosv1.txt");
            Scanner s = new Scanner(f);
            int j=1;
            Map<String, Map<String, Integer>> city = new TreeMap<>();
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
                        }else{
                            city.put(parts[1], new TreeMap<>());
                            city.get(parts[0]).put(parts[1], Integer.parseInt(parts[2]));
                            city.get(parts[1]).put(parts[0], Integer.parseInt(parts[2]));
                        }


                    }
                }
                else{
                    city.put(line, new TreeMap<>());
                }
                //System.out.println(city +"  "+ j);
                j++;
            }
            for(String key: city.keySet()){
                System.out.println(key + " tiene " + city.get(key));
            }

        }catch(FileNotFoundException e){
            System.out.println("El archivo no existe...");
        }



    }
}
