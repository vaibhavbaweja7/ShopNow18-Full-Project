<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>






<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>


</style>
<title>Insert title here</title>
</head>
<body><nav class="navbar navbar-default" style="background-color:SkyBlue  ;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <img src="https://www.vistaprint.in/any/preview/viewlogo.aspx?cnf=ShopNow18&icid=1465&csid=117&fsid=9&txid=1&tid=1&cfid=0&xcf=&arid=8&msid=0&drid=0&width=140&height=110" alt="no">
      
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="btn active"><a href="index">Home <span \class="sr-only">(current)</span></a></li>
        
        
        </li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
 <li class="btn"><a href="adminHome">Admin</a></li>
        </sec:authorize>
 
        <li  class="btn dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Product Categories <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <c:forEach var="item" items="${listCategory}">
            <li><a href="pCategories/${item.categoryId}">${item.categoryId}</a></li>
            </c:forEach>
          </ul>
        </li>
      </ul>
      <sec:authorize access="isAnonymous()">
      <ul class="nav navbar-nav navbar-right">
        <li class="btn"><a href="${pageContext.request.contextPath}/Login"> <span class="glyphicon glyphicon-user" aria-hidden="true"></span> <span class="glyphicon-class"></span> Login</a></li>
        <li class="btn"><a href="${pageContext.request.contextPath}/Signup"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;Signup</a></li>
       </ul>
      </sec:authorize>
   
          <sec:authorize access="isAuthenticated()" >			
		<li class="nav-item"> <a href="${pageContext.request.contextPath}/LogOut">Logout</a></li>
				</sec:authorize>
 
        
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<script>
var header = document.getElementById("myDIV");
var btns = header.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}
</script>

</body>
</html>