import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUse {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = Stream.of(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(returnMap(arrayList));
    }

    public static Map<Integer, Integer> returnMap(ArrayList<Integer> arrayList) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            map.computeIfPresent(i, (k, v) -> v += 1);
            map.putIfAbsent(i, 1);
        }
        return map;
    }
}
