<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<STYLE>
.ul9 .li9 {
	margin-right: 20px;
}

.social {
	display: flex;
	margin-right: 10px;
}

.link {
	list-style-type: none;
}

.icon4 {
	padding: 4px;
	color: rgb(88, 17, 67);
}

.nav-link {
	color: white;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-size: 15px;
}

.social {
	padding-top: 5px;
	font-size: 80%;
	list-style-type: none;
}

.ico5 {
	color: rgb(19, 3, 15);
	font-size: 30px;
}
</STYLE>
<body>


	<nav class="navbar navbar-expand-sm navbar-light navbar-light"
		style="background-color: rgba(224, 0, 86, 0.829);">
		<a class="navbar-brand" href="HOME.HTML"> <img
			src="${cr }/img/logo7.PNG" width="130" height="50"
			class="d-inline-block align-top" alt="LIBROWORLD">

		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarToggleExternalContent"
			aria-controls="navbarToggleExternalContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarToggleExternalContent">
			<ul class="navbar-nav ">
				<c:choose>
					<c:when test="${sessionScope.adminrole}">


						<li class="nav-item "><a class="nav-link" href="${cr }/home">HOME</a></li>

						<li class="nav-item "><a class="nav-link"
							href="${cr }/aboutus">ABOUT US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr }/contactus">CONTACT US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr }/admin/category"> MANAGE CATEGORY </a></li>
							
						<li class="nav-item "><a class="nav-link"
							href="${cr }/admin/product">MANAGE PRODUCT </a></li>
						<li class="nav-item "><a class="nav-link"
							href="logout">Hi ${sessionScope.username}LOGOUT </a></li>
					</c:when>



					<c:when test="${userrole}">
						<li class="nav-item "><a class="nav-link" href="${cr }/home">HOME</a></li>

						<li class="nav-item "><a class="nav-link"
							href="${cr }/aboutus">ABOUT US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr }/contactus">CONTACT US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr }/allproducts"> PRODUCT </a></li> 
						<li class="nav-item "><a class="nav-link"
							href="logout">Welcome ${sessionScope.username} LOGOUT </a></li>
					</c:when>
					<c:otherwise>


						<li class="nav-item "><a class="nav-link" href="${cr }/home">HOME</a></li>

						<li class="nav-item "><a class="nav-link"
							href="${cr }/aboutus">ABOUT US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr }/contactus">CONTACT US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr }/allproducts"> PRODUCT </a></li>
						<li class="nav-item"><a class="nav-link" href="login">SIGN
								IN</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${cr }/register">SIGN UP</a></li>
					</c:otherwise>
				</c:choose>
			</ul>


		</div>



		<div class="search-container">
			<form>
				<input type="text" placeholder=" Search" name="search">
				<button type="submit">
					<i class="fa fa-search icon4 "></i>
				</button>
			</form>
		</div>

		<div class="social-icons">
			<ul class="ul9 social">

				<li class="li9"><a href="#" target="blank"><i
						class="fa fa-google ico5 " aria-hidden="true"></i></a></li>
				<li class="li9"><a href="#" target="blank"><i
						class="fa fa-twitter ico5" aria-hidden="true"></i></a></li>
				<li class="li9"><a href="#" target="blank"><i
						class="fa fa-facebook ico5 " aria-hidden="true"></i></a></li>

			</ul>

		</div>





	</nav>
</body>