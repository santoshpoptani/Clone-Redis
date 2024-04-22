import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ConnectionHandler implements Runnable{
    private Socket clientSocket;
    private String pong;

    public ConnectionHandler(Socket clientSocket, String pong) {
        this.clientSocket = clientSocket;
        this.pong = pong;
    }

    @Override
    public void run() {
        try {


            InputStream in = clientSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            DataInputStream dataInputStream =
                    new DataInputStream(clientSocket.getInputStream());
            // Get the output stream from the client socket and write data to it using
            // a BufferedWriter
            OutputStream dataOut = clientSocket.getOutputStream();
            while (true) {
                String parsedCommand = ProtocolParser.parseInput(dataInputStream);
                String result = CommandHandler.processCommand(parsedCommand, dataOut);
                dataOut.write(result.getBytes(StandardCharsets.UTF_8));
                dataOut.flush();
            }
        }catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                System.out.println("Exception closing connection " + e);
            }
        }

    }
}
