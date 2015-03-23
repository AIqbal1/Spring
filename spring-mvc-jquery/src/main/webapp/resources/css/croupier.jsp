<!DOCTYPE html>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
	  <meta charset="utf-8">	  
	  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	  <meta name="apple-mobile-web-app-capable" content="yes">
	  <meta name="apple-mobile-web-app-status-bar-style" content="black">
	  <title></title>
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.mobile-1.3.1.min.css">  
	  <!-- jQuery and jQuery Mobile -->
	  <script src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/jquery.mobile-1.3.1.min.js"></script>   
	  

	<script type="text/javascript">
			function doAjaxPost(name, id) {
				$.ajax({
					type: "POST",
					url: document.location.toString() + "?" + name + "=" + id,
					success: function(response) {
						jsonObj = jQuery.parseJSON(response);
						// we have the response
						if(response.status == "SUCCESS") {
							// do nothing..
							// check for no content... if there is content... replace iframe
							// $("#frameBody").attr('src', jsonObj.url);
							// $(""#frameBody").contents().find("html").html(response);
						}
						else {	
							// do nothing yet
						}
					 },
					 error: function(e){
						$("#errors").attr("style", "display:inline")
						$('#errors').html(e.responseText);
						window.setTimeout("fadeErrorsDiv();", 5000);
					 }
				});
			}		
			
			function fadeErrorsDiv() {
				$("#errors").fadeOut('slow');
			}
			
			/*		
			$(document).ready(function() {
				alert("ready");
				$.ajax({
					type: "GET",
					url: document.location.toString()+ "/dashboard",
					success: function(response) {
						alert(response);
						alert(response.status);												
						$("#frameBody").contents().find("html").html(response);
						// we have the response
						if(response.status == "SUCCESS") {
							
							alert(response);
							// do nothing..
							// check for no content... if there is content... replace iframe
							// $("#frameBody").attr('src', jsonObj.url);
							// $(""#frameBody").contents().find("html").html(response);
						}
						else {	
							// do nothing yet
						}
					 },
					 error: function(e){
						$("#errors").attr("style", "display:inline")
						$('#errors').html(e.responseText);
						window.setTimeout("fadeErrorsDiv();", 5000);
					 }
				});
			});
			*/
	</script>		  
	  
	</head>			
		
	<body>
		
		<div id="status">initialising...</div><br/>	
		<div id="content">
			<iframe name ="frameBody" id="frameBody" src="http://localhost:8585/test/croupier/dashboard"></iframe>
		</div>
				
	</body>

</html>