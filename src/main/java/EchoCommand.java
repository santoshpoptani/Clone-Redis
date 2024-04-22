public class EchoCommand {
    public static String echoCommand(String[] input) {
        String echoString = input[1];
        System.out.println("Starting echo response ");
        return BulkString.getRespValue(echoString);
    }
}
