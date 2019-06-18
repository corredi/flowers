<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.accenture.flowershop.fe.dto.flower.FlowerDTO" %>
<%@ page import="com.accenture.flowershop.fe.dto.user.CustomerDTO" %>
<%@ page import="com.accenture.flowershop.be.entity.order.State" %>
<%@ page import="com.accenture.flowershop.fe.dto.order.OrderDTO" %>

<jsp:useBean id="orders" type="java.util.ArrayList<com.accenture.flowershop.fe.dto.order.OrderDTO>"
 scope="session"></jsp:useBean>
<jsp:useBean id="flowers" type="java.util.List<com.accenture.flowershop.fe.dto.flower.FlowerDTO>"
 scope="session"></jsp:useBean>
 <jsp:useBean id="customer" class="com.accenture.flowershop.fe.dto.user.CustomerDTO"
  scope="session"></jsp:useBean>

<html>
    <head/>
    <body>

    <form action="/logout" method="POST">
    <input type="submit" value="logout"/>
    </form>

    <%
                    out.println("<tr>");
                    out.println("<td>"+customer.getLogin()+"</td>)");
                    out.println("<td>"+customer.getMoney()+"</td>");
                    out.println("<td>"+customer.getDiscount()+"</td>");
                    out.println("</tr>");
                    out.println("<br>");
                    out.println("<br>");
    %>

    <form action="/bag.jsp" method="POST">
    <input type="submit" value="bag"/>
    </form>

    <form action="/catalog" method="POST">
      <input type="radio" name="sortBy" value="name" checked>name<br>
      <input type="radio" name="sortBy" value="cost">cost<br>
      <input type="radio" name="sortBy" value="stock"> stock<br>
      <INPUT TYPE="submit" VALUE="Submit">
    </form>
    <%
        for(FlowerDTO flower:flowers){
                out.println("<tr>");
                out.println("<td>"+flower.getName()+" "+" </td>)");
                out.println("<td>"+flower.getStock()+" "+" </td>");
                out.println("<td>"+flower.getCost()+" "+" </td>");
                out.println("</tr>");
                out.println("<form action="+"/catalog" + " method="+"post"+">"+
                                             "<label for="+"amount"+">amount</label>"+
                                             "<input type="+"number"+" name="+flower.getName()+" " +" value="+"0 "+"/> <br/>"+
                                             "<input type="+"submit"+" value="+"submit"+">"+
                                     "</form>");
                out.println("<br>");
            }
    %>
    <br>
    <%
            for (OrderDTO item : orders) {
                        if (item.getState().equals(State.PAID)) {
                            out.println("<tr>");
                            out.println("<td>" + item.getOpenDate() + " " + " </td>)");
                            out.println("<td>" + item.getTotalCost() + " " + " </td>");
                            out.println("<td>" + item.getState() + " " + " </td>");
                            out.println("</tr>");
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