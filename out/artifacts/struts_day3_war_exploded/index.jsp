<%--
  Created by IntelliJ IDEA.
  User: wangwei
  Date: 2023/5/31
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  验证码:<img src="${pageContext.request.contextPath}/code/code"><br>
  whxh验证码:<img src="http://zhxy.xhe.cn/ran/randomCode?reqNo=79634bb7-4a27-41be-abf2-c112f74cefd7">
  <script>
      window.location.href="${pageContext.request.contextPath}/ems1.0-绿色版/login.jsp"
  </script>
  </body>
</html>
