import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

    public static int WIDTH = 480, HEIGHT = 480;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game); // Adds the game to the frame
        frame.setTitle("Zelda clone"); // Sets the title of the frame 
        frame.pack(); // Packs the frame
        frame.setLocationRelativeTo(null); // Sets the location of the frame to the center of the screen 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation to exit the program
        frame.setResizable(false); // Sets the frame to not be resizable
        frame.setVisible(true); // Sets the frame to be visible
        
        new Thread(game).start(); // Starts the game thread
    }

    public void run() {

        while(true) {
            System.out.println("Chamando game loop");
        }

    }
    
}
