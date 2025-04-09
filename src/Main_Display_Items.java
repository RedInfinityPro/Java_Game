import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.awt.Color;

public class Main_Display_Items {
    private JFrame parentFrame;
    private Container cp;
    private final Random rand;
    // call
    private Business_Name_Gen businessNameGen;

    public Main_Display_Items(JFrame parent, Container container) {
        this.parentFrame = parent;
        this.cp = container;
        this.rand = new Random();
        initialize_mainDisplay_Items();
    }

    public void initialize_mainDisplay_Items() {

    }

    public class Corporation extends JPanel {
        private JProgressBar progress;
        private JLabel moneyPerLabel, speedCostLabel, qualityCostLabel;
        private int progress_value = 0;
        // upgrades
        private float delayInSeconds = rand.nextFloat(0, 99);
        private float current_money = rand.nextFloat(0, 999);
        private float speed_cost = rand.nextFloat(0, 999);
        private float quality_cost = rand.nextFloat(0, 999);

        private float quality_percent = rand.nextInt(100);
        private float speed_percent = rand.nextInt(100);
        private float delay_percent = rand.nextInt(100);
        private float money_percent = rand.nextInt(100);

        private static final DecimalFormat decimalFormat_time = new DecimalFormat("###.##");
        private static final DecimalFormat decimalFormat_money = new DecimalFormat("0.00");
        private Timer fillTimer;


        public Corporation() {
            setLayout(new BorderLayout(10, 10));
            setBackground(Main.ACCENT_COLOR);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.DARK_BG, 2),
                    BorderFactory.createEmptyBorder(15, 15, 15, 15)
            ));

            // Business panel with card-like appearance
            JPanel businessPanel = new JPanel();
            businessPanel.setLayout(new BorderLayout(10, 10));
            businessPanel.setBackground(Main.PANEL_BG);
            businessPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            // === Top section with business info ===
            JPanel topSection = new JPanel();
            topSection.setLayout(new BoxLayout(topSection, BoxLayout.Y_AXIS));
            topSection.setBackground(Main.PANEL_BG);
            topSection.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

            // Business name row
            JPanel nameRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            nameRow.setBackground(Main.PANEL_BG);

            JButton buyButton = createButton("Buy");
            buyButton.setMargin(new Insets(5, 15, 5, 15));
            nameRow.add(buyButton);

            Business_Name_Gen business_name_gen = new Business_Name_Gen();
            JLabel businessNameLabel = createLabel(business_name_gen.generateName());
            nameRow.add(businessNameLabel);

            int delayInMilliseconds = (int) (delayInSeconds * 1000);
            moneyPerLabel = createLabel(String.format("    | $%s / %s sec", decimalFormat_money.format(current_money), decimalFormat_time.format(delayInSeconds)));
            nameRow.add(moneyPerLabel);
            topSection.add(nameRow);
            businessPanel.add(topSection, BorderLayout.NORTH);

            // === Center with progress bar ===
            JPanel progressPanel = new JPanel(new BorderLayout(0, 5));
            progressPanel.setBackground(Main.PANEL_BG);
            progressPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            progress = new JProgressBar(0, 100);
            progress.setBackground(Main.DARK_BG);
            progress.setForeground(Main.PROGRESS_COLOR);
            progress.setValue(progress_value); // Example value
            progress.setStringPainted(true);
            progress.setBorder(BorderFactory.createEmptyBorder());
            progress.setPreferredSize(new Dimension(0, 25));
            progressPanel.add(progress, BorderLayout.CENTER);
            businessPanel.add(progressPanel, BorderLayout.CENTER);

            // === Right side with upgrade buttons ===
            JPanel upgradePanel = new JPanel();
            upgradePanel.setLayout(new BoxLayout(upgradePanel, BoxLayout.Y_AXIS));
            upgradePanel.setBackground(Main.PANEL_BG);
            upgradePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

            JButton speedButton = createButton("Upgrade");
            speedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            speedCostLabel = createLabel(String.format("$%s", decimalFormat_money.format(speed_cost)));
            speedCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            upgradePanel.add(speedButton);
            upgradePanel.add(Box.createVerticalStrut(2));
            upgradePanel.add(speedCostLabel);
            upgradePanel.add(Box.createVerticalStrut(12));

            JButton qualityButton = createButton("Quality");
            qualityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            qualityCostLabel = createLabel(String.format("$%s", decimalFormat_money.format(quality_cost)));
            qualityCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            upgradePanel.add(qualityButton);
            upgradePanel.add(Box.createVerticalStrut(2));
            upgradePanel.add(qualityCostLabel);

            businessPanel.add(upgradePanel, BorderLayout.EAST);
            add(businessPanel, BorderLayout.CENTER);

            // Initialize the fill timer but don't start it yet
            fillTimer = new Timer(delayInMilliseconds, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progress_value++;
                    progress.setValue(progress_value);

                    if (progress_value >= 100) {
                        fillTimer.stop();
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
            label.setForeground(Main.TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 11));
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

                if (text.equals("Upgrade")) {
                    if (delayInSeconds > 0f) { // Avoid going too fast or hitting zero
                        delayInSeconds *= (1 - delay_percent / 100.0f);
                        speed_cost *= (1 + speed_percent / 100.0f);
                        // Restart the timer with new delay
                        fillTimer.setDelay((int) (delayInSeconds * 1000));
                        // update labels
                        moneyPerLabel.setText(String.format("    | $%s / %s sec",
                                decimalFormat_money.format(current_money),
                                decimalFormat_time.format(delayInSeconds)));

                        speedCostLabel.setText(String.format("$%s", decimalFormat_money.format(speed_cost)));
                        qualityCostLabel.setText(String.format("$%s", decimalFormat_money.format(quality_cost)));
                    }
                }

                if (text.equals("Quality")) {
                    current_money *= (1 + money_percent / 100.0f);
                    quality_cost *= (1 + quality_percent / 100.0f);
                    // update labels
                    moneyPerLabel.setText(String.format("    | $%s / %s sec",
                            decimalFormat_money.format(current_money),
                            decimalFormat_time.format(delayInSeconds)));

                    speedCostLabel.setText(String.format("$%s", decimalFormat_money.format(speed_cost)));
                    qualityCostLabel.setText(String.format("$%s", decimalFormat_money.format(quality_cost)));
                }
            });

            return button;
        }
    }
}