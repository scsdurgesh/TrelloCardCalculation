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

	public ArrayList<Details> getDetails(String key,String token,String BoardId) {

//		Trello trello = new TrelloImpl("3d8097336659354b2b057ae281064004",
//				"9f76b28622d45f8b00f6e0b6a59e8a999e0b62172363725ea13347bb8d42adc5");

//		String BoardId = "571f2e85e198e2bba1302828";// //Board Durgesh
		// String BoardId="566aa55d83a50f627edda222";// Board Kanban
		// String BoardId="566aa55d83a50f627edda222";// Board Example
		Trello trello =new  TrelloImpl(key, token);
		
		
		ArrayList<Details> detailList = new ArrayList<Details>();

		List<org.trello4j.model.List> lists = trello.getListByBoard(BoardId);
		String boardName = trello.getBoard(BoardId).getName();

		Iterator<org.trello4j.model.List> itrl = lists.iterator();
		while (itrl.hasNext()) {
			Details det = new Details();
			det.setBoardName(boardName);
			org.trello4j.model.List ll = itrl.next();
			det.setListName(ll.getName());

			java.util.List<Card> list = trello.getCardsByList(ll.getId());
			Iterator<Card> itr = list.iterator();
			if (list.size() ==0) {
				det.setCardName("No Cards");
				det.setCardStatus("No Travels");
				det.setTravelDetails(new DateBeans());
			}

			while (itr.hasNext()) {
				Card obj = itr.next();
				det.setCardName(obj.getName());
				List<Action> act = trello.getActionsByCard(obj.getId());
				if (act.size() > 1) {
					Date stopDate = act.get(0).getDate();
					int x = act.size() - 1;
					Date startDate = act.get(x).getDate();
					TimeDifference diff = new TimeDifference();
					DateBeans diffDate = diff.differenceDate(startDate,
							stopDate);
					det.setCardStatus("Traveled");
					det.setTravelDetails(diffDate);
				} else {
					det.setCardStatus("No Travels");
					det.setTravelDetails(new DateBeans());
				}
			}
			detailList.add(det);
		}
		return detailList;
	}


}
