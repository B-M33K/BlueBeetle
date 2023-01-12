import javax.swing.*;
import java.awt.*;

public class Entity {
    public int worldX, worldY;
    public int speed;
    public Image up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter  = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = false;
}
