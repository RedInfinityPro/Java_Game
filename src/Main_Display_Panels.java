import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.UUID;

public class Main_Display_Panels {
    private JFrame parentFrame;
    private Container cp;
    public Random rand_panels = new Random();
    // labels
    public JLabel Money_Label, Gold_Label, MegaBucks_Label;
    public int rand_int = rand_panels.nextInt(1000 - 1 + 1) + 1;
    public static float money = 0f;
    public static float gold = 0f;
    public static float megaBucks = 0f;
    // call
    public Elements elements;
    public Business_Name_Generator businessNameGenerator;
    public Windows windows;
    public Main_Display_Items mainDisplayItems;

    public Main_Display_Panels(JFrame parent, Container container, Main_Display_Items mainDisplayItems) {
        this.parentFrame = parent;
        this.cp = container;
        this.elements = new Elements();
        this.businessNameGenerator = new Business_Name_Generator();
        this.windows = new Windows(parent, cp);
        this.mainDisplayItems = new Main_Display_Items(parent, cp, this);
        initialize_mainDisplay();
    }

    public void initialize_mainDisplay() {
        // Create main panel with BorderLayout
        JPanel main_panel = new JPanel(new BorderLayout());
        main_panel.setBackground(Main.DARK_BG);
        cp.add(main_panel, BorderLayout.CENTER);

        // Add top panel to NORTH
        JPanel top_panel = new Top_Panel();
        main_panel.add(top_panel, BorderLayout.NORTH);

        // center
        JPanel center_panel = new JPanel(new BorderLayout());
        center_panel.setBackground(Main.TRANSPARENT_COLOR);
        cp.add(main_panel, BorderLayout.CENTER);
        // JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Main.DARK_BG);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));

        // Add Corporation to Center
        for (int i=0; i<rand_int; i++) {
            Main_Display_Items items = new Main_Display_Items(parentFrame, cp, this);
            buttonPanel.add(mainDisplayItems.new Corporation());
        }

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setPreferredSize(new Dimension(1280, 460));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createLineBorder(Main.DARK_BG));

        center_panel.add(scrollPane, BorderLayout.NORTH);
        main_panel.add(center_panel, BorderLayout.CENTER);
        // Add search panel SOUTH
        JPanel search_panel = new Search_Panel();
        main_panel.add(search_panel, BorderLayout.SOUTH);

        // Create a left panel for corporation details
        JPanel left_panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
        left_panel.setBackground(Main.DARK_BG);

        // Add corporation details panel to left panel
        Corporation_Details_Panel corporation_details_panel = new Corporation_Details_Panel();
        left_panel.add(corporation_details_panel);

