package Work1.Day10.Example9_9;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Arrays;

/**
 * ********概述：
 */
public class TextListener implements DocumentListener {

    WindowDocument view;

    public void setView(WindowDocument view) {
        this.view = view;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        String str = view.inputText.getText();
        String regex = "[\\s\\d\\p{Punct}]+";
        String[] words = str.split(regex);
        Arrays.sort(words);
        view.showText.setText(null);
        for (int i = 0; i < words.length; i++) {
            view.showText.append(words[i] + ",");
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }
}
