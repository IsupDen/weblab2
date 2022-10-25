<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="ru.isupden.lab2.model.Point" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="ru.isupden.lab2.repo.HitStorage" %>
<table id="results">
  <thead>
  <tr>
    <th style="--wdt:20%">Point</th>
    <th style="--wdt:20%">Radius</th>
    <th style="--wdt:20%">Current time</th>
    <th style="--wdt:20%">Execution time</th>
    <th style="--wdt:20%">Result</th>
  </tr>
  </thead>
  <tbody id="resultss">
  <%
    if (application.getAttribute("storage") != null) {
      for (Point hit : ((HitStorage) application.getAttribute("storage")).getPoints()) {
  %>
  <tr>
    <td>(<%=hit.getX()%>, <%=hit.getY()%>)</td>
    <td><%=hit.getR()%></td>
    <td><%=hit.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"))%></td>
    <td><%if (hit.getScriptTime() > 0) {%><%=hit.getScriptTime() / 1000%> ms<%} else {%>Very fast<%}%></td>
    <td><%=hit.getHit()%></td>
  </tr>
  <%
      }
    }
  %>
  </tbody>
</table>
