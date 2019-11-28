package threadTest.thread;

import threadTest.Enemy;

import java.util.Vector;

public class MakeWordTask extends ThreadDefault implements Runnable{

    public MakeWordTask(Vector<Enemy> enemies, Vector<String> wordData){
        this.enemies = enemies;
        this.wordData = wordData;
    }

    @Override
    public void run() {


        int randomIndex = (int) (Math.random() * wordData.size());
        int randomXpos = (int) (Math.random() * 600);
        Enemy normalEnemy = new Enemy(wordData.get(randomIndex), randomXpos, false, false);
        enemies.add(normalEnemy);
        contentPanel.add(normalEnemy.getLabel());
//                System.out.println("MakeWord");

    }
}
