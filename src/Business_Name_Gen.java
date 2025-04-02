import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Business_Name_Gen {
    private final Random rand;
    public String pattern;

    private static final List<String> prefixes = Arrays.asList(
            "Nova", "Peak", "Elite", "Prime", "Core", "Vital", "Next", "Swift",
            "Bright", "Clear", "Smart", "Echo", "Alpha", "Meta", "Golden", "Silver",
            "Apex", "Summit", "Fusion", "Synergy", "Insight", "Vision", "Horizon",
            "Everest", "Omega", "Zenith", "Quantum", "Prism", "Spectrum", "Venture"
    );

    private static final List<String> suffixes = Arrays.asList(
            "Tech", "Solutions", "Systems", "Dynamics", "Innovations", "Partners",
            "Enterprises", "Group", "Networks", "Logic", "Works", "Concepts",
            "Global", "Industries", "Ventures", "Labs", "Studio", "Collective",
            "Connect", "Forge", "Capital", "Experts", "Minds", "Consulting",
            "Services", "Wave", "Point", "Hub", "Nexus", "Matrix"
    );

    private static final List<String> modifiers = Arrays.asList(
            "Pro", "Plus", "Max", "Ultra", "Advanced", "Premium", "Superior",
            "Strategic", "Innovative", "Creative", "Digital", "Modern", "Global",
            "Integrated", "Unified", "Central", "Direct", "Dynamic", "Sustainable",
            "Reliable"
    );

    private static final List<String> domains = Arrays.asList(
            "Finance", "Health", "Data", "Cloud", "Mobile", "Web", "Cyber",
            "Media", "Energy", "Design", "Legal", "Supply", "Market", "Food",
            "Software", "Hardware", "Retail", "Medical", "Edu", "Bio", "Green",
            "Eco", "AI", "Smart", "Virtual", "Digital"
    );

    public Business_Name_Gen() {
        this.rand = new Random();
    }

    // Helper method to generate combinations dynamically
    private void generateCombinations(List<String> list, List<String> prefixes, List<String> suffixes,
                                      List<String> modifiers, List<String> domains) {
        for (String prefix : prefixes.isEmpty() ? List.of("") : prefixes) {
            for (String suffix : suffixes.isEmpty() ? List.of("") : suffixes) {
                for (String modifier : modifiers.isEmpty() ? List.of("") : modifiers) {
                    for (String domain : domains) {
                        list.add(String.join(" ", prefix, suffix, modifier, domain).trim());
                    }
                }
            }
        }
    }

    public String generateName() {
        List<String> allCombinations = new ArrayList<>();
        // Generate all possible combinations
        generateCombinations(allCombinations, prefixes, suffixes, modifiers, domains);
        generateCombinations(allCombinations, List.of(), suffixes, modifiers, domains);
        generateCombinations(allCombinations, List.of(), List.of(), modifiers, domains);
        generateCombinations(allCombinations, List.of(), List.of(), List.of(), domains);
        return allCombinations.get(rand.nextInt(allCombinations.size()));
    }
}