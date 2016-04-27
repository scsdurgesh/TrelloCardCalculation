package main;

import java.util.Date;

public class TimeDifference {


	public  DateBeans differenceDate(Date startDate, Date stopDate) {
		// TODO Auto-generated method stub
		long diff = stopDate.getTime() - startDate.getTime();
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

	}
}
