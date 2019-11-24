import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
	private JLabel text = new JLabel("타이핑해보세요");
	public GamePanel() {
		setLayout(new BorderLayout());
		add(new JGameGroundPanel(), BorderLayout.CENTER);
		add(new JInputPanel(), BorderLayout.SOUTH);
	}
	
	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			
			setLayout(null);
			text.setSize(100,30);
			text.setLocation(100, 10);
			add(text);
		}
	}
	class JInputPanel extends JPanel {
		public JInputPanel() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
			
			add(new TextField("",55));
			add(new JButton("입력"));
			
			
            
            
		}
	}
}
