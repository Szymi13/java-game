import java.util.Random;

public class GenerateObstacle {
    Random Random = new Random();
    GamePanel GamePanel;
    
    public int type;

    //jeden klocek
    private int type1MinHeight;
    private int type1MaxHeight;
    private int type1MaxPositionY;

    public int type1Height;
    public int type1Width;
    public int type1PositionY;

    //dwa klocki na dole i gorze
    private int type2MinHeight;
    private int type2MaxHeight;

    public int type2Width; //nie ma rozdzielenia na top i bottom, bo szerokosc ta sama
    public int type2HeightTop;
    public int type2PositionYTop;
    public int type2HeightBottom;
    public int type2PositionYBottom;

    public GenerateObstacle(int type, GamePanel GamePanel){
        this.GamePanel = GamePanel;
        this.type = type;
        switch(this.type){
            case 1:
                type1GenerateParameters();
                break;
            case 2:
                type2GenerateParameters();
                break;
        }
    }

    private void type1GenerateParameters(){
        type1MaxHeight = GamePanel.screenHeight - 2*GamePanel.tileSize;
        type1MinHeight = 9*GamePanel.tileSize;
        type1MaxPositionY = GamePanel.screenHeight;

        type1Height = (int)Math.floor(Math.random()*(type1MaxHeight-type1MinHeight+1)+type1MinHeight);
        type1Width = 2*GamePanel.tileSize;
        type1PositionY = Random.nextInt(type1MaxPositionY);
        while(type1PositionY > GamePanel.screenHeight-type1Height){ //petla uniemozliwiajaca zrespienie czesci przeszkody pod mapa
            type1PositionY = Random.nextInt(type1MaxPositionY);
        }
    }

    private void type2GenerateParameters(){
        type2MinHeight = 5*GamePanel.tileSize;
        type2MaxHeight = GamePanel.screenHeight/2 - 2*GamePanel.tileSize;

        type2HeightTop = (int)Math.floor(Math.random()*(type2MaxHeight-type2MinHeight+1)+type2MinHeight);
        type2Width = 2*GamePanel.tileSize;
        type2PositionYTop = 0;
        type2HeightBottom = (int)Math.floor(Math.random()*(type2MaxHeight-type2MinHeight+1)+type2MinHeight);
        type2PositionYBottom = GamePanel.screenHeight - type2HeightBottom;
    }
}
