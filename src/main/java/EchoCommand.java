public class EchoCommand {
    public static String echoCommand(String input) {
        System.out.println("Starting echo response ");

        return BulkString.getRespValue(input);

    }
}
