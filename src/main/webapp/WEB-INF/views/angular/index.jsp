<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" ng-app="myApp">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css">
<script type="text/javascript" src="/resources/js/angular/angular.min.js"></script>
<script type="text/javascript">
	var angApp = angular.module('myApp', []);
	angApp.controller('myCtl', function($scope) {
		$scope.user = {
			"name": "Donguk",
			"gender": "Male"
		};
	});
</script>
</head>
<body>

<div ng-controller="myCtl">
<p>Name: {{user.name}}</p>
<p>Name: {{user.gender}}</p>
</div>

<input type="text" ng-model="yourName"><p>안녕하세요. {{yourName}}</p>

</body>
</html>