import java.awt.Color;
import java.awt.Graphics;

public class DrawObstacle {
    GamePanel GamePanel;
    KeyboardInput Button;
    GenerateObstacle GeneratedObstacle;

    // obstacle position
    private int obstacleSpeed;
    public int obstacleX;
    public int obstacleWidth; //szerokosc ta sama dla obu typow przeszkody

    public int type1ObstacleY;
    public int type1ObstacleHeight;

    public int type2ObstacleHeightTop;
    public int type2ObstacleYTop;
    public int type2ObstacleHeightBottom;
    public int type2ObstacleYBottom;

    public DrawObstacle(GamePanel GamePanel, int initPositionX, GenerateObstacle GeneratedObstacle) {
        this.GamePanel = GamePanel;
        this.GeneratedObstacle = GeneratedObstacle;
        this.obstacleX = initPositionX;
        switch(GeneratedObstacle.type){
            case 1:
                this.type1SetDefaultValues();
                break;
            case 2:
                this.type2SetDefaultValues();
                break;
        }
    }

    private void type1SetDefaultValues() {
        type1ObstacleHeight = GeneratedObstacle.type1Height;
        obstacleWidth = GeneratedObstacle.type1Width;
        type1ObstacleY = GeneratedObstacle.type1PositionY; 
        obstacleSpeed = 8;
    }

    private void type2SetDefaultValues() {
        obstacleWidth = GeneratedObstacle.type2Width;
        type2ObstacleHeightTop = GeneratedObstacle.type2HeightTop;
        type2ObstacleYTop = GeneratedObstacle.type2PositionYTop; 
        type2ObstacleHeightBottom = GeneratedObstacle.type2HeightBottom;
        type2ObstacleYBottom = GeneratedObstacle.type2PositionYBottom;
        obstacleSpeed = 8;
    }

    public void update() {
        obstacleX = obstacleX - obstacleSpeed;
    }

    public void draw(Graphics g) {
        switch(GeneratedObstacle.type){
            case 1:
                g.setColor(Color.BLUE);
                g.fillRect(obstacleX, type1ObstacleY, obstacleWidth, type1ObstacleHeight);
                break;
            case 2:
                g.setColor(Color.BLUE);
                g.fillRect(obstacleX, type2ObstacleYTop, obstacleWidth, type2ObstacleHeightTop);
                g.fillRect(obstacleX, type2ObstacleYBottom, obstacleWidth, type2ObstacleHeightBottom);
                break;
        }
    }
}