        // Add left panel to WEST
        main_panel.add(left_panel, BorderLayout.WEST);
    }

    public class Top_Panel extends JPanel {
        private static final String play_time = "Time";
        private static final String planet_name = "Earth";
        private final RandomUserID generator = new RandomUserID();
        private final String unique_id = generator.generateUserID();

        public Top_Panel() {
            setLayout(new BorderLayout());
            setBackground(Main.PANEL_BG);
            setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

            JPanel business_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            business_panel.setBackground(Main.PANEL_BG);

            business_panel.add(createLabel("Business Name:"));
            JTextField business_name_area = createTextField(20);
            business_panel.add(business_name_area);

            JButton randomize_name_button = createButton("Randomize Name");
            business_panel.add(randomize_name_button);
            randomize_name_button.addActionListener(e -> {
                Business_Name_Generator business_name_gen = new Business_Name_Generator();
                business_name_area.setText(business_name_gen.generate()); // Example action
            });

            JPanel details_panel = new JPanel(new GridLayout(0, 1));
            details_panel.setBackground(Main.PANEL_BG);
            details_panel.add(createLabel(String.format("Play Time: %s", play_time)));
            details_panel.add(createLabel(String.format("Planet Name: %s", planet_name)));
            details_panel.add(createLabel(String.format("Unique ID: %s", unique_id)));

            // buttons_panel
            JPanel buttons_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttons_panel.setBackground(Main.PANEL_BG);

            JButton storage_unit = createButton("Storage Unit");
            buttons_panel.add(storage_unit);
            storage_unit.addActionListener(e -> {
                Windows windows_storage = new Windows(parentFrame, cp);
                windows_storage.new Storage_Unit_Window();
            });

            JButton rocket_store = createButton("Rocket Store");
            buttons_panel.add(rocket_store);
            rocket_store.addActionListener(e -> {
                Windows windows_rocket = new Windows(parentFrame, cp);
                windows_rocket.new Rocket_Store_Window();
            });

            JButton planet_store = createButton("Planet Store");
            buttons_panel.add(planet_store);
            planet_store.addActionListener(e -> {
                Windows windows_planet = new Windows(parentFrame, cp);
                windows_planet.new Planet_Store_Window();
            });

            add(business_panel, BorderLayout.WEST);
            add(details_panel, BorderLayout.EAST);
            add(buttons_panel, BorderLayout.SOUTH);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Main.TEXT_COLOR);
            label.setFont(Main.BASIC_FONT);
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

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }

    public class Corporation_Details_Panel extends JPanel {
        public Corporation_Details_Panel() {
            setLayout(new BorderLayout());
            setBackground(Main.PANEL_BG);
            setPreferredSize(new Dimension(220, 120));

            JPanel corporation_details_panel = new JPanel(new GridLayout(0, 1));
            corporation_details_panel.setBackground(Main.PANEL_BG);

            Elements elements = new Elements();
            Money_Label = createLabel(String.format("Money: $%s", elements.formatNumber(money)));
            Gold_Label = createLabel(String.format("Gold: $%s", elements.formatNumber(gold)));
            MegaBucks_Label = createLabel(String.format("Mega Bucks: $%s", elements.formatNumber(megaBucks)));

            corporation_details_panel.add(Money_Label);
            corporation_details_panel.add(Gold_Label);
            corporation_details_panel.add(MegaBucks_Label);

            JButton convert_button = createButton("Convert Money");
            convert_button.addActionListener(e -> {
                Windows windows_convert = new Windows(parentFrame, cp);
                windows_convert.new Convet_Money_Window();
            });
            corporation_details_panel.add(convert_button);

            add(corporation_details_panel, BorderLayout.CENTER);
        }

        private JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setForeground(Main.TEXT_COLOR);
            label.setFont(Main.BASIC_FONT);
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }

    public class Search_Panel extends JPanel {
        public Search_Panel() {
            setLayout(new BorderLayout());
            setBackground(Main.PANEL_BG);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            // search_panel
            JPanel search_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            search_panel.setBackground(Main.PANEL_BG);

            JTextField search_area = createTextField(20);
            search_panel.add(search_area);

            // buttons_panel
            JPanel buttons_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttons_panel.setBackground(Main.PANEL_BG);

            JButton upgrade_button = createButton("Upgrades");
            buttons_panel.add(upgrade_button);
            upgrade_button.addActionListener(e -> {
                Windows windows_upgrade = new Windows(parentFrame, cp);
                windows_upgrade.new Company_Upgrade_Store_Window();
            });

            JButton manager_button = createButton("Managers");
            buttons_panel.add(manager_button);
            manager_button.addActionListener(e -> {
                Windows windows_manager = new Windows(parentFrame, cp);
                windows_manager.new Managers_Store_Window();
            });

            JButton investors_button = createButton("Investors");
            buttons_panel.add(investors_button);
            investors_button.addActionListener(e -> {
                Windows windows_investors = new Windows(parentFrame, cp);
                windows_investors.new Investors_Window();
            });

            add(search_panel, BorderLayout.CENTER);
            add(buttons_panel, BorderLayout.SOUTH);
        }

        private JTextField createTextField(int columns) {
            JTextField field = new JTextField(columns);
            field.setFont(Main.BASIC_FONT);
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Main.ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            return field;
        }

        private JButton createButton(String text) {
            JButton button = new JButton(text);
            button.setFont(Main.BASIC_FONT);
            button.setBackground(Main.ACCENT_COLOR);
            button.setForeground(Main.BUTTON_TEXT);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
            return button;
        }
    }


    public class RandomUserID {
        public String generateUserID() {
            return UUID.randomUUID().toString();
            }
    }
}