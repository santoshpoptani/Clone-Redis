public class PingCommand {
    public static String pingCommand() {
        System.out.println("Starting pong response ");
        String pongResponse = "+PONG" + Constants.CRLF_TERMINATOR;
        return pongResponse;
    }
}
