public class EchoCommand {
    public static String echoCommand(String input) {
        System.out.println("Starting echo response ");
        String echoResponse =
                "$" + input.length() + Constants.CRLF_TERMINATOR + input + Constants.CRLF_TERMINATOR;
        return echoResponse;

    }
}
