<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Custom-Login</title>
<style type="text/css">
.failed{
color:red;}
</style>

</head>

<body>
<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
<c:if test="${param.error!=null}">
<i class="failed">Sorry bad credentials..</i>

</c:if>

<p>
UserName<input type="text" name="username">

</p>
<p>
Password<input type="password" name="password">
</p>
<input type="submit" name="login">



</form:form>



</body>

</html>