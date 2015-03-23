<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title></title>
  <link rel="stylesheet" href="../resources/css/jquery.mobile-1.3.1.min.css">  
  <!-- jQuery and jQuery Mobile -->
  <script src="../resources/js/jquery-1.9.1.min.js"></script>
  <script src="../resources/js/1.3.1/jquery.mobile-1.3.1.min.js"></script>   
</head>
<body>
<!-- Home -->
<div data-role="page" id="page1">
    <div data-theme="a" data-role="header">
        <h3>
            Croupier Console
        </h3>
    </div>
    <div data-role="content">
        <form action="">
	        <div data-role="fieldcontain">
	            <label for="textinput4">
	                Winning Number
	            </label>
	            <input name="" id="textinput4" placeholder="" value="" type="tel">
	        </div>
	        <input type="submit" value="Confirm">
	        <input type="submit" value="Dispute">
	        <div data-role="fieldcontain">
	            <label for="textarea2">
	                Game State
	            </label>
	            <textarea name="" id="textarea2" placeholder=""></textarea>
	        </div>
	        <input type="submit" value="Log Out">
	    </form>
    </div>
    <div data-theme="a" data-role="footer" data-position="fixed">
        <h3>
            Footer
        </h3>
    </div>
</div>
</body>
</html>