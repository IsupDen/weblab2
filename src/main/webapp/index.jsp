<%@ page import="ru.isupden.lab2.model.Point" %>
<%@ page import="ru.isupden.lab2.repo.HitStorage" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>WebLab</title>
    <link rel="icon" href="img/favicon.png" type="image/png">
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/graphLoad.js"></script>
</head>
<body>
<script type="text/javascript">
    let points = [];
    let point;
</script>
<%
    if (application.getAttribute("storage") != null) {
        for (Point hit : ((HitStorage) application.getAttribute("storage")).getPoints()) {
%>
<script type="text/javascript">
    point = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    point.style.cx = 150 + 30 * <%=hit.getX()%>;
    point.style.cy = 150 - 30 * <%=hit.getY()%>;
    point.style.r = 5;
    point.style.fill = <%=hit.getHit()%> ? '#1d5e91' :'#78183a';
    points.push(point);
</script>
<%
        }
    }
%>
<table class="main-table">
    <tr>
        <td class="header" colspan="2">
            Isupov Denis Vasilievich<br>
            P32121<br>
            Variant: 1207
        </td>
    </tr>
    <tr>
        <td id="graph">
            <object onload="loadGraph()" id="graph-svg" data="img/graph.svg" type="image/svg+xml">Loading</object>
        </td>
        <td id="form">
            <form id="input-form" action="controller">
                <input type="hidden" name="type" value="check">
                <input type="hidden" name="time-zone" id="time-zone-field">
                <table class="form">
                    <tr>
                        <td>
                            <label for="x">X</label>
                        </td>
                        <td>
                            <input name="x" value="0" onkeyup="changeCoord()" type="number" required step="0.00001" max="3" min="-5" class="x field" id="x">
                        </td>
                        <td class="error"></td>
                    </tr>
                    <tr>
                        <td>
                            <label for="y">Y</label>
                        </td>
                        <td>
                            <input name="y" value="0" onkeyup="changeCoord()" type="number" required step="0.00001" max="3" min="-5" class="y field" id="y">
                        </td>
                        <td class="error"></td>
                    </tr>
                    <tr>
                        <td>
                            <label for="r">R</label>
                        </td>
                        <td>
                            <input name="r" value="2" onkeyup="changeR()" type="number" required step="0.00001" max="4" min="1" class="r field" id="r">
                        </td>
                        <td class="error"></td>
                    </tr>
                </table>
                <button id="submit-button" style="--clr:#6eff3e"><span>check</span><i></i></button>
                <button style="--clr:#ff1867" type="reset"><span>reset</span><i></i></button>
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <jsp:include page="table.jsp"/>
            <form action="controller">
                <input type="hidden" name="type" value="clear">
                <button style="--clr:#1e9bff" type="submit"><span>clear</span><i></i></button>
            </form>
        </td>
    </tr>
</table>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="js/validate.js"></script>
<script src="js/drawer.js"></script>
<script src="js/answer.js"></script>
</body>
</html>