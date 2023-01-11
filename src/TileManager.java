import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("assets/Map/world01.txt");
    }

    public void getTileImage(){
        tiles[0] =new Tile();
        tiles[0].image = new ImageIcon("assets/tiles/grass.png").getImage();

        tiles[1] =new Tile();
        tiles[1].image = new ImageIcon("assets/tiles/wall.png").getImage();
        tiles[1].colision = true;

        tiles[2] =new Tile();
        tiles[2].image = new ImageIcon("assets/tiles/water.png").getImage();
        tiles[2].colision = true;

        tiles[3] =new Tile();
        tiles[3].image = new ImageIcon("assets/tiles/earth.png").getImage();

        tiles[4] =new Tile();
        tiles[4].image = new ImageIcon("assets/tiles/tree.png").getImage();
        tiles[4].colision = true;

        tiles[5] =new Tile();
        tiles[5].image = new ImageIcon("assets/tiles/sand.png").getImage();

    }
    public void loadMap(String mapfile){
        try {
            File map = new File(mapfile);
            BufferedReader br = new BufferedReader(new FileReader(map));
            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow){
                String line = br.readLine();
                while (col < gamePanel.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                 }
                if (col == gamePanel.maxWorldCol){
                    col = 0;
                    row ++;
                }
            }
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D){
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){
            int   tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if(worldX + gamePanel.tileSize> gamePanel.player.worldX - gamePanel.player.screenX &&
                    worldX - gamePanel.tileSize< gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize> gamePanel.player.worldY - gamePanel.player.screenY &&
                    worldY - gamePanel.tileSize< gamePanel.player.worldY + gamePanel.player.screenY){

                graphics2D.drawImage(tiles[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }
            worldCol ++;
            if(worldCol == gamePanel.maxWorldCol){
                worldCol = 0;
                worldRow ++;
            }
        }
    }
}
