public class SetCommand {
    public static String setCommand(String[] commands) {
        System.out.println("Starting set response ");
        String resp;
        if (commands.length == 3) {
            resp = KVStore.set(commands[1], commands[2]);
        } else if (commands.length == 5) {
            Long duration = Long.parseLong(commands[4]);
            System.out.println("Set with exp " + duration);
            resp = KVStore.set(commands[1], commands[2], duration);
        } else {
            resp = "Invalid Set call";
        }
        return SimpleString.getRespValue(resp);

    }
    public static String set(String key, String value) {
        System.out.println("Starting set response ");
        String resp = KVStore.set(key, value);
        return SimpleString.getRespValue(resp);
    }
    public static String set(String key, String value, Long expDuration) {
        System.out.println("Starting set response ");
        String resp = KVStore.set(key, value, expDuration);
        return SimpleString.getRespValue(resp);
    }
}