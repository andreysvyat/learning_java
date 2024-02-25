package learning;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

@SuppressWarnings("ALL")
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
        inputField.addActionListener(e -> {
            String userInput = inputField.getText();
            outputArea.append(userInput + "\n");
            inputField.setText(""); // Clear the input field after processing
        });
        ((AbstractDocument)inputField.getDocument()).setDocumentFilter(new HighlightDocumentFilter(inputField, "{}[]()<>", Color.pink));

        outputArea = new JTextArea();
        outputArea.setEditable(false); // Make output area read-only
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleInterface simpleInterface = new SimpleInterface();
            simpleInterface.setVisible(true);
        });
    }
}
