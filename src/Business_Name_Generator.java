import java.util.*;
import java.util.function.Supplier;

public class Business_Name_Generator {
    private static final List<String> PREFIXES = Arrays.asList(
            "Nova", "Peak", "Elite", "Prime", "Core", "Vital", "Next", "Swift",
            "Bright", "Clear", "Smart", "Echo", "Alpha", "Meta", "Golden", "Silver",
            "Apex", "Summit", "Fusion", "Synergy", "Insight", "Vision", "Horizon",
            "Everest", "Omega", "Zenith", "Quantum", "Prism", "Spectrum", "Venture"
    );

    private static final List<String> SUFFIXES = Arrays.asList(
            "Tech", "Solutions", "Systems", "Dynamics", "Innovations", "Partners",
            "Enterprises", "Group", "Networks", "Logic", "Works", "Concepts",
            "Global", "Industries", "Ventures", "Labs", "Studio", "Collective",
            "Connect", "Forge", "Capital", "Experts", "Minds", "Consulting",
            "Services", "Wave", "Point", "Hub", "Nexus", "Matrix"
    );

    private static final List<String> MODIFIERS = Arrays.asList(
            "Pro", "Plus", "Max", "Ultra", "Advanced", "Premium", "Superior",
            "Strategic", "Innovative", "Creative", "Digital", "Modern", "Global",
            "Integrated", "Unified", "Central", "Direct", "Dynamic", "Sustainable",
            "Reliable", "", "", "", ""
    );

    private static final List<String> DOMAINS = Arrays.asList(
            "Finance", "Health", "Data", "Cloud", "Mobile", "Web", "Cyber",
            "Media", "Energy", "Design", "Legal", "Supply", "Market", "Food",
            "Software", "Hardware", "Retail", "Medical", "Edu", "Bio", "Green",
            "Eco", "AI", "Smart", "Virtual", "Digital", "", "", "", ""
    );

    private static final Random random = new Random(System.currentTimeMillis());

    public static String generate() {
        List<Supplier<String>> patterns = Arrays.asList(
                () -> randomChoice(PREFIXES) + " " + randomChoice(SUFFIXES),
                () -> randomChoice(PREFIXES) + randomChoice(SUFFIXES),
                () -> randomChoice(DOMAINS) + randomChoice(SUFFIXES),
                () -> randomChoice(PREFIXES) + " " + randomChoice(DOMAINS),
                () -> randomChoice(PREFIXES) + randomChoice(MODIFIERS) + " " + randomChoice(SUFFIXES),
                () -> randomChoice(DOMAINS) + " " + randomChoice(SUFFIXES),
                () -> randomChoice(PREFIXES) + " " + randomChoice(DOMAINS) + " " + randomChoice(SUFFIXES)
        );

        return patterns.get(random.nextInt(patterns.size())).get();
    }

    private static String randomChoice(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

    // For testing
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generate());
        }
    }
}
