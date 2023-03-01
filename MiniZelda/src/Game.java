import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

    public static int WIDTH = 640, HEIGHT = 480;
    public static int SCALE = 3;
    public Player player;
    public World world;

    public List<Enemy> enemies = new ArrayList<Enemy>();

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);

        new Spritesheet();

        player = new Player(32, 32);
        world = new World();

        enemies.add(new Enemy(32, 32));
        enemies.add(new Enemy(32, 64));

    }

    public void tick() {
        player.tick();

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).tick();
        }
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).render(g);
        }

        player.render(g);

        world.render(g);

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = true;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) player.left = true;
        
        if (e.getKeyCode() == KeyEvent.VK_UP) player.up = true;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) player.down = true;

        if (e.getKeyCode() == KeyEvent.VK_Z) player.shoot = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = false;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) player.left = false;
        else if (e.getKeyCode() == KeyEvent.VK_UP) player.up = false;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) player.down = false;
    }
    
}
