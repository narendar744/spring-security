<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<h2> home Controller</h2>
<hr>
<h3> wel Come</h3>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="logout"/>


</form:form>