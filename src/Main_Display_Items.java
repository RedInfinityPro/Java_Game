import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

public class Main_Display_Items {
    private JFrame parentFrame;
    private Container cp;
    public static Random rand_items = new Random();
    // call
    public Elements elements;
    public Business_Name_Generator businessNameGenerator;
    public Main_Display_Panels mainDisplayPanels;

    public Main_Display_Items(JFrame parent, Container container, Main_Display_Panels mainDisplayPanels) {
        this.parentFrame = parent;
        this.cp = container;
        this.elements = new Elements();
        this.businessNameGenerator = new Business_Name_Generator();
        this.mainDisplayPanels = mainDisplayPanels; // store the reference
        initialize_mainDisplay_Items();
    }

    public void initialize_mainDisplay_Items() {

    }

    public class Corporation extends JPanel {
        private JProgressBar progress;
        private JLabel moneyPerLabel, speedCostLabel, qualityCostLabel;
        private int progress_value = 0;
        // upgrades
        private double scalingFactor = 100;
        private float delayInSeconds = rand_items.nextFloat(0, 9);
        private double current_money = nextLogarithmicDouble(0.01, 999.99);
        private double speed_cost = nextLogarithmicDouble(0.01, 999.99);
        private double quality_cost = nextLogarithmicDouble(0.01, 999.99);

        private double quality_percent = rand_items.nextInt(100);
        private double speed_percent = rand_items.nextInt(100);
        private double delay_percent = rand_items.nextInt(100);
        private double money_percent = rand_items.nextInt(100);

        private static final DecimalFormat decimalFormat_time = new DecimalFormat("###.##");
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

            Business_Name_Generator business_name_gen = new Business_Name_Generator();
            JLabel businessNameLabel = createLabel(business_name_gen.generate());
            nameRow.add(businessNameLabel);

            // Pre-format these strings once
            Elements elements = new Elements();
            String moneyStr = elements.formatNumber(current_money);
            String timeStr = decimalFormat_time.format(delayInSeconds);
            moneyPerLabel = createLabel(String.format("    | $%s / %s sec", moneyStr, timeStr));
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
            progress.setValue(progress_value);
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
            speedCostLabel = createLabel("$" + elements.formatNumber(speed_cost));
            speedCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            upgradePanel.add(speedButton);
            upgradePanel.add(Box.createVerticalStrut(2));
            upgradePanel.add(speedCostLabel);
            upgradePanel.add(Box.createVerticalStrut(12));

            JButton qualityButton = createButton("Quality");
            qualityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            qualityCostLabel = createLabel("$" + elements.formatNumber(quality_cost));
            qualityCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            upgradePanel.add(qualityButton);
            upgradePanel.add(Box.createVerticalStrut(2));
            upgradePanel.add(qualityCostLabel);

            businessPanel.add(upgradePanel, BorderLayout.EAST);
            add(businessPanel, BorderLayout.CENTER);

            // Use an optimized ActionListener
            ActionListener progressAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update progress bar directly rather than via a variable
                    progress.setValue(++progress_value);

                    if (progress_value >= 100) {
                        fillTimer.stop();

                        // Update money immediately
                        mainDisplayPanels.money += current_money;
                        mainDisplayPanels.Money_Label.setText("Money: $" + elements.formatNumber(mainDisplayPanels.money));

                        // Reset after a brief delay
                        Timer resetTimer = new Timer(500, evt -> {
                            progress_value = 0;
                            progress.setValue(0);
                        });
                        resetTimer.setRepeats(false);
                        resetTimer.start();
                    }
                }
            };

            // Initialize the fill timer
            int delayInMilliseconds = (int) (delayInSeconds * 1000);
            fillTimer = new Timer(delayInMilliseconds, progressAction);
            fillTimer.setInitialDelay(0);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Main.TEXT_COLOR);
            label.setFont(Main.BASIC_FONT);
            return label;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));

            button.addActionListener(e -> {
                if (text.equals("Buy")) {
                    // Only start the timer if it's not already running
                    if (!fillTimer.isRunning()) {
                        progress_value = 0;
                        progress.setValue(0);
                        fillTimer.start();
                    }
                }
                else if (text.equals("Upgrade") && mainDisplayPanels.money >= speed_cost) {
                    if (delayInSeconds > 0f) {
                        // Update money and display immediately
                        mainDisplayPanels.money -= speed_cost;
                        mainDisplayPanels.Money_Label.setText("Money: $" + elements.formatNumber(mainDisplayPanels.money));

                        // Apply upgrades
                        delayInSeconds *= (1 - delay_percent / 100.0f);
                        speed_cost *= (1 + speed_percent / 100.0f);

                        // Update timer delay
                        fillTimer.setDelay((int) (delayInSeconds * 1000));

                        // Update labels with the new format values
                        updateLabels();
                    }
                }
                else if (text.equals("Quality") && mainDisplayPanels.money >= quality_cost) {
                    // Update money and display immediately
                    mainDisplayPanels.money -= quality_cost;
                    mainDisplayPanels.Money_Label.setText("Money: $" + elements.formatNumber(mainDisplayPanels.money));

                    // Apply upgrades
                    current_money *= (1 + money_percent / 100.0f);
                    quality_cost *= (1 + quality_percent / 100.0f);

                    // Update labels with the new format values
                    updateLabels();
                }
            });

            return button;
        }

        // Centralized method for updating labels
        private void updateLabels() {
            Elements elements = new Elements();
            // Pre-format strings for better performance
            String moneyStr = elements.formatNumber(current_money);
            String timeStr = decimalFormat_time.format(delayInSeconds);
            String speedCostStr = elements.formatNumber(speed_cost);
            String qualityCostStr = elements.formatNumber(quality_cost);

            // Update all labels at once
            moneyPerLabel.setText("    | $" + moneyStr + " / " + timeStr + " sec");
            speedCostLabel.setText("$" + speedCostStr);
            qualityCostLabel.setText("$" + qualityCostStr);
        }
    }

    public double nextLogarithmicDouble(Double minValue, Double maxValue) {
        // Convert range to log scale
        double logMin = Math.log(minValue);
        double logMax = Math.log(maxValue);

        // Generate a random value in the log scale
        double logValue = logMin + (rand_items.nextDouble() * (logMax - logMin));

        // Convert back from log scale to original scale
        return Math.exp(logValue);
    }
}