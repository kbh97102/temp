package threadTest.thread;

import threadTest.Enemy;

import java.util.Vector;

public class MoveWordTask extends ThreadDefault implements Runnable {

    public MoveWordTask(Vector<Enemy> enemies, Vector<String> wordData) {
        this.enemies = enemies;
        this.wordData = wordData;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (Enemy enemy : enemies) {
                if (enemy.isAlive()) {
                    if (enemy.getY() >= 1000) {
                        enemy.changeAlive(false);
                    } else {
                        enemy.move();
                    }
                }
            }
        }
    }
}
