import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    private Container cp;
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    //application colors
    public static final Color DARK_BG = Color.darkGray;
    public static final Color ACCENT_COLOR = Color.WHITE;
    public static final Color TEXT_COLOR = Color.black;
    // call
    private Main_Display_Panels mainDisplayPanels;

    public Main() {
        // Setup frame
        setTitle("Main");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Setup container
        cp = getContentPane();
        cp.setLayout(new BorderLayout(10, 10));
        cp.setBackground(DARK_BG);
        ((JPanel)cp).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Create main panel with BorderLayout
        Main_Display_Panels mainDisplayPanels = new Main_Display_Panels(this, cp);
        // Visible
        setVisible(true);
    }

    // run
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(Main::new);
    }
}