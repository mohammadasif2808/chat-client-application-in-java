
package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author mohammad asif
 * @Email: mohammadasif2808@gmail.com
 * @Date: Jan 27, 2024
 * @Time: 8:14:35 AM
 */
public class TestIt {

    public static void main(String[] args) throws Throwable {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        ChatUI chatUI = new ChatUI("Window Title", new OutputStreamWriter(System.out));
        String line;
        while ((line = keyboard.readLine()) != null) {
            chatUI.appendText(line);
        }
    }
}
