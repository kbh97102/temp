import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel();
	private	ScorePanel scorePanel = new ScorePanel();
	private EditPanel editPanel = new EditPanel();
	
	public GameFrame() {
		super("Ÿ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		splitPane();
		createToolBar();
		this.setJMenuBar(makeMenu());
		
		setVisible(true);
	}
	private void splitPane() {
		JSplitPane hPane = new JSplitPane();
		getContentPane().add(hPane, BorderLayout.CENTER);
		
		hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);		
		hPane.setDividerLocation(500);
		hPane.setEnabled(false); // split bar�� ������ �� ������ �ϱ� ����
		hPane.setLeftComponent(gamePanel);
		
		JSplitPane pPane = new JSplitPane();
		hPane.setRightComponent(pPane);
		pPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pPane.setDividerLocation(200);
		pPane.setTopComponent(scorePanel);
		pPane.setBottomComponent(editPanel);
	}
	
	public JMenuBar makeMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add("Open");
		fileMenu.add("Close");
		
		mb.add(fileMenu);
		return mb;
	}
	
	private void createToolBar() {
		JToolBar tb = new JToolBar();
		tb.add(new JButton("����"));
		tb.add(new JButton("�Ͻ�����"));
		tb.add(new JButton("�ݱ�"));
		getContentPane().add(tb,BorderLayout.NORTH);
	}
}
