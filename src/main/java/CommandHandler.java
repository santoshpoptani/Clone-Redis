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
            case "set":
                result = SetCommand.setCommand(arguments[1], arguments[2]);
                break;
            case "get":
                result = GetCommand.getCommand(arguments[1]);
                break;
            default:
                throw new RuntimeException("Unknown command: " + command);
        }
        return result;
    }
}
