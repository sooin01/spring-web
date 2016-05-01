<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko" ng-app="Angello">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/js/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/js/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script type="text/javascript" src="/resources/js/jquery/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/angular/angular.min.js"></script>
<script type="text/javascript" src="/resources/js/json2.js"></script>
<script type="text/javascript">
	var myModule = angular.module('Angello', []);
	// 공통 기능
	myModule.factory('AngelloHelper', function() {
		
	});
	// 
	myModule.service('AngelloModel', function() {
		var service = this;
		
		var stories = [
			{
				title: '첫 번째 스토리',
				description: '첫 번째 사용자 스토리'
			},
			{
				title: '두 번째 스토리',
				description: '두 번째 사용자 스토리'
			},
			{
				title: '세 번째 스토리',
				description: '세 번째 사용자 스토리'
			}
		];
		
		service.getStories = function() {
			return stories;
		}
	});
	myModule.controller('MainCtrl', function(AngelloModel) {
		var main = this;
		
		main.stories = AngelloModel.getStories();
		
		main.setCurrentStory = function(story) {
			alert(JSON.stringify(story));
		};
		
		main.createStory = function() {
			main.stories.push({
				title: '새 스토리',
				description: '새 사용자 스토리'
			});
		};
	});
	/* myModule.directive('', function() {
		
	}); */
</script>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>AngularJS Test</h1>
			<p>Resize this responsive page to see the effect!</p>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<h3>Column 1</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>Column 2</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>Column 3</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
		</div>
	</div>
	
	<div class="container" ng-controller="MainCtrl as main">
		<h2>Sories</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="story in main.stories" ng-click="main.setCurrentStory(story)">
					<td>{{story.title}}</td>
					<td>{{story.description}}</td>
					<td>john@example.com</td>
				</tr>
			</tbody>
		</table>
		<div>
			<a ng-click="main.createStory()">추가</a>
		</div>
	</div>

</body>
</html>