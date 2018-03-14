<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.DateFormat"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<jsp:useBean id="today" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Servlet 学习示例，zht 2017-12-7
	<%
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	String s = dateFormat.format(new Date());
	out.print(s);

	List<String> list = new ArrayList<>();
	for (int i = 1; i < 10; i++) {
		list.add("hello #" + i);
	}

	for (int i = 0; i < list.size(); i++) {
		out.print(list.get(i));
		out.println("<br>");
	}
	
	out.print(getTodayString());
	out.print(today);
%>

<%!
	public String getTodayString(){
		System.out.println("Today is 2017-12-3");
		return "0";
}
%>
<a href="myform.html">myform</a>
</body>
</html>