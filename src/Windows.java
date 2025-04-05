import javax.swing.*;
import java.awt.*;

public class Windows {
    private JFrame parentFrame;
    private Container cp;
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
            setBounds(200, 100, 500, 500);
            // Items Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBackground(new Color(245, 245, 245));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            // Adding labels
            // Section titles and scroll panes
            

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
}