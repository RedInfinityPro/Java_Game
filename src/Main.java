import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class Main extends JFrame {
    private Container cp;
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    //application colors
    public static final Color DARK_BG = new Color(34, 34, 34);
    public static final Color PANEL_BG = new Color(60, 63, 65);
    public static final Color ACCENT_COLOR = new Color(20, 20, 20);
    public static final Color TEXT_COLOR = new Color(192,192,192);
    public static final Color PROGRESS_COLOR = new Color(220, 20, 60); // crimson
    public static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 10);
    public static final Color WHITE_COLOR = new Color(255, 255, 255);
    public static final Color BUTTON_TEXT = new Color(0, 0, 0);
    //application fonts
    public static final Font BASIC_FONT = new Font("Arial", Font.PLAIN, 11);
    public static final Font BOLD_FONT = new Font("Arial", Font.BOLD, 15);
    // call
    private Main_Display_Panels mainDisplayPanels;
    private Main_Display_Items mainDisplayItems;

    public Main() {
        setTitle("Main");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Setup container
        cp = getContentPane();
        cp.setLayout(new BorderLayout(10, 10));
        cp.setBackground(DARK_BG);
        ((JComponent) cp).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // Create main panel with BorderLayout
        Main_Display_Panels mainDisplayPanels = new Main_Display_Panels(this, cp, mainDisplayItems);
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