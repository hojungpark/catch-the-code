package main;

import javax.swing.*;
import Game.*;

/**
* Main class to instantiate the JFrame add the GamePanel and start the GameThread.
* @author Group 21
*/
public class Main {

    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);
        window.setTitle("Catch the Code");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
