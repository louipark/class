<!DOCTYPE HTML>
<html>

<head>
  <title>Comments</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.html">Portfolio <span class="logo_colour">Luying Zhou</span></a></h1>
          <h2>CS 242: Programming Studio </h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li><a href="index.html">Home</a></li>
          <li><a href="Assignment0.php">Assignment0</a></li>
          <li><a href="Assignment1.php">Assignment1</a></li>
          <li><a href="Assignment2.php">Assignment2</a></li>
		  <li><a href="FinalP.php">Final Project</a></li>
          <li class="selected"><a href="comments.php">Comments</a></li>

        </ul>
      </div>
    </div>
    <div id="site_content">
	  <div id="content">
        <h1><b>Comment Board</b></h1>
      </div>
    </div>	
    <div id="site_content">
      <div id="content">
          <div>
          <?php 
            include 'SQL.php';
          ?>
          </div>
	  </div>
	 </div>
	<div id="site_content">
	       <div id="content">
          <form  action="comments.php" method="post">
            Name:
            <input class="submitName" type="text" name="name"><br><br>
            Write your Comment:
            <input  class="submitField" type="text" name="comment"><br>
            <input type="submit" value="Submit">
          </form>
        </div>
	</div>
    <div id="footer">
    </div>

</body>
</html>