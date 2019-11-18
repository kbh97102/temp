package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

abstract public class DefaultPanel  {
    protected JPanel componentPanel;
    protected JButton btn;
    protected Vector<String> wordData;

    abstract public void change(ActionEvent e1);

}
