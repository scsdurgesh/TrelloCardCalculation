package main;

import java.util.Iterator;
import java.util.List;

import org.trello4j.CardService;
import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Action;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;

public class MainMethod_old {

	public static void main(String[] args) {

		Trello trello = new TrelloImpl("3d8097336659354b2b057ae281064004",
				"9f76b28622d45f8b00f6e0b6a59e8a999e0b62172363725ea13347bb8d42adc5");

		List<org.trello4j.model.List> lists = trello
				.getListByBoard("566aa55d83a50f627edda222");

		Iterator<org.trello4j.model.List> itr_list = lists.iterator();
		while (itr_list.hasNext()) {

			org.trello4j.model.List objx = itr_list.next();
			System.out.println("List :" + objx.getName());
			java.util.List<Card> list = trello.getCardsByList(objx.getId());

			Iterator<Card> itr = list.iterator();
			while (itr.hasNext()) {

				Card obj = itr.next();
				System.out.println(obj.getId());
				System.out.println("Card :" + obj.getName());
				System.out.println("Card :" + obj.getDateLastActivity());

			}

		}

	}
}
