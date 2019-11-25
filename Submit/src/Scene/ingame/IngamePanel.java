package Scene.ingame;

import Scene.WordManage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Vector;

public class IngamePanel {
    private JPanel contentPanel;
    private JPanel ingameMainPanel;
    private JPanel ingameRightPanel;
    private JPanel scorePanel;
    private JPanel lifePanel;
    private JPanel userImagePanel;
    private JLabel testLabel;
    private JTextField userInputTF;
    private JToolBar toolBar;
    private JButton saveWordDataButton;
    private JButton loadWordDataButton;
    private JPanel forLifeAndUserImage;
    private ScorePanel scp;
    private LifePanel lp;
    private Vector<String> wordData;
    private WordAddDelPanel wordAddDelPanel;


    private JPanel wordManagePanel;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    private JTextField textField;
    private JButton addButton;
    private JButton delButton;
    private JButton saveButton;

    public IngamePanel(){
        init();
        setWordManagePanel();
        userInputTF.requestFocus();
        setToolBar();
        //test
        testLabel = new JLabel(generateWord());
        testLabel.setFont(new Font("바탕", Font.BOLD, 20));

        //layout
        ingameMainPanel.setLayout(new BorderLayout());
        ingameRightPanel.setLayout(new BorderLayout());
        forLifeAndUserImage.setLayout(new BorderLayout());

        ingameRightPanel.setPreferredSize(new Dimension(320, 720));
        scorePanel.setPreferredSize(new Dimension(320, 180));
        lifePanel.setPreferredSize(new Dimension(320, 180));
        userImagePanel.setPreferredSize(new Dimension(320, 350));

        //background
        ingameMainPanel.setBackground(new Color(240,255,240));
        lifePanel.setBackground(new Color(230,230,255));
        scorePanel.setBackground(new Color(240,255,240));
        //edge
        scorePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN.brighter().brighter(), 1));
        lifePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE.brighter().brighter(), 1));
        userImagePanel.setBorder(new LineBorder(Color.GREEN, 1));

        userInputTF.setPreferredSize(new Dimension(ingameMainPanel.getWidth(),50));
        userInputTF.setFont(new Font("굴림", Font.BOLD, 20));

        //add
        ingameMainPanel.add(userInputTF, BorderLayout.SOUTH);
        ingameMainPanel.add(testLabel, BorderLayout.CENTER);

        ingameRightPanel.add(scorePanel, BorderLayout.NORTH);
        ingameRightPanel.add(forLifeAndUserImage, BorderLayout.CENTER);

        forLifeAndUserImage.add(wordManagePanel, BorderLayout.CENTER);
        forLifeAndUserImage.add(lifePanel, BorderLayout.NORTH);


        contentPanel.add(ingameRightPanel, BorderLayout.EAST);
        contentPanel.add(ingameMainPanel, BorderLayout.CENTER);
        contentPanel.add(toolBar, BorderLayout.NORTH);


        userInputTF.addActionListener(text->{
            String input = userInputTF.getText();
            userInputTF.setText("");
            if(input.equals(testLabel.getText())){
                testLabel.setText(generateWord());
                scp.scoreIncrease();
            }
        });
    }
    private void init(){
        //panel
        wordAddDelPanel = new WordAddDelPanel();
        contentPanel = new JPanel();
        scp = new ScorePanel();
        lp = new LifePanel();
        contentPanel = new JPanel();
        ingameMainPanel = new JPanel();
        ingameRightPanel = new JPanel();
        ingameRightPanel.setPreferredSize(new Dimension(320, 720));
        scorePanel = scp.getScorePanel();
        lifePanel = lp.getLifePanel();
        userImagePanel = new JPanel();
        userImagePanel.setBackground(Color.ORANGE);
        forLifeAndUserImage = new JPanel();

        //ingameMainPanel
        userInputTF = new JTextField(30);
        contentPanel.setLayout(new BorderLayout());

        wordData = new Vector<>();
        wordData = WordManage.getInstance().getWordData();

        textFieldPanel = new JPanel();
        wordManagePanel = new JPanel();
        buttonPanel = new JPanel();
        textField = new JTextField(15);
        addButton = new JButton("Add");
        delButton = new JButton("Delete");
        saveButton = new JButton("Save");
    }
    public String generateWord(){
        wordData = WordManage.getInstance().getWordData();
        int randomIndex = (int)(Math.random()*wordData.size());
        String word = wordData.get(randomIndex);

        return word;
    }
    private void setToolBar(){
        toolBar = new JToolBar();
        saveWordDataButton = new JButton("SaveWordData");
        loadWordDataButton = new JButton("LoadWordData");

        saveWordDataButton.addActionListener(event->{
            wordData = WordManage.getInstance().getWordData();
        });
        loadWordDataButton.addActionListener(event ->{
            WordManage.getInstance().saveWordToFile();
        });

        toolBar.add(saveWordDataButton);
        toolBar.add(loadWordDataButton);
    }
    public JPanel getContentPanel(){
        return contentPanel;
    }
    public void setWordManagePanel(){
        wordManagePanel.setLayout(new GridLayout(1, 2));
        buttonPanel.setLayout(new GridLayout(3,1));
        textFieldPanel.setLayout(new GridLayout(1,1));

        textFieldPanel.add(textField);
        buttonPanel.add(addButton);
        buttonPanel.add(delButton);
        buttonPanel.add(saveButton);

        addButton.addActionListener(event -> {
            String input = textField.getText();
            wordData.add(input);
            textField.setText("");
        });
        delButton.addActionListener(event ->{
            String input = textField.getText();
            if(wordData.contains(input)){
                wordData.remove(input);
            }else{
                JOptionPane.showMessageDialog(null,"삭제 할 내용이 없습니다.","삭제 에러", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText("");
        });
        saveButton.addActionListener(event -> {
            WordManage.getInstance().replaceWordData(wordData);
        });

        wordManagePanel.add(textFieldPanel);
        wordManagePanel.add(buttonPanel);
    }
}
