import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Main_Display_Items {
    private JFrame parentFrame;
    private Container cp;

    public static final Color PANEL_BG = Color.gray;
    public static final Color TEXT_COLOR = Color.black;
    public static final Color DARK_BG = Color.darkGray;
    // call
    private Business_Name_Gen businessNameGen;

    public Main_Display_Items(JFrame parent, Container container) {
        this.parentFrame = parent;
        this.cp = container;
        initialize_mainDisplay_Items();
    }

    public void initialize_mainDisplay_Items() {

    }

    public class Corporation extends JPanel {
        private JProgressBar progress;
        private boolean progress_fill;
        private int progress_value = 0;
        private int delay = 50;
        private Timer fillTimer;

        public Corporation() {
            setLayout(new BorderLayout(10, 10));
            setBackground(PANEL_BG);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(210, 210, 215), 1),
                    BorderFactory.createEmptyBorder(15, 15, 15, 15)
            ));

            // Business panel with card-like appearance
            JPanel businessPanel = new JPanel();
            businessPanel.setLayout(new BorderLayout(10, 10));
            businessPanel.setBackground(PANEL_BG);
            businessPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 225), 1),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            // === Top section with business info ===
            JPanel topSection = new JPanel();
            topSection.setLayout(new BoxLayout(topSection, BoxLayout.Y_AXIS));
            topSection.setBackground(PANEL_BG);
            topSection.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

            // Business name row
            JPanel nameRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            nameRow.setBackground(PANEL_BG);

            JButton buyButton = createButton("Buy");
            buyButton.setMargin(new Insets(5, 15, 5, 15));
            nameRow.add(buyButton);

            Business_Name_Gen business_name_gen = new Business_Name_Gen();
            JLabel businessNameLabel = createLabel(business_name_gen.generateName());
            nameRow.add(businessNameLabel);

            JLabel moneyPerLabel = createLabel(String.format("    | $0.00 / %s sec", delay));
            nameRow.add(moneyPerLabel);
            topSection.add(nameRow);
            businessPanel.add(topSection, BorderLayout.NORTH);

            // === Center with progress bar ===
            JPanel progressPanel = new JPanel(new BorderLayout(0, 5));
            progressPanel.setBackground(PANEL_BG);
            progressPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            progress = new JProgressBar(0, 100);
            progress.setValue(progress_value); // Example value
            progress.setStringPainted(true);
            progress.setBorder(BorderFactory.createEmptyBorder());
            progress.setPreferredSize(new Dimension(0, 25));
            progressPanel.add(progress, BorderLayout.CENTER);
            businessPanel.add(progressPanel, BorderLayout.CENTER);

            // === Right side with upgrade buttons ===
            JPanel upgradePanel = new JPanel();
            upgradePanel.setLayout(new BoxLayout(upgradePanel, BoxLayout.Y_AXIS));
            upgradePanel.setBackground(PANEL_BG);
            upgradePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

            JButton speedButton = createButton("Speed");
            speedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel speedCostLabel = createLabel("$50.00");
            speedCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            upgradePanel.add(speedButton);
            upgradePanel.add(Box.createVerticalStrut(2));
            upgradePanel.add(speedCostLabel);
            upgradePanel.add(Box.createVerticalStrut(12));

            JButton qualityButton = createButton("Quality");
            qualityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel qualityCostLabel = createLabel("$75.00");
            qualityCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            upgradePanel.add(qualityButton);
            upgradePanel.add(Box.createVerticalStrut(2));
            upgradePanel.add(qualityCostLabel);

            businessPanel.add(upgradePanel, BorderLayout.EAST);
            add(businessPanel, BorderLayout.CENTER);

            // Initialize the fill timer but don't start it yet
            fillTimer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progress_value++;
                    progress.setValue(progress_value);

                    if (progress_value >= 100) {
                        fillTimer.stop();
                        // Reset after a short delay so the user can see it's full
                        Timer resetTimer = new Timer(500, evt -> {
                            progress_value = 0;
                            progress.setValue(progress_value);
                        });
                        resetTimer.setRepeats(false);
                        resetTimer.start();
                    }
                }
            });
            fillTimer.setInitialDelay(0);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            return label;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 11));
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));

            button.addActionListener(e -> {
                if (text.equals("Buy")) {
                    // Only start the timer if it's not already running
                    if (!fillTimer.isRunning()) {
                        // Reset progress value before starting
                        progress_value = 0;
                        progress.setValue(progress_value);
                        // Start the fill timer
                        fillTimer.start();
                    }
                }

                if (text.equals("Speed")) {
                    // Only start the timer if it's not already running
                    if (!fillTimer.isRunning()) {
                        // Reset progress value before starting
                        if (delay!=0) {
                            delay-=1;
                        }
                    }
                }
            });

            return button;
        }
    }
}