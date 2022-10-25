<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
    <link rel="icon" href="img/favicon.png" type="image/png">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:useBean id="hit" class="ru.isupden.lab2.model.Point" scope="session"/>
<table>
    <tr>
        <td class="td">
            <div id="result-div">
                <label>X: <%=hit.getX()%>    Y: <%=hit.getY()%>    R: <%=hit.getR()%></label><br>
                <label>Current Time: <%=hit.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"))%></label><br>
                <label>Script Time: <%=hit.getScriptTime() / 1000%> ms</label><br>
                <label style="color:<%if (hit.getHit()) {%>#6eff3e<%} else {%>#ff1867<%}%> "><%if (hit.getHit()) {%>Great shot<%} else {%>Try again<%}%></label>
            </div>
        </td>
        <td class="td">
            <form action="index.jsp">
                <button style="--clr:#1e9bff" type="submit"><span>Go back</span><i></i></button>
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <jsp:include page="table.jsp"/>
        </td>
    </tr>
</table>
</body>
</html>
