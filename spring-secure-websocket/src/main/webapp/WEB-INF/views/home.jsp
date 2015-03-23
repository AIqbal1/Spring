<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.10.1.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-ui.min.js"></script>	
	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div class='statusMessage' id='status'>initialising...</div>
</body>

<script type="text/javascript">
        var ws;

        $(document).ready(function () {
			var ourProtocol='wss://';
			var ourPort=':'+8585;
			var ourResource='/websocket';
			var location = ourProtocol+document.location.hostname+ourPort+ourResource;
            
			ws = new WebSocket(location);
            ws.onopen = function(event) { 
            	$('#status').text("we are open!!"); 
            };			
			ws.onclose = function(event) { 
				$('#status').text("The connection is closed"); 
			};
			
			ws.onmessage = function(event) { 
				var result = jQuery.parseJSON(event.data);
				alert(result);
			};
        });
        
        
</script>


</html>
