import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KVStore {
    private static final Map<String, Pair> map = new ConcurrentHashMap<>();
    public static String set(String key, String value) {
        Pair p = new Pair(value, -1l);
        map.put(key, p);
        return "OK";
    }
    public static String set(String key, String value, Long expDuration) {
        Long expDur = System.currentTimeMillis() + expDuration;
        Pair p = new Pair(value, expDur);
        map.put(key, p);
        return "OK";
    }
    public static String get(String key) {
        Pair p = map.get(key);
        Long currMilli = System.currentTimeMillis();
        if (p != null && (p.expTimeStamp == -1 || p.expTimeStamp > currMilli)) {
            return p.value;
        }
        return null;

    }
}

