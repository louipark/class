<?php
error_reporting(E_ALL ^ E_NOTICE); 

    // Connecting using PDO
	$db = new PDO('mysql:host=localhost;dbname=myblog;charset=utf8', 'root', '');
	$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);


	if($_POST['name']!=NULL && $_POST['comment']!=NULL)
	{
		$comment_=FilterComments($_POST['comment']);		
		putDataInDB($db,$_POST['name'],$comment_);
	}

	showDataInDB($db);
	
	//Read data from MySQL
	function showDataInDB($db)
	{
   		foreach($db->query('SELECT * FROM BlogComments') as $row) 
   		{
   			echo  '<div class="commentBlog">';
    		echo $row['Name'].' '.': '.' '.$row['Comment'];
    		echo  "</div>";
			echo "<br>";
    	}
	}
	
	
	//Protected against SQL Injection Attacks by Parameterized Query 
	//from https://zh.wikipedia.org/wiki/%E5%8F%83%E6%95%B8%E5%8C%96%E6%9F%A5%E8%A9%A2
	function putDataInDB($db,$Name,$Comment)
	{
		$stmt = $db->prepare("INSERT INTO BlogComments (Name,Comment) VALUES(:Name,:Comment)");
		$stmt->execute(array(':Name' => $Name, ':Comment' => $Comment));
	}

	function FilterComments($comment)
	{
		$FilterArray = array("fuck","bitch","dick","asshole","shit");

		$filteredComment = $comment;
		$filteredComment=str_replace($FilterArray,"*******",$comment);		
		return $filteredComment;
	}	

?>