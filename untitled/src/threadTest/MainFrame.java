package threadTest;

import threadTest.thread.DrawTask;
import threadTest.thread.MakeWordTask;
import threadTest.thread.MoveWordTask;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainFrame {

    private JFrame mainFrame;
    private JButton btn;
    private JPanel contentPanel;
    private JPanel dropPanel;
    private Vector<String> wordData;
    private Vector<Enemy> enemies;
    private ScheduledExecutorService service;
    private int testCount = 0;
    private JTextField tf;

    public MainFrame() {
        init();

        putTestWord();
        contentPanel.setLayout(new BorderLayout());
        dropPanel.setLayout(null);
        //Runnable

//        JLabel l = new JLabel("test");
//        l.setBounds(100,900,100,50);
//        panel.add(l);
        MakeWordTask makeWord = new MakeWordTask(enemies, wordData);
        makeWord.setPanel(dropPanel);
        MoveWordTask moveWord = new MoveWordTask(enemies,wordData);
        moveWord.setPanel(dropPanel);
        DrawTask drawTask = new DrawTask(enemies, wordData);
        drawTask.setPanel(dropPanel);

        if (JOptionPane.showConfirmDialog(mainFrame, "start", "start", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            service.scheduleWithFixedDelay(makeWord, 0, 1000, TimeUnit.MILLISECONDS);
            service.scheduleWithFixedDelay(moveWord, 0, 300, TimeUnit.MILLISECONDS);
            service.scheduleWithFixedDelay(drawTask, 0, 300, TimeUnit.MILLISECONDS);
        }

        tf.addActionListener(event ->{
            for(Enemy enemy : enemies){
                if(enemy.getWord().equals(tf.getText())){
                    enemy.changeAlive(false);
                }
            }
            tf.setText("");
        });


        //add
        contentPanel.add(tf, BorderLayout.SOUTH);
        contentPanel.add(dropPanel,BorderLayout.CENTER);
        mainFrame.add(contentPanel);

        //frameSetting
        mainFrame.setSize(720, 900);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void putTestWord() {
        wordData.add("1");
        wordData.add("2");
        wordData.add("3");
        wordData.add("4");
        wordData.add("5");
        wordData.add("6");
        wordData.add("7");
        wordData.add("8");
        wordData.add("9");
        wordData.add("10");
    }

    private void init() {
        mainFrame = new JFrame();
        contentPanel = new JPanel();
        wordData = new Vector<>();
        enemies = new Vector<>();
        service = Executors.newScheduledThreadPool(3);
        tf = new JTextField(30);
        dropPanel = new JPanel();

    }

}
