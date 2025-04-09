import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class Main extends JFrame {
    private Container cp;
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    //application colors
    public static final Color DARK_BG = Color.DARK_GRAY;
    public static final Color PANEL_BG = Color.LIGHT_GRAY;
    public static final Color ACCENT_COLOR = Color.GRAY;
    public static final Color TEXT_COLOR = Color.BLACK;
    public static final Color PROGRESS_COLOR = Color.RED;
    public static final Color TRANSPARENT_COLOR = new Color(0,0,0,10);
    public static final Color WHITE_COLOR = Color.WHITE;
    // call
    private Main_Display_Panels mainDisplayPanels;

    public Main() {
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