package main;

public class Details {

	String boardName;
	String listName;
	String cardName;
	String cardStatus;
	DateBeans travelDetails;

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public DateBeans getTravelDetails() {
		return travelDetails;
	}

	public void setTravelDetails(DateBeans travelDetails) {
		this.travelDetails = travelDetails;
	}
}
