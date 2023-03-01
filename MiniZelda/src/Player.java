import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{

    public boolean right, left, up, down;
    public int spd = 4;

    public int curAnimation = 0;

    public int curFrames = 0, targetFrames = 15;

    public static List<Bullet> Bullets = new ArrayList<Bullet>();

    public boolean shoot = false;

    public int dir = 1;

    public Player(int x, int y){
        super(x, y, 32, 32);
    }

    public void tick(){

        boolean moved = false;

        if (right && World.isFree(x+spd, y)){
            x += spd;
            moved = true;
            dir = 1;
        }
        if (left && World.isFree(x-spd, y)){
            x -= spd;
            moved = true;
            dir = -1;
        }

        if (up && World.isFree(x, y-spd)){
            y -= spd;
            moved = true;
        }
        if (down && World.isFree(x, y+spd)){
            y += spd;
            moved = true;
        }

        if(moved){
            curFrames++;
            if (curFrames == targetFrames) {
                curFrames = 0;
                curAnimation++;
                if (curAnimation == Spritesheet.player_front.length) {
                    curAnimation = 0;
                }
            }
        }

        if(shoot){
            shoot = false;
            Bullets.add(new Bullet(x, y, 1));
            System.out.println(Bullets.size());
        }

        for(int i = 0; i<Bullets.size(); i++){
            Bullets.get(i).tick();
        }

    }

    public void render(Graphics g){
        g.drawImage(Spritesheet.player_front[curAnimation], x, y, 32, 32, null);

        for(int i = 0; i<Bullets.size(); i++){
            Bullets.get(i).render(g);
        }
    }
}
