package lt.eif.viko.mjakovcenko.client;

import java.io.*;
import java.net.Socket;

public class JavaClient {

        private Socket clientSocket;

        public void startConnection(String ip, int port) throws IOException {
            clientSocket = new Socket(ip, port);
            System.out.println("Connected to server. Receiving file...");
            receiveFile("client.xml");
        }

        public void stopConnection() {
            try {
                if (clientSocket != null && !clientSocket.isClosed()) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println("Exception occurred while closing resources: " + e.getMessage());
            }
        }

        public void receiveFile(String filePath) {
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                 InputStream socketInputStream = clientSocket.getInputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = socketInputStream.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
                System.out.println("File received successfully.");
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
            } finally {
                stopConnection();
            }
        }


}

