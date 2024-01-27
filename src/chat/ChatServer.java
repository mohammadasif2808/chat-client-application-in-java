package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mohammad asif
 * @Email: mohammadasif2808@gmail.com
 * @Date: Jan 27, 2024
 * @Time: 11:46:11 AM
 */
public class ChatServer {
    public static void main(String[] args) throws Throwable {
        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();
               
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Writer output = new OutputStreamWriter(s.getOutputStream());
        
        ChatUI chatUI = new ChatUI("Server End", output);
        
        String line;
        while((line = input.readLine()) != null) {
            chatUI.appendText(line);
        }
        chatUI.appendText("connection lost");
    }
}
