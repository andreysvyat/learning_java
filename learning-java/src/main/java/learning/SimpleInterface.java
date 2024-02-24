package learning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterface extends JFrame {
    private static final long serialVersionUID = 7935744483864663534L;
	private JTextField inputField;
    private JTextArea outputArea;

    public SimpleInterface() {
        setTitle("Simple Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                outputArea.append(userInput + "\n");
                inputField.setText(""); // Clear the input field after processing
            }
        });

        outputArea = new JTextArea();
        outputArea.setEditable(false); // Make output area read-only
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleInterface simpleInterface = new SimpleInterface();
                simpleInterface.setVisible(true);
            }
        });
    }
}
