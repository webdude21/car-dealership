package eu.webdude.cardealership.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	public static ZonedDateTime fromYear(int year) {
		return ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
	}

	public static String toDefaultString(ZonedDateTime zonedDateTime) {
		return zonedDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
	}
}
