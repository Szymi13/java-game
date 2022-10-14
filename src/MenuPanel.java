import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements Runnable{

    private final int screenHeight = new GamePanel().setScreenHeight();
    private final int screenWidth = new GamePanel().setScreenWidth();

    public MenuPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // performance boost
        this.setFocusable(true);
    }

    public int setScreenWidth() {
        return screenWidth;
    }

    public int setScreenHeight() {
        return screenHeight;
    }

    @Override
    public void run() {}
    
}
