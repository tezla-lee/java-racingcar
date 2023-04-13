import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int ZERO = 0;
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return ZERO;
        }
        String[] tokens = toTokens(text);
        int[] numbers = toNumbers(tokens);
        return calculate(numbers);
    }

    private static String[] toTokens(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        String[] tokens;
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(DEFAULT_DELIMITER);
        }
        return tokens;
    }

    private static int calculate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    private static int[] toNumbers(String[] tokens) {
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                int num = Integer.parseInt(tokens[i]);
                if (num < 0) {
                    throw new RuntimeException("음수값입니다.");
                }
                nums[i] = num;
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자 이외의 값입니다.");
            }
        }
        return nums;
    }
}
