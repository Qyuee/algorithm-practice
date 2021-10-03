package algorithm.T1003;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice002 {
    public static void main(String[] args) {
        Map<String, Integer> map001 = new HashMap<>();
        map001.put("test", 10);
        map001.put("test2", 2);
        map001.put("test3", 5);

        List<String> collect = map001.keySet().stream().sorted((o1, o2) -> map001.get(o1) - map001.get(o2)).collect(Collectors.toList());
        collect.forEach(key -> {
            System.out.println(map001.get(key));
        });
    }
}
