import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args){
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");
      final String pong = "+PONG\r\n";

    //  Uncomment this block to pass the first stage
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        int port = 6379;
        try {
          serverSocket = new ServerSocket(port);
          // Since the tester restarts your program quite often, setting SO_REUSEADDR
          // ensures that we don't run into 'Address already in use' errors
          serverSocket.setReuseAddress(true);
          // Wait for connection from client.
          clientSocket = serverSocket.accept();
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

        } catch (IOException e) {
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
