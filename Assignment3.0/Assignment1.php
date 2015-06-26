<!DOCTYPE HTML>
<html>

<head>
  <title>Assignment1</title>
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <h1><a href="index.html">Portfolio <span class="logo_colour">LuyingZhou's</span></a></h1>
          <h2>CS 242: Programming Studio </h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <li><a href="index.html">Home</a></li>
          <li><a href="Assignment0.php">Assignment0</a></li>
		  <li class="selected"><a href="Assignment1.php">Assignment1</a></li>
          <li><a href="Assignment2.php">Assignment2</a></li>
		  <li><a href="FinalP.php">Final Project</a></li>
        </ul>
      </div>
    </div>
    <div id="site_content">
      <div id="content">
        <!-- insert the page content here -->
        <?php 
          echo "<h1><b>Projects</b></h1>";
          include 'ParseLog.php';
          parseXML();
		  printInfo("Chess");
          printInfo("assignment1");

          //Print files info
          echo "<h1><b>Files</b></h1>";
          include 'ParseList.php';
          parseListXML();
		  printFileInfo("Chess");
          printFileInfo("assignment1.1");
          printFileInfo("assignment1.2");
        ?>
      
      </div>
    </div>
    <div id="footer">
    </div>
  </div>
</body>
</html>