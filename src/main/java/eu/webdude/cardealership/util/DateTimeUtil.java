package eu.webdude.cardealership.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtil {
	public static ZonedDateTime fromYear(int year) {
		return ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
	}
}
