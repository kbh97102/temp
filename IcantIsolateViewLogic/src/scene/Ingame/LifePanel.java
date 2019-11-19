package scene.Ingame;

import javax.swing.*;
import java.awt.*;

public class LifePanel {

    private JPanel lifePanel;
    private JLabel lifeTextPanel;
    private JLabel lifeIntPanel;
    private int currentLife = 10;
    private int lifeIncreasement = 1;
    private int lifeDecreasement = 1;

    public LifePanel(){
        lifePanel = new JPanel();

        lifeIntPanel = new JLabel(Integer.toString(currentLife));
        lifeIntPanel.setFont(new Font("바탕",Font.BOLD, 30));
        lifeTextPanel = new JLabel("LIFE : ");
        lifeTextPanel.setFont(new Font("바탕", Font.BOLD, 30));

        lifePanel.add(lifeTextPanel);
        lifePanel.add(lifeIntPanel);
    }

    public void changeStartLife(int newLifeCount){
        currentLife = newLifeCount;
    }
    public JPanel getLifePanel(){
        return lifePanel;
    }
    public void lifeIncrese(){
        currentLife += lifeIncreasement;
    }
    public void lifeDecrease(){
        currentLife -= lifeDecreasement;
    }
}
