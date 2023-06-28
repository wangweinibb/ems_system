<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems1.0-绿色版/css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                    <a style="cursor: pointer"
                       href="${pageContext.request.contextPath}/ems1.0-绿色版/login.jsp">安全退出</a>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome&nbsp;${Name}!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach var="list" items="${list}">
                    <tr class="row1">
                        <td><input type="checkbox" id="checkd" style="cursor: pointer;display: none">${list.id}</td>
                        <td>${list.name}</td>
                        <td>${list.salary}</td>
                        <td>${list.age}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/employee/delall?id=${list.id}">delete emp</a>&nbsp;
                            <a href="${pageContext.request.contextPath}/ems1.0-绿色版/updateEmp.jsp?id=${list.id}&&name=${list.name}&&salary=${list.salary}&&age=${list.age}">update
                                emp</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/ems1.0-绿色版/addEmp.jsp'"/>
            </p>
        </div>
        <a href="#" id="above">上一页</a>
        <input type="text" value="${id}" readonly style="width: 15px;height:10px;text-align: center" id="page">
        <a href="#" id="next">下一页</a>
        <input value="${count}" readonly id="count" style="display: none">
        <script>
            var above = document.getElementById("above");
            var page = document.getElementById("page");
            var next = document.getElementById("next");
            var countinput = document.getElementById("count");
            var count = Math.ceil((countinput.value) / 5);
            function changeid(){
                console.log(countinput.value)
                if (countinput.value == 0) {
                    countinput.value = 1;
                    console.log(countinput.value)
                }
            }
            changeid();
            above.onclick = function () {
                if (page.value > 1) {
                    page.value--
                    window.location.href = "${pageContext.request.contextPath}/employee/findbypage?id=" + (page.value);
                }
            }
            next.onclick = function () {
                console.log(count)
                if (page.value < count) {
                    page.value++
                    window.location.href = "${pageContext.request.contextPath}/employee/findbypage?id=" + (page.value);
                }
            }
        </script>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
