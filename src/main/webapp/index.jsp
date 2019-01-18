<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Team Project</title>
	<script src="js/main.js" type="application/javascript"></script>
</head>
<body>
	<div class="preloader">
		<div class="circ">
			<div class="load">Loading...</div>
			<div class="hands"></div>
			<div class="body"></div>
			<div class="head">
				<div class="eye"></div>
			</div>
		</div>
	</div>
	<div class="search-form-block">
		<div class="text-before-form icon icon-lupa">
			Search java classes
		</div>
	 	<form name="search" action="GitServlet" class="form-search" method="get">
			<input type="text" name="q" placeholder="Enter class name" class="input input-search" autofocus="">
			<input type="submit" name="" value="Search" class="input btn">
		</form>
	</div>
</body>
</html>