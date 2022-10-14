import java.awt.Color;
import java.awt.Graphics;

public class Character{
    GamePanel GamePanel;
    KeyboardInput Button;

    //character position
    int characterX;
    int characterY;
    int characterSpeed;
    int characterFreeFall;
    int freeFallTime;
    int characterHeight;
    int characterWidth;
    int characterInertiaTimeLeft;
    int characterMoveTime;

    public Character(GamePanel GamePanel, KeyboardInput Button){
        this.GamePanel = GamePanel;
        this.Button = Button;
        this.setDefaultValues();
    }

    public void setDefaultValues(){
        characterHeight = GamePanel.tileSize;
        characterWidth = GamePanel.tileSize;
        characterX = 100;
        characterY = GamePanel.screenHeight - characterHeight;
        characterSpeed = 12;
        characterFreeFall = 16;
        freeFallTime = 8;
        characterInertiaTimeLeft = 23;
        characterMoveTime = 14;
    }

    public void update() {
        if(Button.spacePressed == false){
            characterMoveTime = 14;
            if(characterInertiaTimeLeft > 0){
                characterY = characterY - ((characterInertiaTimeLeft^2)/18)*characterFreeFall; //bezwladnosc
                characterInertiaTimeLeft = characterInertiaTimeLeft - 2;
            }
            if(characterInertiaTimeLeft <= 0){
                characterY = characterY + ((freeFallTime^2)/16)*characterFreeFall; //spadanie
                freeFallTime++;
            }
        }
        if(characterY > (GamePanel.screenHeight - GamePanel.tileSize)){
            characterY = GamePanel.screenHeight - GamePanel.tileSize;
        }
        if(Button.spacePressed == true){
            characterY = characterY - ((characterMoveTime^2)/19)*characterSpeed; //skok
            characterMoveTime++;
            freeFallTime = 8;
            characterInertiaTimeLeft = 23;
        }
        if(characterY < 0){
            characterY = 0;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(characterX, characterY, characterWidth, characterHeight);
    }
}
