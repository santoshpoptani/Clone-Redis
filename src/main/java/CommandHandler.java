import java.io.OutputStream;

public class CommandHandler {
    public static String processCommand(String parsedCommand, OutputStream dOut) {
        String[] arguments = parsedCommand.split(" ");
        String command = arguments[0].toLowerCase();
        String result;
        switch (command) {
            case "ping":
                result = PingCommand.pingCommand();
                break;
            case "echo":
                result = EchoCommand.echoCommand(arguments[1]);
                break;
            default:
                throw new RuntimeException("Unknown command: " + command);
        }
        return result;
    }
}
