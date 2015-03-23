<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>jQuery File Upload Example</title>
</head>
<body>
<input id="fileupload" type="file" name="files[]" data-url="" multiple>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="../test/resources/js/vendor/jquery.ui.widget.js"></script>
<script src="../test/resources/js/jquery.iframe-transport.js"></script>
<script src="../test/resources/js/jquery.fileupload.js"></script>
<script>
$(function () {
    $('#fileupload').fileupload({
    	url: parent.document.location.toString() + "?fileupload=true",	
    	type: "POST",
        done: function (e, data) {
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo(document.body);
            });
        }
    });
});
</script>
</body> 
</html>
