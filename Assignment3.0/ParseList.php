<?php


	/*
	* A class to hold all the files' information
	*/
	class File
	{
			var $name;
			var $size;
			var $revision;
			var $kind;

			function File($name="",$size="", $kind="",$revision="") 
			{
				$this->name = $name;
				$this->size = $size;
				$this->kind = $kind;
				$this->revision = $revision;
			}
			function name() 
			{
				return $this->name;
			}
			function size() 
			{
				return $this->size;
			}
			function kind() 
			{
				return $this->kind;
			}
			function revision() 
			{
				return $this->revision;
			}

	}


    $Files  = array();
    $name;
    $size;
    $path;
    $revision;
    $kind;
	/*
	*A function to parse svn_list.xml in to an Array
	*/
	function parseListXML()
	{
		global $Files , $name, $size, $path, $revision, $kind;
            $xml = simplexml_load_file("svn_list.xml");
            $path = $xml->list['path'];
			foreach ($xml->list->entry as $entry)
			{
				$kind = $entry['kind'];
				foreach ($entry->name as $Name)
				{
					$name = (string) $Name;
				}
				foreach ($entry->size as $Size)
				{
					$size = (string) $Size;
				}
				foreach ($entry->commit as $Revision)
				{
					$revision = $Revision['revision'];
					$newFile = new File($name,$size,$kind,$revision);
					array_push($Files , $newFile);
				} 			
			}

   			  
	}
	
	/*
	* A function to print everything out.
	*/
	function printFileInfo($AssignName)
	{
		global $Files , $name, $size, $path, $revision, $kind;
			echo"<u>Browser Path:</u> $path";
			echo "<br>";
			echo "<br>";
			for($i=0;$i<count($Files );$i++)
			{
				$pName=$Files [$i]->name;
				$pos = strpos($pName, $AssignName);

				if ($pos !== false) {
					$pSize=$Files [$i]->size;
					$pKind=$Files [$i]->kind;
					$pRevision=$Files [$i]->revision;
					echo "<u>Path:</u> $pName";
					echo "<br>";
					echo "<u>Size:</u> $pSize";
					echo "<br>";
					echo "<u>Kind:</u> $pKind";
					echo "<br>";
					echo "<u>Revision:</u> $pRevision";
					echo "<br>";
					echo "<br>";
				} else {
					//Nothing to display
				}
			}
	}

?>