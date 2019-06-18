<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.accenture.flowershop.fe.dto.order.OrderInfoDTO" %>
<%@ page import="com.accenture.flowershop.fe.dto.flower.FlowerDTO" %>
<%@ page import="com.accenture.flowershop.fe.dto.user.CustomerDTO" %>
<%@ page import="com.accenture.flowershop.be.entity.order.State" %>
<%@ page import="com.accenture.flowershop.fe.dto.order.OrderDTO" %>

 <jsp:useBean id="bag" type="com.accenture.flowershop.fe.dto.order.OrderDTO"
  scope="session"></jsp:useBean>
 <jsp:useBean id="customer" class="com.accenture.flowershop.fe.dto.user.CustomerDTO"
  scope="session"></jsp:useBean>

<html>
    <head/>
    <body>

    <form action="/logout" method="POST">
    <input type="submit" value="logout"/>
    </form>

    <form action="/form_order" method="POST">
    <input type="submit" value="Order"/>
    </form>

    <%
                    out.println("<tr>");
                    out.println("<td>"+customer.getLogin()+"</td>)");
                    out.println("<td>"+customer.getMoney()+"</td>");
                    out.println("<td>"+customer.getDiscount()+"</td>");
                    out.println("</tr>");
                    out.println("<br>");
                    out.println("<br>");
                    out.println("<td>"+bag.getTotalCost()+"    "+" </td>");
    %>

    <form action="/catalog" method="POST">
    <input type="submit" value="Back to catalog"/>
    </form>

    <%
        for(OrderInfoDTO orderInfo:bag.getOrderInfo()){
                    out.println("<tr>");
                    out.println("<td>"+orderInfo.getFlower()+"    "+" </td>)");
                    out.println("<td>"+orderInfo.getFloweramount()+"    "+" </td>");
                    out.println("<td>"+orderInfo.getCost()+"    "+" </td>");
                    out.println("<td>"+orderInfo.getItemCost()+"    "+" </td>");

                    out.println("</tr>");
                    out.println("<form action="+"/bag" + " method="+"post"+">"+
                            "<label for="+"newAmount"+">Amount</label>"+
                            "<input type="+"number"+" name="+"order"+orderInfo.getFlower()+" " +" value="+"/0 "+"/> <br/>"+
                            "<input type="+"submit"+" value="+"update"+">"+
                            "</form>");
                    out.println("<br>");

                }
    %>
    </body>
</html>