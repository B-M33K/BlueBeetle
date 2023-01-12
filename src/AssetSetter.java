public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {this.gamePanel = gamePanel;}

    public void setObject() {
        gamePanel.objs[0] = new Key();
        gamePanel.objs[0].worldX = 23 * gamePanel.tileSize;
        gamePanel.objs[0].worldY = 7 * gamePanel.tileSize;

        gamePanel.objs[1] = new Key();
        gamePanel.objs[1].worldX = 23 * gamePanel.tileSize;
        gamePanel.objs[1].worldY = 40 * gamePanel.tileSize;

        gamePanel.objs[2] = new Key();
        gamePanel.objs[2].worldX = 37 * gamePanel.tileSize;
        gamePanel.objs[2].worldY = 7 * gamePanel.tileSize;

        gamePanel.objs[3] = new Door();
        gamePanel.objs[3].worldX = 10 * gamePanel.tileSize;
        gamePanel.objs[3].worldY = 11 * gamePanel.tileSize;

        gamePanel.objs[4] = new Door();
        gamePanel.objs[4].worldX = 8 * gamePanel.tileSize;
        gamePanel.objs[4].worldY = 28 * gamePanel.tileSize;

        gamePanel.objs[5] = new Door();
        gamePanel.objs[5].worldX = 12 * gamePanel.tileSize;
        gamePanel.objs[5].worldY = 22 * gamePanel.tileSize;

        gamePanel.objs[6] = new Chest();
        gamePanel.objs[6].worldX = 10 * gamePanel.tileSize;
        gamePanel.objs[6].worldY = 7 * gamePanel.tileSize;

        gamePanel.objs[7] = new Boot();
        gamePanel.objs[7].worldX = 37 * gamePanel.tileSize;
        gamePanel.objs[7].worldY = 42 * gamePanel.tileSize;
    }
}
