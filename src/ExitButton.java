import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitButton extends JButton{
    ExitButton(int xShift) {
        ImageIcon playImg = new ImageIcon("src/play.png");
        this.setIcon(playImg);
        int shift = (int) (xShift - 0.5 * playImg.getIconWidth());
        this.setBounds(shift, playImg.getIconHeight()+140, playImg.getIconWidth(), playImg.getIconHeight());
        
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
}