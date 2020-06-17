package network.systemMemory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MassageService {
    private String answer = "";
    private int requestNumber;

    public MassageService() {
        super();
    }

    public String getURLInfo() {
        requestNumber++;
        answer += "<html><head><title>Server</title> <meta charset = 'utf-8'></head><body><h1>System information: "
                + "</h1><br>";
        answer += "<p> Total memory (bytes): " + Runtime.getRuntime().totalMemory() + "</p>";
        answer += "<p> Free memory (bytes): " + Runtime.getRuntime().freeMemory() + "</p>";
        answer += "<p> Available processors: " + Runtime.getRuntime().availableProcessors() + "</p>";
        answer += "<p> Request to server: " + requestNumber + "</p><br>";
        answer += "</body></html>";

        return answer;
    }

    public void serverMassage() {
        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                Socket clientSocket =   serverSocket.accept();
                Client client = new Client(clientSocket, getURLInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
