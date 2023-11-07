package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[56];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
	        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Outside.png"));
	        
//	        LOOP FOR TILES 1 - 55
	        for(int i=1; i<56; i++) {
	        	 tile[i] = new Tile();
	        	 tile[i].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Outside" + i + ".png"));
	        }
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/world01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col <gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col==gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
			
		}
	}
	
}
