import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PlayButton extends JButton{
    PlayButton(int xShift){
        ImageIcon playImg = new ImageIcon("src/play.png");
        this.setIcon(playImg);
        int shift = (int) (xShift-0.5*playImg.getIconWidth());
        this.setBounds(shift, 70, playImg.getIconWidth(), playImg.getIconHeight());

        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EventQueue.invokeLater(()->{
                    new GameFrame();
                });
            }
        });
    }
}