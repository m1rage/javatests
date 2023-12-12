package utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static String emailDomain = "@emails.com";

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomMessage(int min, int max) {
        String[] words = {"and", "or", "but", "because",
                "red", "white", "Jane", "John", "Bobby",
                "man", "woman", "fish", "elephant", "unicorn",
                "a", "the", "every", "some", "any", "all",
                "big", "tiny", "pretty", "bald", "small",
                "runs", "jumps", "talks", "sleeps", "walks",
                "loves", "hates", "sees", "knows", "looks for", "finds",
                ", ", ", ", ", ", ". ", ". "};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length -1);
            message.append(words[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L) + "";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomEmail() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        return getRandomString(5) + timestamp + emailDomain;
    }

    public static String getRandomMonth() {
        Random random;
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        random = new Random();
        int randomIndex = random.nextInt(months.length);
        return months[randomIndex];
    }

    public static String getRandomYear() {
        Random random;
        random = new Random();
        int randomYear = random.nextInt(123) + 1900;
        return String.valueOf(randomYear);
    }

    public static String getRandomDate() {
        Random random;
        random = new Random();
        int randomDate = random.nextInt(27) + 1;
        return String.valueOf(randomDate);
    }

    public static String getRandomDepartment() {
        Random random;
        String[] department = {"Sales", "Testing", "Development", "Management", "Backoffice", "Support",
                "Legal", "August", "Security"};
        random = new Random();
        int randomIndex = random.nextInt(department.length);
        return department[randomIndex];
    }

}

