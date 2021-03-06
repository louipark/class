<?php

class parseListXML_test extends PHPUnit_Framework_TestCase
{
		public function testProject()
		{
			//Send the test file to see the output of the class
			$testFile="test.xml";
			$output=parseListXML($testFile);

	        // Assert
	        $WantedOutputSize;
    	    $this->assertEquals($WantedOutputSize, $output);

    	    // Assert
	        $WantedOutputName;
    	    $this->assertEquals($WantedOutputName, $output);
		}
		

		public function testFilter()
		{
			//Send the test file to see the output of the class
			$comment="fuck this";
			$output=parseListXML($comment);
	
			// Assert
			$WantedOutput="******* this";
			$this->assertEquals($WantedOutputSize, $output);
	
			// Assert
			$WantedOutputName;
			$this->assertEquals($WantedOutputName, $output);
		}
		
}



?>