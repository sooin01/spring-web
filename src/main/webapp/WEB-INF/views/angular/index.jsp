<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" ng-app="phonecatApp">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css">
<script type="text/javascript" src="/resources/js/angular/angular.min.js"></script>
<script type="text/javascript">
	var phonecatApp = angular.module('phonecatApp', []);
	phonecatApp.controller('PhoneListCtrl', function($scope) {
		$scope.phones = [
			{
				'name' : 'Nexus S',
				'snippet' : 'Fast just got faster with Nexus S.'
			}, {
				'name' : 'Motorola XOOM™ with Wi-Fi',
				'snippet' : 'The Next, Next Generation tablet.'
			}, {
				'name' : 'MOTOROLA XOOM™',
				'snippet' : 'The Next, Next Generation tablet.'
			}
		];
	});
</script>
</head>
<body ng-controller="PhoneListCtrl">
<div>
	<ul>
		<li ng-repeat="phone in phones">
			<span>{{phone.name}}</span>
			<p>{{phone.snippet}}</p>
		</li>
	</ul>
</div>
<div>
	<table>
		<tr>
			<th>row number</th>
		</tr>
		<tr ng-repeat="i in [0, 1, 2, 3, 4, 5, 6, 7]">
			<td>{{i}}</td>
		</tr>
	</table>
</div>

</body>
</html>