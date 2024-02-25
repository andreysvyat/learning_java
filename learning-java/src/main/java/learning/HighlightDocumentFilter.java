package learning;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

@SuppressWarnings("ALL")
public class HighlightDocumentFilter extends DocumentFilter {

    private final DefaultHighlighter.DefaultHighlightPainter highlightPainter;
    private final String highlightChars;
    private final JTextComponent field;
    private final SimpleAttributeSet background;

    public HighlightDocumentFilter(JTextComponent field) {
        this(field, "{}", Color.yellow);
    }

    public HighlightDocumentFilter(JTextComponent field, Color color) {
        this(field, "{}", color);
    }

    public HighlightDocumentFilter(JTextComponent field, String highlightChars, Color color) {
        this.field = field;
        background = new SimpleAttributeSet();
        StyleConstants.setBackground(background, Color.RED);
        this.highlightChars = highlightChars;
        this.highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(color);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        super.insertString(fb, offset, text, attr);
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

        super.replace(fb, offset, length, text, attrs);

        int startIndex = offset - 1;
        if (startIndex >= 0) {
            String last = fb.getDocument().getText(startIndex, 1);
            if (highlightChars.contains(last)) {
                field.getHighlighter().addHighlight(startIndex, startIndex + 1, highlightPainter);
            }
        }
    }
}
