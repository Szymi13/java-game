import javax.swing.JFrame;

public class MenuFrame extends JFrame {

    public MenuFrame() {
        JFrame window = new JFrame();
        this.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game");

        //tworzenie menu
        MenuPanel menu = new MenuPanel();
        menu.setLayout(null);
        
        PlayButton play = new PlayButton(menu.setScreenWidth()/2);
        ExitButton exit = new ExitButton(menu.setScreenWidth() / 2);

        menu.add(play);
        menu.add(exit);

        window.add(menu);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}