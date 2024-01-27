package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 *
 * @author mohammad asif
 * @Email: mohammadasif2808@gmail.com
 * @Date: Jan 27, 2024
 * @Time: 11:41:33 AM
 */
public class ChatClient {
    public static void main(String[] args) throws Throwable {
        Socket s = new Socket("127.0.0.1", 1234);
        
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Writer output = new OutputStreamWriter(s.getOutputStream());
        
        ChatUI chatUI = new ChatUI("Client End", output);
        
        String line;
        while((line = input.readLine()) != null) {
            chatUI.appendText(line);
        }
        chatUI.appendText("connection lost");
    }
}
