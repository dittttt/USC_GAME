package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        setDefaultValues();
        getPlayerImage();
    }
// SET DEFAULT VALUES OF PLAYER HERE
    public void setDefaultValues(){
        worldX = gp.tileSize * 12;
        worldY = gp.tileSize * 6;
        speed = 4;
        direction = "right";
        }
    
    public void getPlayerImage(){
        
        try {
            
            System.out.println("Image loading started");
         // load sprite images....
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Up4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Down4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Left4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/MC_Right4.png"));
            System.out.println("Image loading ended");
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
    }

    public void update(){
    	
    	int imageCycler = 0;
    	
    	if(keyH.upPressed == false && keyH.downPressed == false && 
    			keyH.leftPressed == false && keyH.rightPressed == false) {
    		spriteNum = 1;
    	}
    	
    	if(keyH.shiftPressed == false) {
    			speed = 4;
    			imageCycler = 10;
    	} else {
    			speed = 10;
    			imageCycler = 7;
    	}
    	
		if(keyH.upPressed == true || keyH.downPressed == true || 
    	   keyH.leftPressed == true || keyH.rightPressed == true) {
    	
			if(keyH.upPressed == true && keyH.rightPressed == true) {
    			direction = "up";
// NORMAL = y -= speed
    			worldY -= (speed/1.4);
    			worldX += (speed/1.4);
    		}
			else if(keyH.upPressed == true && keyH.leftPressed == true) {
    			direction = "up";
    			worldY -= (speed/1.4);
    			worldX -= (speed/1.4);
    		}
			else if(keyH.downPressed == true && keyH.leftPressed == true) {
    			direction = "down";
    			worldY += (speed/1.4);
    			worldX -= (speed/1.4);
    		}
			else if(keyH.downPressed == true && keyH.rightPressed == true) {
    			direction = "down";
    			worldY += (speed/1.4);
    			worldX += (speed/1.4);
    		}
			else if(keyH.upPressed == true){
    			direction = "up";
    			worldY -= speed;
    		}
    		else if(keyH.downPressed == true){
    			direction = "down";
    			worldY += speed;
    		}
    		else if(keyH.leftPressed == true) {
    			direction = "left";
    			worldX -= speed;
    		}
    		else if(keyH.rightPressed == true) {
    			direction = "right";
    			worldX += speed;
    		}
    

    		spriteCounter++;
    		if(spriteCounter > imageCycler) {
    			if(spriteNum == 1) {
    				spriteNum = 2;
    			}
    			else if(spriteNum == 2) {
    				spriteNum = 3;
    			}
    			else if(spriteNum == 2) {
    				spriteNum = 3;
    			}
    			else if(spriteNum == 3) {
    				spriteNum = 4;
    			}
    			else if(spriteNum == 4) {
    				spriteNum = 1;
    			}
    			spriteCounter = 0;
    		}
    	}
    	
    }
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction){
// UP DIRECTION
        case "up":
        	if(spriteNum == 1) {
        		image = up1;
        	}
        	if(spriteNum == 2) {
        		image = up2;
        	}
        	if(spriteNum == 3) {
        		image = up3;
        	}
        	if(spriteNum == 4) {
        		image = up4;
        	}
        	break;
        	
// DOWN DIRECTION
        case "down":
        	if(spriteNum == 1) {
        		image = down1;
        	}
        	if(spriteNum == 2) {
        		image = down2;
        	}
        	if(spriteNum == 3) {
        		image = down3;
        	}
        	if(spriteNum == 4) {
        		image = down4;
        	}
        	break;
        	        	
// LEFT DIRECTION 
        case "left":
        	if(spriteNum == 1) {
        		image = left1;
        	}
        	if(spriteNum == 2) {
        		image = left2;
        	}
        	if(spriteNum == 3) {
        		image = left3;
        	}
        	if(spriteNum == 4) {
        		image = left4;
        	}
        	break;
        	        	
// RIGHT DIRECTION
        case "right":
        	if(spriteNum == 1) {
        		image = right1;
        	}
        	if(spriteNum == 2) {
        		image = right2;
        	}
        	if(spriteNum == 3) {
        		image = right3;
        	}
        	if(spriteNum == 4) {
        		image = right4;
        	}
        	break;
        	
        	
                    }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize*2, null);
    }
}
