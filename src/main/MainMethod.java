package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Action;
import org.trello4j.model.Card;

public class MainMethod {

	public static void main(String[] args) {

		Trello trello = new TrelloImpl("3d8097336659354b2b057ae281064004",
				"9f76b28622d45f8b00f6e0b6a59e8a999e0b62172363725ea13347bb8d42adc5");

		String BoardId="571f2e85e198e2bba1302828";////Board Durgesh
//		String BoardId="566aa55d83a50f627edda222";// Board Kanban
//		String BoardId="566aa55d83a50f627edda222";// Board Example
		
		ArrayList<Details> detailList=new ArrayList<Details>();
		
		
		
		List<org.trello4j.model.List> lists = trello.getListByBoard(BoardId);
		String boardName=trello.getBoard(BoardId).getName();
		System.out.println("Board Name :"+boardName);
		
		Iterator<org.trello4j.model.List> itrl = lists.iterator();
		while (itrl.hasNext()) {
			Details det=new Details();
			det.setBoardName(boardName);
			org.trello4j.model.List ll = itrl.next();
//			System.out.println("List :"+ll.getName());
			det.setListName(ll.getName());
			
			java.util.List<Card> list = trello.getCardsByList(ll.getId());
			Iterator<Card> itr = list.iterator();
			
//			System.out.println("Total Cards :"+list.size());
			
			while (itr.hasNext()) {
				Card obj = itr.next();
				System.out.println("card :"+obj.getName());
//				det.setCardName(obj.getName());
				List<Action> act=trello.getActionsByCard(obj.getId());
				if(act.size()>1)
				{
					Date stopDate=act.get(0).getDate();
					int x=act.size()-1;
					Date startDate=act.get(x).getDate();
					DateBeans diffDate=differenceDate(startDate,stopDate);
					/*System.out.println("Size :"+act.size());
					System.out.println("Start date :"+startDate );
					System.out.println("Stop date :"+stopDate);
					System.out.println("Diff :"+diffDate);
					*/det.setTravelDetails(diffDate);
//					System.out.println();
				}else
				{
					det.setCardName("No Travels");
//					System.out.println("Card Status : No Travels");
				}
			}
			detailList.add(det);
		}

	}

	
	
	private static DateBeans differenceDate(Date startDate, Date stopDate) {
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
