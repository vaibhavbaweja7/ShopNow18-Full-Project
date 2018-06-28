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
<h1 align="center">${categoryId} at ShopNow18 </h1>
 <div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                    Products</h1>
            </div>
        </div>
    </div>
</div>
<figure> 
<div class="container">
   <div class="row-md-12">
			<div class="row-sm-6 col-md-4">
				<div class="thumbnail" >
<c:forEach var="item" items="${getProductbyId}">
<div id="wrap">
<img src="${pageContext.request.contextPath}/resources/images/${item.productId}.jpg"alt="sometext" height="200" width="200" class="responsive">
<div class="caption">

<figcaption><option value="${item.productId}">${item.productId}</option></figcaption>

							
<figcaption><option value="${item.productPrice}">${item.productPrice}</option></figcaption>

						
<p>
       <a href="${pageContext.request.contextPath}/cart" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
        </a>
      </p></div>
      
					<div class="control-group">
		<a href="${pageContext.request.contextPath}/Productdetails/${item.productId}">			
      <button type="submit"  style="font-size:20px">More Details <i class="fa fa-chevron-circle-right"></i></button>
      </a>
      </div>
		
      </div>
 
</c:forEach>
</div>
				</div>
			</div>
			</div>

</figure>

</body>
</html>
