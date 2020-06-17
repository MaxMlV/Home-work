package network.systemMemory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socketClient;
    private String answer;
    private Thread thread;

    public Client(Socket socketClient, String answer) {
        super();
        this.socketClient = socketClient;
        this.answer = answer;
        thread = new Thread(this);
        thread.start();
    }

    public Client() {
        super();
    }

    @Override
    public void run() {
        try (InputStream inputStream = socketClient.getInputStream();
             OutputStream outputStream = socketClient.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream)) {
            byte[] rec1 = new byte[inputStream.available()];
            inputStream.read(rec1);

            String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n" +
            "Content-Length: \r\n" + "Connection-Close: \r\n\r\n";

            writer.print(response + answer);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
