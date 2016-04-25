package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDifference {

	public DateBeans getDifference(String dateStart, String dateStop) {

		// HH converts hour in 24 hours format (0-23), day calculation
		String startDateformat[] = dateStart.split("T");
		String updatedStartDate = startDateformat[0] + " " + startDateformat[1];
		System.out.println(updatedStartDate);

		String stopDateformat[] = dateStop.split("T");
		String updatedStopDate = stopDateformat[0] + " " + stopDateformat[1];
		System.out.println(updatedStopDate);

		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try

		{
			d1 = format.parse(updatedStartDate);
			d1 = format.parse(updatedStartDate);
			d2 = format.parse(updatedStopDate);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			DateBeans bean=new DateBeans();
			bean.setDiffDays(diffDays);
			bean.setDiffHour(diffHours);
			bean.setDiffMin(diffMinutes);
			bean.setDiffSec(diffSeconds);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		TimeDifference dif = new TimeDifference();
		String dateStart = "2012-01-14T09:29:58";
		String dateStop = "2012-01-15T10:31:48";
		dif.getDifference(dateStart, dateStop);
	}
}
