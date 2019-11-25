package Scene.ingame;

import javax.swing.*;
import java.awt.*;

public class WordAddDelPanel {

    private JPanel wordManagePanel;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    private JTextField textField;
    private JButton addButton;
    private JButton delButton;
    private JButton saveButton;



    public WordAddDelPanel() {
        init();
        wordManagePanel.setLayout(new GridLayout(1, 2));
        buttonPanel.setLayout(new GridLayout(3,1));
        textFieldPanel.setLayout(new GridLayout(1,1));

        textFieldPanel.add(textField);
        buttonPanel.add(addButton);
        buttonPanel.add(delButton);
        buttonPanel.add(saveButton);

        wordManagePanel.add(textFieldPanel);
        wordManagePanel.add(buttonPanel);
    }

    private void init() {
        textFieldPanel = new JPanel();
        wordManagePanel = new JPanel();
        buttonPanel = new JPanel();
        textField = new JTextField(15);
        addButton = new JButton("Add");
        delButton = new JButton("Delete");
        saveButton = new JButton("Save");
    }
    public JPanel getContentPanel(){
        return wordManagePanel;
    }
}
