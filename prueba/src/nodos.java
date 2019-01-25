import java.util.*;


class nodos {
    public static void main(String[] args) {

        // create a graph
        Map<String, Map<String, Integer>> city = new TreeMap<>();

        // add a node
        city.put("Bogota", new TreeMap<>());

        // add a link
        city.get("Bogota").put("Cartagena", 5);
        city.get("Bogota").put("Cali", 5);
        city.get("Bogota").put("Villavicencio", 5);

        System.out.println(city);
        // {Bogota={Cali=5, Cartagena=5, Villavicencio=5}}
    }
}