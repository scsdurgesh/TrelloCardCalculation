package main;

public class DateBeans {

	long diffDays, diffHour, diffMin, diffSec;

	public DateBeans() {
		// TODO Auto-generated constructor stub
		
		setDiffDays(0);
		setDiffHour(0);
		setDiffMin(0);
		setDiffSec(0);
	}
	public long getDiffDays() {
		return diffDays;
	}

	public void setDiffDays(long diffDays) {
		this.diffDays = diffDays;
	}

	public long getDiffHour() {
		return diffHour;
	}

	public void setDiffHour(long diffHour) {
		this.diffHour = diffHour;
	}

	public long getDiffMin() {
		return diffMin;
	}

	public void setDiffMin(long diffMin) {
		this.diffMin = diffMin;
	}

	public long getDiffSec() {
		return diffSec;
	}

	public void setDiffSec(long diffSec) {
		this.diffSec = diffSec;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return diffDays+" Days "+diffHour+" Hours "+diffMin+" Minutes "+diffSec+" Seconds.";
		
	}
}
