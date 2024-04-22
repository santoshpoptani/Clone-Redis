import java.io.*;
import java.net.Socket;

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
            BufferedReader bufferedReader = new BufferedReader(reader);
            // Get the output stream from the client socket and write data to it using
            // a BufferedWriter
            OutputStreamWriter writer =
                    new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String command;
            while ((command = bufferedReader.readLine()) != null) {
                // If the command is PING, write +PONG back to the client
                if (command.equalsIgnoreCase("ping")) {
                    // Read the data from the client and write it back to the client
                    bufferedWriter.write("+PONG\r\n");
                }
                // Flush the buffered writer
                bufferedWriter.flush();
            }
        }catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }

    }
}
