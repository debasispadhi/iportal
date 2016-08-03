<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>	
	<div class="header"><h3>Welcome : ${username}<a class="logoutLink" href="<c:url value="/j_spring_security_logout" />" > Logout</a></h3>
		<div id="topMenu"><a href="welcome"><button value="Home">Home</button></a></div>
	</div>
<div id="sideNav">
	<ul class="menu">
		
	</ul>
</div>
<div id="pageBody">
hello
</div>	
	
	
		
</body>
</html>