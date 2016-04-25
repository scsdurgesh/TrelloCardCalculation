package main;
import java.util.Iterator;
import java.util.List;

import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;

public class MainMethod {

	public static void main(String[] args) {
		
		Trello trello=new TrelloImpl("3d8097336659354b2b057ae281064004", "9f76b28622d45f8b00f6e0b6a59e8a999e0b62172363725ea13347bb8d42adc5");
		
		java.util.List<Card> list = trello.getCardsByList("566aa55d83a50f627edda223");
		List<org.trello4j.model.List> lists = trello.getListByBoard("566aa55d83a50f627edda222");
		System.out.println(lists);
		
		
		Iterator<Card> itr=list.iterator();
		while (itr.hasNext()) {
			
			Card obj=itr.next();
			System.out.println(obj);
			System.out.println(obj.getName());
			System.out.println(obj.getUrl());
//			System.out.println(obj.getDateLastActivity());
			List<Attachment> act = obj.getAttachments();
			
			System.out.println(act);
		}
	}
}
