public class SetCommand {
    public static String setCommand(String key, String value) {
        System.out.println("Starting set response ");
        String resp = KVStore.set(key, value);
        return SimpleString.getRespValue(resp);
    }
}