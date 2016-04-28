<%@page import="main.Details"%>
<%@page import="main.MainMethod"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="STYLESHEET" href="nnn.css" type="text/css">
<title>Trello Api</title>
</head>
<body>
	<div class="ref" align="right">
		<div style="padding: 10px;">
			<form method="post" id="form1" action="">
				<input type="text" name="key" placeholder="  API Key" required /> <input
					type="text" name="token" placeholder="  Token" required /> <input
					type="text" name="board" placeholder="  Board Id" required /> <input
					name="submit" type="submit" value="Details" />
			</form>
		</div>
	</div>
	<center>
		<div class="bodi">
			<div class="tableDiv">
			<p class="text"><span class="bolds">Trello API</span></p>
			<p class="text"><span class="bolds">Time Calculation from "In Progress" to "Done"</span></p>
			</div>
			<div class="tableDiv">
				<%
				try
				{
					String btsubmit = request.getParameter("submit");
						if (btsubmit != null) {
					String key = (String) request.getParameter("key");
					String token = request.getParameter("token");
					String board = request.getParameter("board");
					MainMethod method=new MainMethod();
					ArrayList<Details> list=method.getDetails(key, token, board);
					for (int i = 0; i < list.size(); i++) {
						Details det = list.get(i);
						
				%>


				<table class="table">
					<colgroup>
						<col width="100%">
					</colgroup>
					<tbody>
						<tr>
							<td align="center">
								<div class="subheader">
									<p class="table-text">
									<table class="table">
										<colgroup>
											<col width="25%">
											<col width="25%">
											<col width="25%">
											<col width="25%">
										</colgroup>
										<tbody>
											<tr >
												<td align="left"><span class="bolds"> Board Name </span></td>
												<td align="left"><%=det.getBoardName()%></td>										</td>
												<td align="left"><span class="bolds"> List Name </span></td>
												<td align="left"><%=det.getListName()%>	</td>
											</tr>
											<tr>
												<td align="left"><span class="bolds"> Card Name </span></td>
												<td align="left"><%=det.getCardName()%></td>
												<td align="left"><span class="bolds"> Card Status </span></td>
												<td align="left"><%=det.getCardStatus()%></td>
											</tr>
											<tr>
												<td  align="center" colspan="4">
												<span class="bolds"> Card Travels :<%= det.getTravelDetails()%></span>
											</td>
											</tr>
											</tbody>
									</table>
									</p>
									</center>
								</div>
							</td>
							</div>
							</td>
						</tr>
					</tbody>
				</table>
				<%} }}catch(Exception e)
				{
					
				%>
				
				<script>
				alert("Key is not valid.");
				</script>
				<%
					
					
				}%>
			</div>
		</div>
	</center>
</body>
</html>