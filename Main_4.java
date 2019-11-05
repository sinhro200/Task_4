package Task_4;




import Task_4.AVT.DrawPanel;

import javax.swing.*;

public class Main_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPanel drawPanel = new DrawPanel();
        frame.add(drawPanel);

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
