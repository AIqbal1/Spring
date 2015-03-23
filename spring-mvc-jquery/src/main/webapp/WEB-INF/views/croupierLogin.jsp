		    
				    
				    
				    <form:form method="POST" action="croupier/login.html">		            
		            	<input type="button" value="login" onclick="doAjaxPost(null, null)">
		        	</form:form>


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
