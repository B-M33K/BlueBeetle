import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;
    public Player(GamePanel gamePanel, KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);
        setDefaultValues();
        getPlayerImage();
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
    }

    public void setDefaultValues(){
        worldX = gamePanel.tileSize * 23;
        worldY = gamePanel.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
            up1 = new ImageIcon("assets/Player/Walking_sprites/boy_up_1.png").getImage();
            up2 = new ImageIcon("assets/Player/Walking_sprites/boy_up_2.png").getImage();
            down1 = new ImageIcon("assets/Player/Walking_sprites/boy_down_1.png").getImage();
            down2 = new ImageIcon("assets/Player/Walking_sprites/boy_down_2.png").getImage();
            left1 = new ImageIcon("assets/Player/Walking_sprites/boy_left_1.png").getImage();
            left2 = new ImageIcon("assets/Player/Walking_sprites/boy_left_2.png").getImage();
            right1 = new ImageIcon("assets/Player/Walking_sprites/boy_right_1.png").getImage();
            right2 = new ImageIcon("assets/Player/Walking_sprites/boy_right_2.png").getImage();
    }
    public void update(){
        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
                worldY -= speed;
            }
            if (keyHandler.downPressed) {
                direction = "down";
                worldY += speed;
            }
            if (keyHandler.leftPressed) {
                direction = "left";
                worldX -= speed;
            }
            if (keyHandler.rightPressed) {
                direction = "right";
                worldX += speed;
            }
            collisionOn = false;
            gamePanel.collisionCheker.checkTile(this);
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D graphics2D){
        Image image = null;
        switch (direction) {
            case "up" :
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down" :
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left" :
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right" :
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        graphics2D.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
