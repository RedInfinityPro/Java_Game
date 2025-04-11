import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Windows {
    private JFrame parentFrame;
    private Container cp;

    public Business_Name_Generator businessNameGenerator;
    public Planet_Name_Generator planetNameGenerator;

    public Windows(JFrame parent, Container container) {
        this.parentFrame = parent;
        this.cp = container;
        initialize_Windows();
    }

    public void initialize_Windows() {

    }

    // Storage_Unit_Window
    public class Storage_Unit_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Storage_Unit_Window() {
            setTitle("Storage Unit");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(Main.DARK_BG);
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            contentPanel.add(createSection("Company's", 20));
            contentPanel.add(createSection("Company Upgrades", 20));
            contentPanel.add(createSection("Company Quality", 20));
            contentPanel.add(createSection("Rockets", 20));
            contentPanel.add(createSection("Rockets Upgrades", 20));
            contentPanel.add(createSection("Planets", 20));
            contentPanel.add(createSection("Managers", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBackground(Main.ACCENT_COLOR);
            sectionPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.DARK_BG, 2),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            JLabel label = new JLabel(title);
            label.setFont(Main.BASIC_FONT);
            label.setForeground(Main.TEXT_COLOR);
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(Main.PANEL_BG);
            buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.WHITE_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 0, 5, 0)
            ));

            String button_text = "";
            // Company's
            if (title.equals("Company's")) {
                button_text = "<html><center>Name" +
                        "<br>Planet it operates on" +
                        "<br>Sell Value" +
                        "<br>Income / sec" +
                        "<br>Manager assigned" +
                        "<br>Upgrade Cost" +
                        "<br>Quality Cost" +
                        "</center></html>";
            }
            else if (title.equals("Company Upgrades")) {
                button_text = "<html><center>Upgrade Name" +
                        "<br>Sell Value" +
                        "<br>Upkeep" +
                        "<br>Effect" +
                        "<br>Compatibility" +
                        "</center></html>";
            }
            else if (title.equals("Company Quality")) {
                button_text = "<html><center>Quality Name" +
                        "<br>Sell Value" +
                        "<br>Effect on earnings" +
                        "<br>Current quality rating" +
                        "<br>Compatibility" +
                        "<br>Company it’s affecting" +
                        "</center></html>";
            }
            // rockets
            if (title.equals("Rockets")) {
                button_text = "<html><center>Rocket Name" +
                        "<br>Sell Value" +
                        "<br>Fuel/sec" +
                        "<br>Remaining Range / Distance" +
                        "<br>Payload capacity" +
                        "<br>Upkeep" +
                        "</center></html>";
            }
            else if (title.equals("Rockets Upgrades")) {
                button_text = "<html><center>Upgrades Name" +
                        "<br>Sell Value" +
                        "<br>Upkeep" +
                        "<br>Effect" +
                        "<br>Compatibility" +
                        "</center></html>";
            }

            // planets
            if (title.equals("Planets")) {
                button_text = "<html><center>Name" +
                        "<br>Distance from HQ" +
                        "<br>Number of Companies" +
                        "<br>Fuel required to reach" +
                        "<br>Sell Value" +
                        "<br>Upkeep" +
                        "</center></html>";
            }
            // managers
            if (title.equals("Managers")) {
                button_text = "<html><center>Name" +
                        "<br>Assigned Company" +
                        "<br>Assigned Planet" +
                        "<br>Skill Boost" +
                        "<br>Salary" +
                        "</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 140));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(Main.PANEL_BG));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.PANEL_BG);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            button.setMargin(new Insets(5, 10, 5, 10));
            return button;
        }
    }

    // Rocket_Store_Window
    public class Rocket_Store_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Rocket_Store_Window() {
            setTitle("Rocket Store");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(Main.DARK_BG);
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            JPanel buyTitle_Panel = new JPanel();
            buyTitle_Panel.setLayout(new BoxLayout(buyTitle_Panel, BoxLayout.Y_AXIS));
            buyTitle_Panel.setBackground(Main.DARK_BG);
            buyTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel buy_text = new JLabel("Buy Items");
            buy_text.setForeground(Main.WHITE_COLOR);
            buy_text.setFont(Main.BOLD_FONT);
            buyTitle_Panel.add(buy_text);
            contentPanel.add(buyTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Rockets Available", 20));
            contentPanel.add(createSection("Rockets Upgrades", 20));

            JPanel sellTitle_Panel = new JPanel();
            sellTitle_Panel.setLayout(new BoxLayout(sellTitle_Panel, BoxLayout.Y_AXIS));
            sellTitle_Panel.setBackground(Main.DARK_BG);
            sellTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel sell_text = new JLabel("Sell Items");
            sell_text.setForeground(Main.WHITE_COLOR);
            sell_text.setFont(Main.BOLD_FONT);
            sellTitle_Panel.add(sell_text);
            contentPanel.add(sellTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Rockets Available To Sell", 20));
            contentPanel.add(createSection("Rockets Upgrades To Sell", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBackground(Main.ACCENT_COLOR);
            sectionPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.DARK_BG, 2),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            JLabel label = new JLabel(title);
            label.setFont(Main.BASIC_FONT);
            label.setForeground(Main.TEXT_COLOR);
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(Main.PANEL_BG);
            buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.WHITE_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 0, 5, 0)
            ));

            String button_text = "";
            // rockets
            if (title.equals("Rockets Available")) {
                button_text = "<html><center>Rocket Name: %s" +
                        "<br>Cost To Buy" +
                        "<br>Fuel/sec" +
                        "<br>Remaining Range / Distance" +
                        "<br>Payload capacity" +
                        "<br>Upkeep" +
                        "</center></html>";
            }
            else if (title.equals("Rockets Upgrades")) {
                button_text = "<html><center>Upgrades Name: %s" +
                        "<br>Cost To Buy" +
                        "<br>Upkeep" +
                        "<br>Effect" +
                        "<br>Compatibility" +
                        "</center></html>";
            }
            // rockets to sell
            if (title.equals("Rockets Available To Sell")) {
                button_text = "<html><center>Rocket Name" +
                        "<br>Sell Value" +
                        "<br>Fuel/sec" +
                        "<br>Remaining Range / Distance" +
                        "<br>Payload capacity" +
                        "<br>Upkeep" +
                        "</center></html>";
            }
            else if (title.equals("Rockets Upgrades To Sell")) {
                button_text = "<html><center>Upgrades Name" +
                        "<br>Sell Value" +
                        "<br>Upkeep" +
                        "<br>Effect" +
                        "<br>Compatibility" +
                        "</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(Main.PANEL_BG));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.PANEL_BG);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            button.setMargin(new Insets(5, 10, 5, 10));
            return button;
        }
    }

    // Planet_Store_Window
    public class Planet_Store_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Planet_Store_Window() {
            setTitle("Planet Store");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(Main.DARK_BG);
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            JPanel buyTitle_Panel = new JPanel();
            buyTitle_Panel.setLayout(new BoxLayout(buyTitle_Panel, BoxLayout.Y_AXIS));
            buyTitle_Panel.setBackground(Main.DARK_BG);
            buyTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel buy_text = new JLabel("Buy Items");
            buy_text.setForeground(Main.WHITE_COLOR);
            buy_text.setFont(new Font("Arial", Font.BOLD, 15));
            buyTitle_Panel.add(buy_text);
            contentPanel.add(buyTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Planet Available", 20));

            JPanel sellTitle_Panel = new JPanel();
            sellTitle_Panel.setLayout(new BoxLayout(sellTitle_Panel, BoxLayout.Y_AXIS));
            sellTitle_Panel.setBackground(Main.DARK_BG);
            sellTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel sell_text = new JLabel("Sell Items");
            sell_text.setForeground(Main.WHITE_COLOR);
            sell_text.setFont(Main.BOLD_FONT);
            sellTitle_Panel.add(sell_text);
            contentPanel.add(sellTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Planet Available To Sell", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBackground(Main.ACCENT_COLOR);
            sectionPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.DARK_BG, 2),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            JLabel label = new JLabel(title);
            label.setFont(Main.BASIC_FONT);
            label.setForeground(Main.TEXT_COLOR);
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(Main.PANEL_BG);
            buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.WHITE_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 0, 5, 0)
            ));

            String button_text = "";
            // Planets
            if (title.equals("Planet Available")) {
                button_text = "<html><center>Name" +
                        "<br>Distance from HQ" +
                        "<br>Number of Companies" +
                        "<br>Fuel required to reach" +
                        "<br>Buy Value" +
                        "<br>Upkeep" +
                        "</center></html>";
            }

            else if (title.equals("Planet Available To Sell")) {
                button_text = "<html><center>Name" +
                        "<br>Distance from HQ" +
                        "<br>Number of Companies" +
                        "<br>Fuel required to reach" +
                        "<br>Sell Value" +
                        "<br>Upkeep" +
                        "</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 140));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(Main.PANEL_BG));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.PANEL_BG);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            button.setMargin(new Insets(5, 10, 5, 10));
            return button;
        }
    }

    // convert money button
    public class Convet_Money_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Convet_Money_Window() {
            setTitle("Convert Money");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 500, 500);
            setResizable(false);
            // Items Panel
            // Header Panel
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            headerPanel.setBackground(Main.DARK_BG);
            headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
            // Adding labels
            headerPanel.add(createLabel("Currency Converter"));
            add(headerPanel, BorderLayout.NORTH);
            // Main Content Panel
            JPanel mainPanel = new JPanel();
            mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.setBackground(Main.ACCENT_COLOR);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(8, 5, 8, 5);
            // From Section
            JLabel fromLabel = createLabel("From:");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            mainPanel.add(fromLabel, gbc);

            JTextField convertFromField = createTextField(15);
            convertFromField.setBackground(Main.WHITE_COLOR);
            convertFromField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();  // if it's not a number, ignore the event
                    }
                }
            });
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weightx = 0.7;
            mainPanel.add(convertFromField, gbc);

            String[] convertFromOptions = {"$", "Gold", "Mega Bucks"};
            JComboBox<String> convertFrom = createComboBox(convertFromOptions);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 0.3;
            mainPanel.add(convertFrom, gbc);

            // Conversion arrow indicator
            JLabel arrowLabel = createLabel("↓");
            arrowLabel.setHorizontalAlignment(JLabel.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(15, 0, 15, 0);
            mainPanel.add(arrowLabel, gbc);

            // To Section
            JLabel toLabel = createLabel("To:");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(8, 5, 8, 5);
            mainPanel.add(toLabel, gbc);

            JTextField convertToField = createTextField(15);
            convertToField.setEditable(false);
            convertToField.setBackground(Main.WHITE_COLOR);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.weightx = 0.7;
            mainPanel.add(convertToField, gbc);

            String[] convertToOptions = {"$", "Gold", "Mega Bucks"};
            JComboBox<String> convertTo = createComboBox(convertToOptions);
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.weightx = 0.3;
            mainPanel.add(convertTo, gbc);

            add(mainPanel, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Main.TEXT_COLOR);
            label.setFont(Main.BASIC_FONT);
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JTextField createTextField(int columns) {
            JTextField field = new JTextField(columns);
            field.setFont(Main.BASIC_FONT);
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            return field;
        }

        private JComboBox<String> createComboBox(String[] items) {
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.setBackground(Main.TEXT_COLOR);
            return comboBox;
        }
    }

    // upgrades
    public class Company_Upgrade_Store_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Company_Upgrade_Store_Window() {
            setTitle("Company Upgrade Store");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(Main.DARK_BG);
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            JPanel buyTitle_Panel = new JPanel();
            buyTitle_Panel.setLayout(new BoxLayout(buyTitle_Panel, BoxLayout.Y_AXIS));
            buyTitle_Panel.setBackground(Main.DARK_BG);
            buyTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel buy_text = new JLabel("Buy Items");
            buy_text.setForeground(Main.WHITE_COLOR);
            buy_text.setFont(Main.BOLD_FONT);
            buyTitle_Panel.add(buy_text);
            contentPanel.add(buyTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Company Upgrade Available", 20));
            contentPanel.add(createSection("Company Quality Available", 20));

            JPanel sellTitle_Panel = new JPanel();
            sellTitle_Panel.setLayout(new BoxLayout(sellTitle_Panel, BoxLayout.Y_AXIS));
            sellTitle_Panel.setBackground(Main.DARK_BG);
            sellTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel sell_text = new JLabel("Sell Items");
            sell_text.setForeground(Main.WHITE_COLOR);
            sell_text.setFont(Main.BOLD_FONT);
            sellTitle_Panel.add(sell_text);
            contentPanel.add(sellTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Company Upgrade Available To Sell", 20));
            contentPanel.add(createSection("Company Quality Available To Sell", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBackground(Main.ACCENT_COLOR);
            sectionPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.DARK_BG, 2),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            JLabel label = new JLabel(title);
            label.setFont(Main.BASIC_FONT);
            label.setForeground(Main.TEXT_COLOR);
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(Main.PANEL_BG);
            buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.WHITE_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 0, 5, 0)
            ));

            String button_text = "";
            // Company
            if (title.equals("Company Upgrade Available")) {
                button_text = "<html><center>Upgrade Name" +
                        "<br>Buy Value" +
                        "<br>Upkeep" +
                        "<br>Effect" +
                        "<br>Compatibility" +
                        "</center></html>";
            }

            else if (title.equals("Company Quality Available")) {
                button_text = "<html><center>Quality Name" +
                        "<br>Buy Value" +
                        "<br>Effect on earnings" +
                        "<br>Current quality rating" +
                        "<br>Compatibility" +
                        "<br>Company it’s affecting" +
                        "</center></html>";
            }

            if (title.equals("Company Upgrade Available To Sell")) {
                button_text = "<html><center>Upgrade Name" +
                        "<br>Sell Value" +
                        "<br>Upkeep" +
                        "<br>Effect" +
                        "<br>Compatibility" +
                        "</center></html>";
            }

            else if (title.equals("Company Quality Available To Sell")) {
                button_text = "<html><center>Quality Name" +
                        "<br>Sell Value" +
                        "<br>Effect on earnings" +
                        "<br>Current quality rating" +
                        "<br>Compatibility" +
                        "<br>Company it’s affecting" +
                        "</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(Main.DARK_BG));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.PANEL_BG);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            button.setMargin(new Insets(5, 10, 5, 10));
            return button;
        }
    }

    // Managers
    public class Managers_Store_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Managers_Store_Window() {
            setTitle("Managers");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(Main.DARK_BG);
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            JPanel buyTitle_Panel = new JPanel();
            buyTitle_Panel.setLayout(new BoxLayout(buyTitle_Panel, BoxLayout.Y_AXIS));
            buyTitle_Panel.setBackground(Main.DARK_BG);
            buyTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel buy_text = new JLabel("Available");
            buy_text.setForeground(Main.WHITE_COLOR);
            buy_text.setFont(Main.BOLD_FONT);
            buyTitle_Panel.add(buy_text);
            contentPanel.add(buyTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Managers Available", 20));

            JPanel sellTitle_Panel = new JPanel();
            sellTitle_Panel.setLayout(new BoxLayout(sellTitle_Panel, BoxLayout.Y_AXIS));
            sellTitle_Panel.setBackground(Main.DARK_BG);
            sellTitle_Panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            JLabel sell_text = new JLabel("Fire");
            sell_text.setForeground(Main.WHITE_COLOR);
            sell_text.setFont(Main.BOLD_FONT);
            sellTitle_Panel.add(sell_text);
            contentPanel.add(sellTitle_Panel, BorderLayout.CENTER);

            contentPanel.add(createSection("Managers To Fire", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBackground(Main.ACCENT_COLOR);
            sectionPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.DARK_BG, 2),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            ));

            JLabel label = new JLabel(title);
            label.setFont(Main.BASIC_FONT);
            label.setForeground(Main.TEXT_COLOR);
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(Main.PANEL_BG);
            buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.WHITE_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 0, 5, 0)
            ));

            String button_text = "";
            // Company
            if (title.equals("Managers Available")) {
                button_text = "<html><center>Name" +
                        "<br>Assigned Company" +
                        "<br>Assigned Planet" +
                        "<br>Skill Boost" +
                        "<br>Salary" +
                        "</center></html>";
            }

            else if (title.equals("Managers To Fire")) {
                button_text = "<html><center>Name" +
                        "<br>Assigned Company" +
                        "<br>Assigned Planet" +
                        "<br>Skill Boost" +
                        "<br>Salary" +
                        "</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 140));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(Main.PANEL_BG));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.PANEL_BG);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            button.setMargin(new Insets(5, 10, 5, 10));
            return button;
        }
    }

    // Investors_Window
    public class Investors_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Investors_Window() {
            setTitle("Investors");
            setLayout(new BorderLayout());
            setBackground(Main.DARK_BG);
            setBounds(200, 100, 500, 500);
            setResizable(false);
            // Items Panel
            // Header Panel
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            headerPanel.setBackground(Main.DARK_BG);
            headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
            // Adding labels
            headerPanel.add(createLabel("Investors"));
            add(headerPanel, BorderLayout.NORTH);

            // Main Content Panel
            JPanel mainPanel = new JPanel();
            mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.setBackground(Main.ACCENT_COLOR);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(8, 5, 8, 5);

            // From Section
            JLabel profitLabel = createLabel("Investor Amount:");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            mainPanel.add(profitLabel, gbc);

            JTextField investor_amount_Field = createTextField(15);
            investor_amount_Field.setBackground(Main.WHITE_COLOR);
            investor_amount_Field.setEditable(false);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weightx = 0.7;
            mainPanel.add(investor_amount_Field, gbc);

            // Conversion arrow indicator
            JLabel arrowLabel = createLabel("↓");
            arrowLabel.setHorizontalAlignment(JLabel.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(15, 0, 15, 0);
            mainPanel.add(arrowLabel, gbc);

            // Conversion arrow indicator
            JLabel amountLabel = createLabel("Investor Percent:");
            amountLabel.setHorizontalAlignment(JLabel.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(8, 5, 8, 5);
            mainPanel.add(amountLabel, gbc);

            JTextField amount_Field = createTextField(15);
            amount_Field.setBackground(Main.WHITE_COLOR);
            amount_Field.setEditable(false);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.weightx = 0.7;
            mainPanel.add(amount_Field, gbc);

            add(mainPanel, BorderLayout.CENTER);

            // Restart
            JButton restartButton = new JButton("Restart Business");
            restartButton.setFont(Main.BASIC_FONT);
            restartButton.setBackground(Main.DARK_BG);
            restartButton.setForeground(Main.BUTTON_TEXT);
            restartButton.setFocusPainted(false);
            restartButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(Main.BASIC_FONT);
            closeButton.setBackground(Main.DARK_BG);
            closeButton.setForeground(Main.BUTTON_TEXT);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Main.WHITE_COLOR);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(restartButton);
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Main.TEXT_COLOR);
            label.setFont(Main.BASIC_FONT);
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JTextField createTextField(int columns) {
            JTextField field = new JTextField(columns);
            field.setFont(Main.BASIC_FONT);
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.WHITE_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            return field;
        }

        private JComboBox<String> createComboBox(String[] items) {
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.setBackground(Main.TEXT_COLOR);
            return comboBox;
        }
    }
}