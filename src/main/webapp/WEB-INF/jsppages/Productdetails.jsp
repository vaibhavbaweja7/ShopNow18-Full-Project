<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/resources/images/" var="image"/>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"
name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/${productId}.jpg"alt="sometext" height="800" width="400" border="5" >
<div class="caption">
<figcaption>${productDetails.productId}</figcaption>
 <figcaption>${productDetails.productDescription}</figcaption>
<figcaption>${productDetails.productPrice}</figcaption>
<figcaption>${productDetails.productQuantity}</figcaption> 
	</div>
	
						<p>
       <a href="${pageContext.request.contextPath}/cart" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
        </a>
      </p>
      
</body>
</html>