import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KVStore {
    private static final Map<String, String> map =
            new ConcurrentHashMap<String, String>();
    public static String set(String key, String value) {
        map.put(key, value);
        return "OK";
    }
    public static String get(String key) { return map.get(key); }
}

