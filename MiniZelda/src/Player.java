import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{

    public boolean right, left, up, down;
    public int spd = 4;

    public Player(int x, int y){
        super(x, y, 32, 32);
    }

    public void tick(){
        if (right) x += spd;
        if (left) x -= spd;

        if (up) y -= spd;
        if (down) y += spd;

    }

    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
