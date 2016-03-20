<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/resources/js/json2.js"></script>
</head>
<body>

<h2>Sample</h2>

<div>
	<form id="form">
		<input name="user_id" value="1" />
		<input name="user_name" value="sample" />
		<input type="submit" value="submit" />
	</form>
</div>

<script type="text/javascript">
	$.fn.serializeObject = function(name) {
		var o = {};
		o[name] = {};
		
		$.each(this.serializeArray(), function() {
			if (o[name][this.name] !== undefined) {
				if (!o[name][this.name].push) {
					o[name][this.name] = [ o[name][this.name] ];
				}
				
				o[name][this.name].push(this.value || '');
			} else {
				o[name][this.name] = this.value || '';
			}
		});
		
		return o;
	};
	
	$.ajaxSetup({
		contentType: "application/json"
	});

	$("#form").submit(function(e) {
		e.preventDefault();

		var formData = $(this).serializeObject("user");
		$.post("http://localhost:8080/sample", JSON.stringify(formData))
		.done(function(data) {
			console.log(JSON.stringify(data));
		});
	});
</script>

</body>
</html>