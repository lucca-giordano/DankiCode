import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

    public static int WIDTH = 480, HEIGHT = 480;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }

    public void tick() {
            
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 100, 100);
        g.fillRect(100, 100, 100, 100);
        g.fillRect(200, 200, 100, 100);
        g.fillRect(300, 300, 100, 100);
        g.fillRect(400, 400, 100, 100);

        g.fillRect(200, 0, 100, 100);
        g.fillRect(300, 100, 100, 100);
        g.fillRect(400, 200, 100, 100);

        g.fillRect(0, 200, 100, 100);
        g.fillRect(100, 300, 100, 100);
        g.fillRect(200, 400, 100, 100);

        g.fillRect(0, 400, 100, 100);
        g.fillRect(400, 0, 100, 100);

        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game); // Adds the game to the frame
        frame.setTitle("Tela teste"); // Sets the title of the frame 
        frame.pack(); // Packs the frame
        frame.setLocationRelativeTo(null); // Sets the location of the frame to the center of the screen 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation to exit the program
        frame.setResizable(false); // Sets the frame to not be resizable
        frame.setVisible(true); // Sets the frame to be visible
        
        new Thread(game).start(); // Starts the game thread
    }

    public void run() {

        while(true) {
            tick();
            render();
            try{
                Thread.sleep(1000/60);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    
}
