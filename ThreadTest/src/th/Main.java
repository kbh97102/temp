package th;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.Vector;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        new MainFrame();
    }
}


class T1 {

    public T1() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("123");
        ScheduledFuture<?> future = service.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);


    }
}


class MainFrame {

    private JFrame frame;
    private JPanel panel;
    private int count = 0;
    private String path = "./src/Image/test.png";
    private Vector<Enemy> enemy;
    private int randomIndex = 0;
    private JTextField tf;
    private JPanel p1;
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
    private JButton btn;

    public MainFrame() {
        frame = new JFrame();
        panel = new JPanel();
        enemy = new Vector<>();
        tf = new JTextField(30);
        panel.setLayout(null);
        p1 = new JPanel();

        btn = new JButton("Click");

        p1.setLayout(new BorderLayout());
        p1.add(panel, BorderLayout.CENTER);
        p1.add(tf, BorderLayout.SOUTH);
        p1.add(btn, BorderLayout.EAST);


        Runnable makeWordTask = () -> {
            synchronized (this) {
                randomIndex = (int) (Math.random() * 1000);
                int blindGenerate = (int)(Math.random()*100);
                if(blindGenerate >= 90){
                    Enemy blindEnemy = new Enemy(randomIndex, 0, path,true);
                    blindEnemy.setBlindTTL(5);
                    enemy.add(blindEnemy);
                }
                else{
                    enemy.add(new Enemy(randomIndex, 0, count + "", true));
                }
                panel.add(enemy.get(count++).getImg());

            }
        };
        Runnable moveTask = () -> {
            for (int i = 0; i < enemy.size(); i++) {
                if(enemy.get(i).getIsAlive()){
                    if(enemy.get(i).getBlindTTL()!=0){
                        enemy.get(i).decreaseBlindTTL();
                    }
                    if(enemy.get(i).getY() > 400){
                        enemy.get(i).changeIsAlive(false);
//                        panel.remove(enemy.get(i).getImg());
//                        panel.revalidate();
//                        panel.repaint();
                    }else{
                        enemy.get(i).down();
                    }
                }

            }
        };

        tf.addActionListener(event -> {
            String input = tf.getText();
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).word().equals(input)) {
                    enemy.get(i).changeIsAlive(false);
//                    panel.remove(enemy.get(i).getImg());
//                    panel.revalidate();
//                    panel.repaint();
                }
            }
            tf.setText("");
        });

        Runnable display = () ->{
            for(int i=0;i<enemy.size();i++){
                if(enemy.get(i).getIsAlive()){
                    enemy.get(i).draw();
                }
                else{
                    panel.remove(enemy.get(i).getImg());
                    panel.revalidate();
                    panel.repaint();
                }
            }
        };


        service.scheduleWithFixedDelay(makeWordTask, 0, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(moveTask, 0, 500, TimeUnit.MILLISECONDS);
        service.scheduleWithFixedDelay(display, 0, 14, TimeUnit.MILLISECONDS);


        frame.add(p1);
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class Enemy {
    private int x;
    private int y;
    private String path;
    private JLabel img;
    private int downSpeed = 20;
    private int blindTTL = 0;
    private int blindDecrease = 1;
    private boolean isAlive;

    public Enemy(int x, int y, String path, boolean isAlive) {
        img = new JLabel();
        this.x = x;
        this.y = y;
        this.path = path;
        this.isAlive = isAlive;
        img.setText(path);
        img.setBounds(x, y, 100, 20);
//        img.setIcon(new ImageIcon(path));
//        img.setBounds(x, y,100,100);
    }

    public JLabel getImg() {
        return img;
    }

    public String word() {
        return path;
    }

    public void down() {
        y += downSpeed;
    }
    public void draw(){
        img.setLocation(x,y);
    }

    public int getY() {
        return y;
    }
    public boolean getIsAlive(){
        return isAlive;
    }
    public void changeIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }
    public void setBlindTTL(int TTL){
        this.blindTTL = TTL;
    }
    public void decreaseBlindTTL(){
        blindTTL -= blindDecrease;
    }
    public int getBlindTTL(){
        return blindTTL;
    }
}