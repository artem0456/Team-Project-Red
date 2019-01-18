<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/main.js" type="application/javascript"></script>
    <title>Result page</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
    <div class="code-list">

        <c:forEach items="${list}" var="obj">
            <div class="code-list-item">
                <div class="code-list-item-links">
                    <a class="code-list-item-link-repository" href="<c:out value="${obj.getRefRepo()}"></c:out>">linkRepository</a> -
                    <a class="code-list-item-link-class" href="<c:out value="${obj.getRefClass()}"></c:out>">linkClass</a>
                </div>
                <div class="code-box">
                    <table class="code-box-table">
                        <tbody>
                            <c:forEach items="${obj.getCode()}" var="arr">
                                <tr class="code-box-row">
                                    <td class="code-number"></td>
                                    <td class="code-text"><c:out value="${arr}"></c:out></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </c:forEach>
    </div>
 </body>
 </html>