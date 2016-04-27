<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta
	content="width=device-width; initial-scale=1.0; maximum-scale=1.5; user-scalable=1;"
	name="viewport">
<link rel="STYLESHEET" href="nnn.css" type="text/css">

</head>
<body>
	<div class="ref" align="right">
		<div style="padding: 10px;">
			<form method="post" id="form1" action="">
				<input type="text" name="key" placeholder="  API Key" required /> <input
					type="text" name="token" placeholder="  Token" required /> <input
					type="text" name="board" placeholder="  Board Id" required /> <input
					name="submita" type="submit" value="Details" />
			</form>
		</div>
	</div>
	<%
String btsubmit=request.getParameter("submita");
String key="";
if(btsubmit != null)
{
key=(String)request.getParameter("key");
String token=request.getParameter("token");
String board=request.getParameter("board");

}
%>
	<center>
		<div class="bodi">
			<div class="tableDiv">
				<table class="table">
					<colgroup>
						<col width="100%">
					</colgroup>
					<tbody>
						<tr>
							<td align="center">
								<div class="subheader">
								<p class="table-text">
									<span class="bolds"><%= key%></span></a>
									</p>
									</center>
								</div>
							</td>
							</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</center>
	<center>
</body>
</html>