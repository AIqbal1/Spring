<!DOCTYPE HTML>

<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<link rel="stylesheet" href="resources/css/stylesheet.css" type="text/css" />
	<link href="resources/css/bootstrap.css" rel="stylesheet" media="screen">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	
	<title>PIT</title>
</head>
<body>		
	<br/>
	<form:form name="channelInfo" method="POST" modelAttribute="channelForm" > 
			<!-- use a button image -->
		<div class="container">
	
			<input type="submit" class="btn btn-large btn-block" name="Refresh" value="refresh"/>
			</p>
			</p>
			</p>
			</p>
			<h1 align="center">Channels</h1>
			
			<br/>		
			
			<form:errors path="*" cssClass="error">
				<div class="alert alert-block">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>Warning!</h4>
					<spring:message code="error.global" />
				</div>		
			</form:errors>
			
			<form:errors path="channelId" cssClass="error" />
	
				<div class="container-fluid">
				<div class="accordion" id="accordion2">		
						  				  
				  <c:forEach var="channel" items="${channelDataList}" >
				  
					  	<div class="accordion-group">
							<div class="accordion-heading">
							  <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#<c:out value="${channel.channelId}" />" >
								${channel.channelName}
							  </a>
							</div>
							<div id="#<c:out value="${channel.channelId}" />" class="accordion-body collapse">
							  <div class="accordion-inner">
							  	<div class="row-fluid">
							  		<div class="span4">
										<img src="resources/img/<c:out value="${channel.channelId}" />.jpg" class="img-polaroid" width=170 height=120 style="width:170px; height:120px" />
							  		</div>
							  		<div class="span4">
						      	  		<label>Table State:</label>				      	  		
							  			<input class="input-medium span3 uneditable-input" type="text" placeholder="<c:out value="${channel.tableState}" />" >
							  			<label>Game State:</label>
							  			<input class="input-medium span3 uneditable-input" type="text" placeholder="<c:out value="${channel.eventState}" />" >
							  		</div>
					        		<div class="span4" align="center">
					        			</p>
					        			<button  class="btn btn-large btn-primary" type="submit" value="${channel.channelId}">Open</button>
					        			</p>
										<button  class="btn btn-large" type="submit" name="pause" value="${channel.channelId}">Pause</button></td>
										<button  class="btn btn-large" type="submit" name="close" value="${channel.channelId}">Close</button ></td>
										<button  class="btn btn-large" type="submit" name="restart" value="${channel.channelId}">Restart</button></td>
					
									</div>
							  </div>
							</div>
						  </div>
						</div>
					
				   </c:forEach>		
				   		  
				</div>
			</div>	
					
    	</div>
    </form:form>
</body>
</html>