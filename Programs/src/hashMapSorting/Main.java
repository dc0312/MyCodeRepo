package hashMapSorting;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("aaa",10);
        unsortedMap.put("bbb",20);
        unsortedMap.put("ccc",40);
        unsortedMap.put("ddd",30);

        /*for (Map.Entry e: unsortedMap.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());
        }*/

        //List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(unsortedMap.entrySet());
        //Collections.sort(list,( o1,  o2) -> -o1.getValue().compareTo(o2.getValue()));

        List<Map.Entry<String,Integer>> list = new ArrayList<>(unsortedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        LinkedHashMap<String,Integer> sortedHashMap = new LinkedHashMap<>();

        list.stream().forEachOrdered(l -> sortedHashMap.put(l.getKey(),l.getValue()));

        //list.stream().sorted().forEach(System.out::println);
        //System.out.println(sortedHashMap.entrySet().stream().findFirst().get());


        for (Map.Entry e: sortedHashMap.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());
        }



    }
}
