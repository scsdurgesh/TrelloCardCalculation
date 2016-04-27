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

	public ArrayList<Details> getDetails(String key,String token,String boardId) {

		Trello trello = new TrelloImpl("3d8097336659354b2b057ae281064004",
				"9f76b28622d45f8b00f6e0b6a59e8a999e0b62172363725ea13347bb8d42adc5");

		String BoardId = "571f2e85e198e2bba1302828";// //Board Durgesh
		// String BoardId="566aa55d83a50f627edda222";// Board Kanban
		// String BoardId="566aa55d83a50f627edda222";// Board Example

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
			if (list.size() == 0) {
				det.setCardName("No Cards");
				det.setCardStatus("No Travels");
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
					det.setTravelDetails(diffDate);
				} else {
					det.setCardStatus("No Travels");
				}
			}
			detailList.add(det);
		}
		printList(detailList);
		return detailList;
	}

	private static void printList(ArrayList<Details> detailList) {

		for (int i = 0; i < detailList.size(); i++) {
			Details det = detailList.get(i);
			System.out.println("Board Name :" + det.getBoardName());
			System.out.println("Card Name :" + det.getCardName());
			System.out.println("Card Status :" + det.getCardStatus());
			System.out.println("List Name :" + det.getListName());
			System.out.println("Card Travels :" + det.getTravelDetails());
			System.out.println();
		}

	}

}
