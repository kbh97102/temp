package threadTest;

import javax.swing.*;

public class Enemy {
    private String word;
    private int x;
    private int y;
    private boolean alive;
    private boolean heal;
    private boolean blind;
    private int moveSpeed=10;
    private JLabel label;


    public Enemy(String word, int x, boolean heal, boolean blind){
        this.word = word;
        this.x = x;
        y = 0;
        this.alive = true;
        this.heal = heal;
        this.blind = blind;
        label =new JLabel();
        label.setText(word);
        label.setBounds(x,y,100,20);
    }

    public void changeAlive(boolean state){
        alive = state;
    }
    public int getY(){
        return y;
    }
    public synchronized void move(){
        y += moveSpeed;
    }
    public synchronized void draw(){
        label.setLocation(x, y);
    }
    public JLabel getLabel(){
        return label;
    }
    public boolean isAlive(){
        return alive;
    }
    public String getWord(){
        return word;
    }
}
