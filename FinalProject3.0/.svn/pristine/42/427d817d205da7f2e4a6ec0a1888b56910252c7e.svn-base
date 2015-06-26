<?php
error_reporting(E_ALL ^ E_NOTICE); 

    // Connecting using PDO
	$db = new PDO('mysql:host=localhost;dbname=myblog', 'root', '');
	$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

	//check if the data got from post method is NULL
	if($_POST['name']!=NULL && $_POST['comment']!=NULL)
	{	
		//put data into data base 
		putDataInDB($db,$_POST['id'],$_POST['name'],$_POST['comment']);
	}
	
	showDataInDB($db);
	
	//Read data from MySQL
	function showDataInDB($db)
	{ 
   		foreach($db->query('SELECT * FROM movieinfo') as $row) 
   		{
   			echo  '<div class="commentBlog">';
			
			//set id as a $var
			$var1 = $row['id'];
			$var2 = $row['show_id'];
			//echo $var2;
			echo "<br>";
			//pass id into the info1 page
			echo '<a href=info1.php?id='.$var1.'&show_id='.$var2.'>';
			
			//show titles and days
    		echo $row['title'].' '.': '.' '.$row['Comment'];
			echo '</a>';
    		echo  "</div>";
			echo "<br>";
			
    	}
	}
	
	//Protected against SQL Injection Attacks by Parameterized Query 
	//from https://zh.wikipedia.org/wiki/%E5%8F%83%E6%95%B8%E5%8C%96%E6%9F%A5%E8%A9%A2
	function putDataInDB($db,$id, $title,$Comment)
	{
		$stmt = $db->prepare("INSERT INTO movieinfo (id,title,Comment) VALUES(:id,:title,:Comment)");
		$stmt->execute(array(':id'=>$id, ':title' => $title, ':Comment' => $Comment));
	}



?>