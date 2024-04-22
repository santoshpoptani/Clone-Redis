public class GetCommand{
    public static String getCommand(String[] arguments) {
        String key = arguments[1];
        System.out.println("Starting get response ");
        String resp = KVStore.get(key);
        return BulkString.getRespValue(resp);
    }
}
