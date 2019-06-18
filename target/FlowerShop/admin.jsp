<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.accenture.flowershop.be.entity.order.State" %>
<%@ page import="com.accenture.flowershop.fe.dto.order.OrderDTO" %>
<jsp:useBean id="orders" type="java.util.List<com.accenture.flowershop.fe.dto.order.OrderDTO>"
 scope="session"></jsp:useBean>
<html>
    <head/>
    <body>

    <form action="/logout" method="POST">
    <input type="submit" value="logout"/>
    </form>

<%
            for (OrderDTO item : orders) {
                        if (item.getState().equals(State.PAID)) {
                            out.println("<tr>");
                            out.println("<td>" + item.getOpenDate() + " " + " </td>)");
                            out.println("<td>" + item.getTotalCost() + " " + " </td>");
                            out.println("<td>" + item.getState() + " " + " </td>");
                            out.println("</tr>");
                            out.println("<br>");
                            out.println("<form action="+"/close_order" + " method="+"post"+">"+
                                                        "<input type="+"submit "+"name="+item.getOrderId() +" value="+"close"+">"+
                                                        "</form>");
                                                out.println("<br>");
                        }
                    }
                    for (OrderDTO item : orders) {
                        if (item.getState().equals(State.CLOSED)) {
                            out.println("<tr>");
                            out.println("<td>" + item.getOpenDate() + " " + " </td>)");
                            out.println("<td>" + item.getCloseDate() + " " + " </td>");
                            out.println("<td>" + item.getTotalCost() + " " + " </td>");
                            out.println("<td>" + item.getState() + " " + " </td>");
                            out.println("</tr>");
                            out.println("<br>");
                        }
                    }
        %>
            </body>
        </html>