import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    public boolean aPressed, dPressed, spacePressed, enterPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyButton = e.getKeyCode();
        
        if(keyButton == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyButton = e.getKeyCode();
        
        if(keyButton == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }
    
}
