<?php
include parse.php;

	class parseListXML_test extends PHPUnit_Framework_TestCase
{
 	public function testvideoinfo(){
		$u = "http://openapi.youku.com/v2/shows/videos.json?client_id=ce905694ae10ccab&show_id=z0375f6ec568a11e4a080";
		//videoinfo($u); 
		assertEqual("ssss",videoinfo($u));
	}

}
?>