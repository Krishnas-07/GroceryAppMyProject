package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
	public String getRandomString(int length) {
		String generatedString = RandomStringUtils.randomAlphabetic(length);
		return generatedString;
	}
}
