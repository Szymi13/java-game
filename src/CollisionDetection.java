public class CollisionDetection {
    GamePanel GamePanel;
    DrawObstacle Obstacle;
    Character Player;
    GenerateObstacle GeneratedObstacle;

    int i = 1;

    public CollisionDetection(DrawObstacle Obstacle, Character Player, GenerateObstacle GeneratedObstacle) {
        this.Obstacle = Obstacle;
        this.Player = Player;
        this.GeneratedObstacle = GeneratedObstacle;
    }

    public boolean checkCollision(){
        switch(GeneratedObstacle.type){
            case 1:
                if((Player.characterX + Player.characterWidth >= Obstacle.obstacleX)
                && (Player.characterX <= (Obstacle.obstacleX + Obstacle.obstacleWidth))
                && ((Player.characterY + Player.characterHeight) >= Obstacle.type1ObstacleY)
                && (Player.characterY <= (Obstacle.type1ObstacleY + Obstacle.type1ObstacleHeight))){
                    if(i <= 1){
                        return true;
                    }
                    i++;
                } 
                break;
            case 2:
                if((Player.characterX + Player.characterWidth >= Obstacle.obstacleX)
                &&(Player.characterX <= Obstacle.obstacleX + Obstacle.obstacleWidth)
                &&(!((Player.characterY + Player.characterHeight >= Obstacle.type2ObstacleYTop + Obstacle.type2ObstacleHeightTop)
                &&(Player.characterY <= Obstacle.type2ObstacleYBottom)))){
                    if(i <= 1){
                        return true;
                    }
                    i++;
                }
                break;
        }
        return false;
    }
}
