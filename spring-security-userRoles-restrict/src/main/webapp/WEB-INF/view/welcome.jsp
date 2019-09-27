<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<h2> home Controller</h2>
<hr>
<h3> Welcome</h3>
<hr>
user:<security:authentication property="principal.username"/><br>
<br>
Roles:<security:authentication property="principal.authorities"/><br>
<br><br>
<br>
<hr>
<a href="${pageContext.request.contextPath}/leaders">leaders Meeting</a>
<hr>

<hr>
<a href="${pageContext.request.contextPath}/systems">SoftIT Meeting Meeting</a>
<hr>


<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="logout"/>


</form:form>