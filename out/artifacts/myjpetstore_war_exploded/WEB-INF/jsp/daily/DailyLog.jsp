<%@ include file="../common/IncludeTop.jsp"%>
<div>
    <p align="center">Daily Log</p>
    <table align="center">
        <tr>
            <th><b>Time</b></th>
            <th><b>Log</b></th>
        </tr>

        <c:forEach var="daily" items="${sessionScope.dailyList}">
            <tr>
                <td>
                    ${daily.date.toString()}
                </td>
                <td>
                    ${daily.operationtype}
                </td>
            </tr>

        </c:forEach>

    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>