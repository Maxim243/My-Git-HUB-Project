package automation.UtilsMethods;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilsMethods {

    public static String createRandomNameOfRepository(int lettersCount) {
        return RandomStringUtils.randomAlphabetic(lettersCount);
    }
}
