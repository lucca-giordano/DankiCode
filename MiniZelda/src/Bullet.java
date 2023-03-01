import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Rectangle{
    
    public int dir = 1;
    public int speed = 8;

    public int frames = 0;

    public Bullet(int x, int y, int dir){
        super(x, y, 4, 4);
        this.dir = dir;
    }

    public void tick(){
        x += speed*dir;
        frames++;
        if (frames == 60) {
            Player.Bullets.remove(this);
            return;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRoundRect(x+16, y+16, width, height, width, height);
    }

}
