package threadTest.thread;

import threadTest.Enemy;

import javax.swing.*;
import java.util.Vector;

abstract class ThreadDefault {
   protected Vector<String> wordData;
   protected Vector<Enemy> enemies;

   JPanel contentPanel;

   public void setPanel(JPanel panel){
       contentPanel = panel;
   }
}
