package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author mohammad asif
 * @Email: mohammadasif2808@gmail.com
 * @Date: Jan 27, 2024
 * @Time: 9:30:35 AM
 */
public class ChatUI {

    private JFrame frame;
    private JScrollPane scrollPane;
    private JTextArea chatText;
    private JTextField entryText;

    public ChatUI(final String title, final Writer output) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame(title);  // BorderLayout is default
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                chatText = new JTextArea();
                chatText.setEditable(false);
                scrollPane = new JScrollPane(chatText);
                frame.add(scrollPane, BorderLayout.CENTER);

                entryText = new JTextField();
                frame.add(entryText, BorderLayout.SOUTH);
                entryText.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String line = entryText.getText();
                        try {
                            output.write(line + "\n");
                            output.flush();
                        } catch (IOException ex) {
                            chatText.append("Other party hung up!");
                        }
                        chatText.append("ME: " + line + "\n");
                        entryText.setText("");
                    }
                });

                frame.setBounds(20, 20, 300, 300);
                frame.setVisible(true);
            }
        });
    }

    public void appendText(final String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatText.append("THEY: "+ message + "\n");
            }

        });
    }
}
