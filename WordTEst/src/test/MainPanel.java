package test;

import logic.WordManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class MainPanel extends DefaultPanel {

    private JPanel mainPanel;

    private static MainPanel instance;

    private JButton wordManageButton;


    public MainPanel() {
        componentPanel = new JPanel();
        componentPanel.setLayout(new BorderLayout());
        wordData = new Vector<>();


        if(wordData.isEmpty()){
            wordData = new Vector<>();
            new ReadWord(wordData);
            for(String word : wordData){
                System.out.println(word);
            }
        }
        else{

        }

        wordManageButton = new JButton("WordManage");

        wordManageButton.addActionListener(event -> {
            componentPanel.removeAll();
            componentPanel.add(new WordManage(wordData).componentPanel);
            componentPanel.revalidate();
            componentPanel.repaint();
        });

//        componentPanel.add(wordManageButton);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(200,200));
        p1.setBackground(Color.RED);


        btn = new JButton("click");
        btn.addActionListener(this::change);
        componentPanel.add(btn, BorderLayout.EAST);
        componentPanel.add(p1, BorderLayout.CENTER);
    }

    public static MainPanel getInstance(){
        if(instance == null){
            instance = new MainPanel();
        }
        return instance;
    }

    @Override
    public void change(ActionEvent e1) {
        componentPanel.removeAll();
        componentPanel.add(new WordManage(wordData).componentPanel);
        componentPanel.revalidate();
        componentPanel.repaint();
    }
}
