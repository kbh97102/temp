package test;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class MainFrame {

    private JFrame mainFrame;
    private MainPanel mainPanel;

    public MainFrame(){
        mainFrame = new JFrame();

        mainPanel = new MainPanel();


        mainFrame.add(mainPanel.componentPanel);

        mainFrame.setSize(1280,720);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        System.out.println("iswork");
        new MainFrame();
    }
}
