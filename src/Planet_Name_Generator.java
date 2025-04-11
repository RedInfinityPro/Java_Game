import java.util.*;

public class Planet_Name_Generator {
    private static final List<String> PREFIXES = Arrays.asList(
            "X", "Z", "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Omicron", "Nova", "Astro"
    );

    private static final List<String> SUFFIXES = Arrays.asList(
            "Prime", "Major", "Minor", "IV", "VII", "B", "C", "D", "Rex", "Xenon"
    );

    private static final String LETTERS_AND_NUMBERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final Random random = new Random(System.currentTimeMillis());

    public static String generate() {
        String prefix = randomChoice(PREFIXES);

        int coreLength = random.nextInt(3) + 3; // 3 to 5 characters
        StringBuilder coreName = new StringBuilder();
        for (int i = 0; i < coreLength; i++) {
            coreName.append(LETTERS_AND_NUMBERS.charAt(random.nextInt(LETTERS_AND_NUMBERS.length())));
        }

        String suffix = randomChoice(SUFFIXES);

        return prefix + "-" + coreName.toString() + "-" + suffix;
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
