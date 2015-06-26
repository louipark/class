<?php
error_reporting(E_ALL ^ E_NOTICE); 
date_default_timezone_set('America/Chicago');
    // Connecting using PDO
	$db = new PDO('mysql:host=localhost;dbname=myblog', 'root', '');
	$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	
		function showtoday($db)
	{
   		foreach($db->query('SELECT * FROM movieinfo') as $row) 
   		{	//check if the update days match today
   			if (strpos($row['Comment'],date("l")) !== false){
			echo $row['title'];
			$var1 = $row['title'];
			$var2 = $row['show_id'];
			echo "<a href= video.php?name=".$var1."&show_id=".$var2.">";
			echo "<img src='play.png' width='24' height='24'>";
			echo "</a>";
			echo "<br>";
			}
		
    	}
	}
	
	showtoday($db);



?>