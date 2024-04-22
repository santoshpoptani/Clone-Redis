public class GetCommand{
    public static String getCommand(String key) {
        System.out.println("Starting get response ");
        String resp = KVStore.get(key);
        return BulkString.getRespValue(resp);
    }
}
