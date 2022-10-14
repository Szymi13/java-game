import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel  extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 2;
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    final int tileSize = originalTileSize * scale;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int fps = 60;

    private int type;
    private int typeMin = 1;
    private int typeMax = 2;

    KeyboardInput Button = new KeyboardInput();
    Character Player = new Character(this,Button);

    // ----------------- Initial Obstacles -------------------//
    GenerateObstacle GeneratedObstacle1 = new GenerateObstacle(1, this);
    DrawObstacle Przeszkoda1 = new DrawObstacle(this, (screenWidth), GeneratedObstacle1);
    CollisionDetection Collision1 = new CollisionDetection(Przeszkoda1, Player, GeneratedObstacle1);
    
    GenerateObstacle GeneratedObstacle2 = new GenerateObstacle(1, this);
    DrawObstacle Przeszkoda2 = new DrawObstacle(this, (screenWidth + screenWidth/2), GeneratedObstacle2);
    CollisionDetection Collision2 = new CollisionDetection(Przeszkoda2, Player, GeneratedObstacle2);
    //--------------------------------------------------------//

    BufferedImage bckg;

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //performance boost
        this.addKeyListener(Button);
        this.setFocusable(true);

        //tu dodaje tlo
        try {
            bckg = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            System.out.println("ktos usunal tlo:(");
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double interval = 1000000000/fps; // 1s/30 (period of one frame)
        double nextDrawTime = System.nanoTime() + interval;

        while(gameThread != null) {            
            update();
            repaint();      
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/10000000; //sleep() takes millis as an argument
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                if(Collision1.checkCollision() == true || Collision2.checkCollision() == true){
                    EventQueue.invokeLater(() -> {
                        new MenuFrame();
                    });
                    return;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime = nextDrawTime + interval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }      
        }
    }

    private void generateObstacle(){
        if( Przeszkoda1.obstacleX < -2*tileSize){
            this.type = (int)Math.floor(Math.random()*(typeMax-typeMin+1)+typeMin);
            GeneratedObstacle1 = new GenerateObstacle(this.type, this);
            Przeszkoda1 = new DrawObstacle(this, screenWidth, GeneratedObstacle1);
            Collision1 = new CollisionDetection(Przeszkoda1, Player, GeneratedObstacle1);
        }
        if (Przeszkoda2.obstacleX < -2*tileSize) {
            this.type = (int)Math.floor(Math.random()*(typeMax-typeMin+1)+typeMin);
            GeneratedObstacle2 = new GenerateObstacle(this.type, this);
            Przeszkoda2 = new DrawObstacle(this, screenWidth, GeneratedObstacle2);
            Collision2 = new CollisionDetection(Przeszkoda2, Player,GeneratedObstacle2);
        }
    }

    public void update() {
        generateObstacle();
        Player.update();
        Przeszkoda1.update();
        Przeszkoda2.update();
    }

    public int setScreenWidth(){
        return screenWidth;
    }
    public int setScreenHeight(){
        return screenHeight;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bckg, 0, 0, this);
        Player.draw(g);
        Przeszkoda1.draw(g);
        Przeszkoda2.draw(g);
        g.dispose(); //koniec rysowania
    }
}
