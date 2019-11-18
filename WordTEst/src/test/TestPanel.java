package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TestPanel extends DefaultPanel {



    public TestPanel(){
        componentPanel = new JPanel();
        componentPanel.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(200,200));
        p1.setBackground(Color.orange);

        btn =  new JButton("click");
        componentPanel.add(btn, BorderLayout.EAST);
        componentPanel.add(p1, BorderLayout.CENTER);

        btn.addActionListener(this::change);

    }


    @Override
    public void change(ActionEvent e1) {
        componentPanel.removeAll();
        componentPanel.add(new MainPanel().componentPanel);
        componentPanel.revalidate();
        componentPanel.repaint();
    }
}
