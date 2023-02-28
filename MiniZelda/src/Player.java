import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{

    public boolean right, left, up, down;
    public int spd = 4;

    public Player(int x, int y){
        super(x, y, 32, 32);
    }

    public void tick(){
        if (right && World.isFree(x+spd, y)) x += spd;
        if (left && World.isFree(x-spd, y)) x -= spd;

        if (up && World.isFree(x, y-spd)) y -= spd;
        if (down && World.isFree(x, y+spd)) y += spd;

    }

    public void render(Graphics g){
        g.drawImage(Spritesheet.player_front, x, y, 32, 32, null);
    }
}
