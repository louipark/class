<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<?php
error_reporting(E_ALL ^ E_NOTICE); 

//a function to get info from the api uri
function getinfo($u){
	$data = file_get_contents($u);
	return $info = (json_decode($data));
	
}

//parse the info and show 
function showinfo($u){
	$info = getinfo($u);
	
	//parse the img name with title name to get the img,
	//	the urls in json has restriction, only shows once, local img for now
	echo "<img src='".$info -> title . ".jpg'>";
	echo "<br>";
	
	//get average rating
	echo "Average Rating: ". $info -> rating -> average;
	echo "<br>";
	
	//country
	echo "Country: ". $info -> countries[0];
	echo "<br>";
	
	//director name
	echo "Director: ".$info->directors[0]->name;
	echo "<br>";
	
	//actors name
	echo "Casts: ".$info->casts[0]->name;
	echo ", ". $info->casts[1]->name;
	echo ", ". $info->casts[2]->name;
	echo ", ". $info->casts[3]->name;
	echo "<br>";
	
	//summary of the story
	echo "Summary: ". $info->summary;
	echo "<br>";
}

	function videoinfo($u){
	$info = getinfo($u);
	$n=1;
	foreach($info->videos as $video){
		echo "<a href=";
		echo $video->link;
		echo "> Episode".$n."</a>";
		echo "<br>";
		$n=$n+1;
		}
	}
	
	function latest($u){
	$info = getinfo($u);
	//$n=$info->total -1;
	$n= -1;
	foreach($info->videos as $video){
	$n=$n+1;
	}
	return $info->videos[$n]->id;

	}
?>