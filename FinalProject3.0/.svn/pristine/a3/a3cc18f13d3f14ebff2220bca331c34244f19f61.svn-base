<!DOCTYPE html>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />


</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Luying</a></h1>
			<span>cs242 Final Project</span>
		</div>
		<div id="menu">
			<ul>
				<li ><a href="index.php" accesskey="1" title="">Homepage</a></li>
				<li class="current_page_item"><a href="info.php" accesskey="1" title="">Currently Watching Info</a></li>
		</div>
	</div>
	<div id="main">
			 <div>
			 <h2>
          <?php 
            $name = $_GET['name'];
			echo $name;
          ?>
		  </h2>
		 </div>

		<div id="featured">
		
<?php
            include 'parse.php';
			include 'videoinfo.php';
			$vid = $_GET['show_id'];
			$link = latest('http://openapi.youku.com/v2/shows/videos.json?client_id=ce905694ae10ccab&show_id='.$vid);
			player($link);
?>


		


		</div>

	</div>
</div>
</body>
</html>