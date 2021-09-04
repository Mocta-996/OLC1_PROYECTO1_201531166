/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1_201531166;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author Emely
 */
public class Tabs extends JPanel {

    RSyntaxTextArea textArea;
    private String path;

    public Tabs() {
        super(new BorderLayout());
        textArea = new RSyntaxTextArea(20,70);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCurrentLineHighlightColor(Color.WHITE);
        textArea.setCaretColor(Color.BLACK);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 16));
        RTextScrollPane sp = new RTextScrollPane(textArea);
     
        this.add(sp);
    }

    Tabs(String texto, String path) {
        super(new BorderLayout());
        textArea = new RSyntaxTextArea(20,70);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCurrentLineHighlightColor(Color.WHITE);
        textArea.setCaretColor(Color.BLACK);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 16));
        RTextScrollPane sp = new RTextScrollPane(textArea);
      
        this.add(sp);
        this.path = path;
        this.textArea.setText(texto);
    }

    String getText() {
        return textArea.getText();
    }

    boolean isEmptyText() {
        return this.textArea.getText().isEmpty();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
