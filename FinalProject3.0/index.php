<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

    <!-- jQuery CDN -->
    <script src="jquery.min.js"></script>

    <!-- Bootstrap CDN -->
    <script src="bootstrap.min.js"></script>

    <!-- Zabuto Calendar -->
    <script src="../zabuto_calendar.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../zabuto_calendar.min.css">

</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<!--<img src="images/pic02.jpg" alt="" />-->
			<h1><a href="#">Luying</a></h1>
			<span>cs242 Final Project</span>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="index.php" accesskey="1" title="">Homepage</a></li>
				<li><a href="info.php" >Currently Watching Info</a></li>
			</ul>
		</div>
	</div>
	<div id="main">
		<div id="banner">
			            <div id="my-calendar"></div>

            <script type="application/javascript" src="cal.js">
				
            </script>
		</div>
		<div id="welcome">
			<div class="title">
				<h2>
					<?php 
					error_reporting(E_ALL ^ E_NOTICE); 
					date_default_timezone_set('America/Chicago');
					echo	date("l");
					?> play list</h2>
				<h3 class="byline">
				<div>
				  <?php 
					include 'update.php';
				  ?>
				 </div>
				 </h3>
			</div>
			<ul class="actions">
				<li><a href="#" class="button">Etiam posuere</a></li>
			</ul>
		</div>
		<div id="featured">
			
		</div>

	</div>
</div>
</body>
</html>
