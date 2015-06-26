<?php

	/*
	* A class to hold project information.
	* variables: name, date, msg
	*/
	class Project
	{
			var $name;
			var $date;
			var $msg;

			function Project($name="",$date="",$msg="") 
			{
				$this->name = $name;
				$this->date = $date;
				$this->msg = $msg;
			}
			function name() 
			{
				return $this->name;
			}
			function date() 
			{
				return $this->date;
			}
			function msg() 
			{
				return $this->msg;
			}
	}



    $Projects = array();
    $name;
    $msg;
    $date;

	/*
	* A function to parse svn_log.xml
	* Store everything in an Array.
	*/
	function parseXML()
	{
		global $Projects, $name, $msg, $date;
             $xml = simplexml_load_file("svn_log.xml");
             foreach ($xml->logentry as $logentry)
             {
                $date = (string) $logentry->date;

                foreach ($logentry->paths->path as $path)
				{
					$content = (string) $path;
				  
				  	$startPos=strpos($content,"assignment");
					$length=13;
					$name=substr($content, $startPos ,$length);
					
				}
             	foreach ($logentry->msg as $msg)
              	{
              		
        			$mesage = (string) $msg;
    				$newProj = new Project($name,$date,$mesage);
    				array_push($Projects, $newProj);
    			}

   			 }
	}
	/*
	*A function to print out all the informations
	*/
	function printInfo($assignName)
	{
		global $Projects, $name, $msg, $date;
		
			for($i=0;$i<count($Projects);$i++)
			{
				$pName=$Projects[$i]->name;
				$pNameCompare=substr($pName, 0 , 11);
				if($pNameCompare==$assignName)
				{
					$pDate=$Projects[$i]->date;
					$pMesage=$Projects[$i]->msg;
					echo "<u>Name:</u> $pName";
					echo "<br>";
					echo "<u>Mesage:</u> $pMesage";
					echo "<br>";
					echo "<u>Date:</u> $pDate";
					echo "<br>";
					echo "<br>";
				}
			}
	}

	
?>