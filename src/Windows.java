import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Windows {
    private JFrame parentFrame;
    private Container cp;
    private Graphics g;

    public static final Color PANEL_BG = Color.gray;
    public static final Color TEXT_COLOR = Color.black;
    public static final Color DARK_BG = Color.darkGray;

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
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(new Color(245, 245, 245));
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
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
            sectionPanel.setBackground(new Color(245, 245, 245));

            JLabel label = new JLabel(title);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(new Color(33, 37, 41));
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            String button_text = "";
            // Company's
            if (title.equals("Company's")) {
                button_text = "<html><center>Name<br>Planet Associated With<br>Sell Cost<br>Value Per Second<br>Managers</center></html>";
            }
            else if (title.equals("Company Upgrades")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }
            else if (title.equals("Company Quality")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }
            // rockets
            if (title.equals("Rockets")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Fuel Per Second<br>Distance<br>Up Keep Cost</center></html>";
            }
            else if (title.equals("Rockets Upgrades")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }
            // planets
            if (title.equals("Planets")) {
                button_text = "<html><center>Name<br>Company Name<br>Sell Cost<br>Distance<br>Up Keep Cost<br>Company Available</center></html>";
            }
            // managers
            if (title.equals("Managers")) {
                button_text = "<html><center>Name<br>Planet Associated With<br>Company Associated With</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(new Color(51, 51, 51));
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
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(new Color(245, 245, 245));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            contentPanel.add(createSection("Rockets Available", 20));
            contentPanel.add(createSection("Rockets Upgrades", 20));

            contentPanel.add(createSection("Rockets Available To Sell", 20));
            contentPanel.add(createSection("Rockets Upgrades To Sell", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            sectionPanel.setBackground(new Color(245, 245, 245));

            JLabel label = new JLabel(title);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(new Color(33, 37, 41));
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            String button_text = "";
            // rockets
            if (title.equals("Rockets Available")) {
                button_text = "<html><center>Name<br>Cost To Buy<br>Fuel Per Second<br>Distance<br>Up Keep Cost</center></html>";
            }
            else if (title.equals("Rockets Upgrades")) {
                button_text = "<html><center>Name<br>Cost To Buy<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }
            // rockets to sell
            if (title.equals("Rockets Available To Sell")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Fuel Per Second<br>Distance<br>Up Keep Cost</center></html>";
            }
            else if (title.equals("Rockets Upgrades To Sell")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(new Color(51, 51, 51));
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
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 500, 500);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(new Color(245, 245, 245));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            contentPanel.add(createSection("Planet Available", 20));
            contentPanel.add(createSection("Planet Available To Sell", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            sectionPanel.setBackground(new Color(245, 245, 245));

            JLabel label = new JLabel(title);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(new Color(33, 37, 41));
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            String button_text = "";
            // Planets
            if (title.equals("Planet Available")) {
                button_text = "<html><center>Name<br>Company Name<br>Cost To Buy<br>Distance<br>Up Keep Cost<br>Company Available</center></html>";
            }

            else if (title.equals("Planet Available To Sell")) {
                button_text = "<html><center>Name<br>Company Name<br>Sell Cost<br>Distance<br>Up Keep Cost<br>Company Available</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(new Color(51, 51, 51));
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
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 500, 400);
            setResizable(false);
            // Items Panel
            // Header Panel
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
            // Adding labels
            headerPanel.add(createLabel("Currency Converter"));
            add(headerPanel, BorderLayout.NORTH);

            // Main Content Panel
            JPanel mainPanel = new JPanel();
            mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
            mainPanel.setLayout(new GridBagLayout());

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
            convertToField.setBackground(new Color(245, 245, 245));
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
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JTextField createTextField(int columns) {
            JTextField field = new JTextField(columns);
            field.setFont(new Font("Arial", Font.PLAIN, 11));
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            return field;
        }

        private JComboBox<String> createComboBox(String[] items) {
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.setBackground(Color.WHITE);
            return comboBox;
        }
    }

    // upgrades
    public class Company_Upgrade_Store_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Company_Upgrade_Store_Window() {
            setTitle("Company Upgrade Store");
            setLayout(new BorderLayout());
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 700, 700);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(new Color(245, 245, 245));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            contentPanel.add(createSection("Company Upgrade Available", 20));
            contentPanel.add(createSection("Company Quality Available", 20));

            contentPanel.add(createSection("Company Upgrade Available To Sell", 20));
            contentPanel.add(createSection("Company Quality Available To Sell", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            sectionPanel.setBackground(new Color(245, 245, 245));

            JLabel label = new JLabel(title);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(new Color(33, 37, 41));
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            String button_text = "";
            // Company
            if (title.equals("Company Upgrade Available")) {
                button_text = "<html><center>Name<br>Cost To Buy<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }

            else if (title.equals("Company Quality Available")) {
                button_text = "<html><center>Name<br>Cost TO buy<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }

            if (title.equals("Company Upgrade Available To Sell")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }

            else if (title.equals("Company Quality Available To Sell")) {
                button_text = "<html><center>Name<br>Sell Cost<br>Up Keep Cost<br>Details<br>Compatible With</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(new Color(51, 51, 51));
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
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 500, 500);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(new Color(245, 245, 245));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            contentPanel.add(createSection("Managers Available", 20));
            contentPanel.add(createSection("Managers To Fire", 20));

            JScrollPane mainScrollPane = new JScrollPane(contentPanel);
            mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(mainScrollPane, BorderLayout.CENTER);
            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JPanel createSection(String title, int buttonCount) {
            JPanel sectionPanel = new JPanel();
            sectionPanel.setLayout(new BorderLayout());
            sectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            sectionPanel.setBackground(new Color(245, 245, 245));

            JLabel label = new JLabel(title);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(new Color(33, 37, 41));
            sectionPanel.add(label, BorderLayout.NORTH);

            JScrollPane scrollPane = createScrollPane(buttonCount, title);
            sectionPanel.add(scrollPane, BorderLayout.CENTER);

            return sectionPanel;
        }

        private JScrollPane createScrollPane(int buttonCount, String title) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            String button_text = "";
            // Company
            if (title.equals("Managers Available")) {
                button_text = "<html><center>Name<br>Planet Associated With<br>Company Associated With</center></html>";
            }

            else if (title.equals("Managers To Fire")) {
                button_text = "<html><center>Name<br>Planet Associated With<br>Company Associated With</center></html>";
            }

            for (int i = 0; i < buttonCount; i++) {
                buttonPanel.add(createButton(button_text));
            }

            JScrollPane scrollPane = new JScrollPane(buttonPanel);
            scrollPane.setPreferredSize(new Dimension(600, 125));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

            return scrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(new Color(51, 51, 51));
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
            setBackground(Color.DARK_GRAY);
            setBounds(200, 100, 500, 400);
            setResizable(false);
            // Items Panel
            // Header Panel
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
            // Adding labels
            headerPanel.add(createLabel("Investors"));
            add(headerPanel, BorderLayout.NORTH);

            // Main Content Panel
            JPanel mainPanel = new JPanel();
            mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
            mainPanel.setLayout(new GridBagLayout());

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
            investor_amount_Field.setEditable(false);
            investor_amount_Field.setBackground(new Color(245, 245, 245));
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
            amount_Field.setEditable(false);
            amount_Field.setBackground(new Color(245, 245, 245));
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.weightx = 0.7;
            mainPanel.add(amount_Field, gbc);

            add(mainPanel, BorderLayout.CENTER);

            // Restart
            JButton restartButton = new JButton("Restart Business");
            restartButton.setFont(new Font("Arial", Font.BOLD, 14));
            restartButton.setBackground(Color.DARK_GRAY);
            restartButton.setForeground(Color.GRAY);
            restartButton.setFocusPainted(false);
            restartButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(Color.DARK_GRAY);
            closeButton.setForeground(Color.GRAY);
            closeButton.setFocusPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            closeButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(245, 245, 245));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            buttonPanel.add(restartButton);
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JTextField createTextField(int columns) {
            JTextField field = new JTextField(columns);
            field.setFont(new Font("Arial", Font.PLAIN, 11));
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            return field;
        }

        private JComboBox<String> createComboBox(String[] items) {
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.setBackground(Color.WHITE);
            return comboBox;
        }
    }
}