import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

public class Blocks extends Rectangle {

    public Blocks(int x, int y) {
        super(x, y, 32, 32);
    }

    public void render(Graphics g) {
        g.drawImage(Spritesheet.tile_wall, x, y, 32, 32, null);
    }
    
}
