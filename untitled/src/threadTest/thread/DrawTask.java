package threadTest.thread;

import threadTest.Enemy;

import java.util.Vector;

public class DrawTask extends ThreadDefault implements Runnable {

    public DrawTask(Vector<Enemy> enemies, Vector<String> wordData) {
        this.enemies = enemies;
        this.wordData = wordData;
    }

    @Override
    public void run() {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
//                    System.out.println(enemy.getWord());
                enemy.draw();
            } else {
                contentPanel.remove(enemy.getLabel());
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        }
    }
}
