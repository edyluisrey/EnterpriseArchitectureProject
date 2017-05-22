<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Members</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Our People</h1>
				<p>All of the contributors to our Community!!!</p>
 			
 				<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
			</div>
 			<c:if test = "${not empty member }" >
 					<a href="<spring:url value="/members/add" />" class="btn btn-danger btn-mini pull-right">Add a new one</a>	
 				<br>
				<spring:url var="logoutUrl" value="/logout"/>
				<form action="${logoutUrl}" method="get">
 				   <sec:csrfInput />
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10 ">
						<input type="submit"  class="btn btn-primary btn-danger pull-right" value ="Logout"/>
					</div>
				</div>
	        </c:if>
				</form>
 			
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${members}" var="member">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h4>First Name - ${member.firstName}</h4>
							<h4>Last Name -  ${member.lastName}
						 <a href="<spring:url value="/members/${member.id}" />" class="btn btn-primary  btn-mini  ">View</a>
 				</h4>
 					</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
