import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Display_Panels {
    private JFrame parentFrame;
    private Container cp;

    public static final Color PANEL_BG = Color.gray;
    public static final Color TEXT_COLOR = Color.black;
    public static final Color DARK_BG = Color.darkGray;

    private static final String play_time = "Time";
    private static final String planet_name = "Earth";
    private static final String unique_id = "123";
    // call
    private Business_Name_Gen businessNameGen;

    public Main_Display_Panels(JFrame parent, Container container) {
        this.parentFrame = parent;
        this.cp = container;
        initialize_mainDisplay();
    }

    public void initialize_mainDisplay() {
        // Create main panel with BorderLayout
        JPanel main_panel = new JPanel(new BorderLayout());
        main_panel.setBackground(DARK_BG);
        cp.add(main_panel, BorderLayout.CENTER);

        // Add top panel to NORTH
        JPanel top_panel = new Top_Panel();
        main_panel.add(top_panel, BorderLayout.NORTH);

        // Add search panel SOUTH
        JPanel search_panel = new Search_Panel();
        main_panel.add(search_panel, BorderLayout.SOUTH);

        // Create a left panel for corporation details
        JPanel left_panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
        left_panel.setBackground(DARK_BG);

        // Add corporation details panel to left panel
        Corporation_Details_Panel corporation_details_panel = new Corporation_Details_Panel();
        left_panel.add(corporation_details_panel);

        // Add left panel to WEST
        main_panel.add(left_panel, BorderLayout.WEST);
    }

    public class Top_Panel extends JPanel {
        public Top_Panel() {
            setLayout(new BorderLayout());
            setBackground(PANEL_BG);
            setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

            JPanel business_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            business_panel.setBackground(Main_Display_Panels.PANEL_BG);

            business_panel.add(createLabel("Business Name:"));
            JTextField business_name_area = createTextField(20);
            business_panel.add(business_name_area);

            JButton randomize_name_button = createButton("Randomize Name");
            business_panel.add(randomize_name_button);
            randomize_name_button.addActionListener(e -> {
                Business_Name_Gen business_name_gen = new Business_Name_Gen();
                business_name_area.setText(business_name_gen.generateName()); // Example action
            });

            JPanel details_panel = new JPanel(new GridLayout(0, 1));
            details_panel.setBackground(Main_Display_Panels.PANEL_BG);
            details_panel.add(createLabel(String.format("Play Time: %s", play_time)));
            details_panel.add(createLabel(String.format("Planet Name: %s", planet_name)));
            details_panel.add(createLabel(String.format("Unique ID: %s", unique_id)));

            // buttons_panel
            JPanel buttons_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttons_panel.setBackground(Main_Display_Panels.PANEL_BG);

            JButton storage_unit = createButton("Storage Unit");
            buttons_panel.add(storage_unit);
            storage_unit.addActionListener(e -> {
                Storage_Unit_Window storage_unit_window = new Storage_Unit_Window();
                JDialog storage_unit_window_show = new JDialog();
                storage_unit_window_show.setLocationRelativeTo(null);
            });

            JButton rocket_store = createButton("Rocket Store");
            buttons_panel.add(rocket_store);

            JButton planet_store = createButton("Planet Store");
            buttons_panel.add(planet_store);

            add(business_panel, BorderLayout.WEST);
            add(details_panel, BorderLayout.EAST);
            add(buttons_panel, BorderLayout.SOUTH);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
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

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 11));
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }

    public class Corporation_Details_Panel extends JPanel {
        public Corporation_Details_Panel() {
            setLayout(new BorderLayout());
            setBackground(PANEL_BG);
            setPreferredSize(new Dimension(220, 120));

            JPanel corporation_details_panel = new JPanel(new GridLayout(0, 1));
            corporation_details_panel.setBackground(Main_Display_Panels.PANEL_BG);

            corporation_details_panel.add(createLabel("Money: $0.00"));
            corporation_details_panel.add(createLabel("Gold: $0.00"));
            corporation_details_panel.add(createLabel("Mega Bucks: $0.00"));

            JButton convert_button = createButton("Convert Money");
            corporation_details_panel.add(convert_button);

            add(corporation_details_panel, BorderLayout.CENTER);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 11));
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }

    public class Search_Panel extends JPanel {
        public Search_Panel() {
            setLayout(new BorderLayout());
            setBackground(PANEL_BG);
            setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
            // search_panel
            JPanel search_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            search_panel.setBackground(Main_Display_Panels.PANEL_BG);

            JTextField search_area = createTextField(20);
            search_panel.add(search_area);

            // buttons_panel
            JPanel buttons_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttons_panel.setBackground(Main_Display_Panels.PANEL_BG);

            JButton upgrade_button = createButton("Upgrades");
            buttons_panel.add(upgrade_button);

            JButton manager_button = createButton("Managers");
            buttons_panel.add(manager_button);

            JButton investors_button = createButton("Investors");
            buttons_panel.add(investors_button);

            add(search_panel, BorderLayout.CENTER);
            add(buttons_panel, BorderLayout.SOUTH);
        }

        private JTextField createTextField(int columns) {
            JTextField field = new JTextField(columns);
            field.setFont(new Font("Arial", Font.PLAIN, 11));
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            return field;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 11));
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }

    // windows
    public class Storage_Unit_Window extends JDialog {
        public static final JFrame jFrame = new JFrame();

        public Storage_Unit_Window() {
            setTitle("Storage Unit");
            setLayout(new BorderLayout());
            setBackground(Color.DARK_GRAY);
            setBounds(200, 200, 600, 600);
            // Items Panel
            JPanel storage_unit_title_panel = new JPanel();
            storage_unit_title_panel.setLayout(new BoxLayout(storage_unit_title_panel, BoxLayout.Y_AXIS));
            storage_unit_title_panel.setBackground(Color.LIGHT_GRAY);
            // Adding labels
            storage_unit_title_panel.add(createLabel("Company's"));
            storage_unit_title_panel.add(createScrollPane(60));
            storage_unit_title_panel.add(createLabel("Company Upgrades"));
            storage_unit_title_panel.add(createScrollPane(60));
            storage_unit_title_panel.add(createLabel("Company Quality"));
            storage_unit_title_panel.add(createScrollPane(60));
            storage_unit_title_panel.add(createLabel("Rockets"));
            storage_unit_title_panel.add(createScrollPane(60));
            storage_unit_title_panel.add(createLabel("Rockets Upgrades"));
            storage_unit_title_panel.add(createScrollPane(60));
            storage_unit_title_panel.add(createLabel("Planets"));
            storage_unit_title_panel.add(createScrollPane(60));
            storage_unit_title_panel.add(createLabel("Managers"));
            storage_unit_title_panel.add(createScrollPane(60));
            add(storage_unit_title_panel, BorderLayout.CENTER);

            // Close button
            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(closeButton, BorderLayout.SOUTH);
            setVisible(true);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Color.BLACK);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JScrollPane createScrollPane(int button_amount) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.LIGHT_GRAY);
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

            // Add buttons to the horizontal panel
            for (int i = 0; i < button_amount; i++) {
                JButton testButton = createButton("Test " + (i+1));
                buttonPanel.add(testButton);
            }

            // Add button panel to a horizontal scroll pane
            JScrollPane horizontalScrollPane = new JScrollPane(buttonPanel);
            horizontalScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            horizontalScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            // Add the horizontal scroll pane to the bottom of the dialog
            add(horizontalScrollPane, BorderLayout.NORTH);
            return horizontalScrollPane;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 11));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }
}