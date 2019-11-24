import java.awt.*;
import javax.swing.*;

public class EditPanel extends JPanel {
	public EditPanel() {
		setBackground(Color.YELLOW);
		setLayout(new FlowLayout());
		
		TextField text;
		text = new TextField("", 30);
        add(text, BorderLayout.NORTH);
        
        
        JButton btn1;
        JButton btn2;
        btn1 = new JButton("ADD");
        btn2 = new JButton("SAVE");
        add(btn1,BorderLayout.NORTH);
        add(btn2,BorderLayout.NORTH);
	}
}
