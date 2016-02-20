<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/resources/js/websocket/sockjs-1.0.3.min.js"></script>
<script type="text/javascript" src="/resources/js/websocket/stomp.min.js"></script>

<script type="text/javascript">
	var sock = new SockJS('http://localhost:8080/websocket');
	sock.onopen = function() {
		$('#console').append('websocket opened' + '<br>');
	};
	sock.onmessage = function(message) {
		$('#console').append('receive message : ' + message.data + '<br>');
	};
	sock.onclose = function(event) {
		$('#console').append('websocket closed : ' + event);
	};
	
	function messageSend() {
		sock.send($('#message').val());
	}
	
	var socket = new SockJS('http://localhost:8080/stomp');
	var stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
	    $('#console2').append('Connected: ' + frame + '<br>');
	    stompClient.subscribe('http://localhost:8080/topic/stomp', function(message) {
	        $('#console2').append(message.body + '<br>');
	    });
	});

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        $('#console2').append('Disconnected<br>');
    }
    
    function messageSend2() {
        stompClient.send("/app/stomp", {}, $('#message2').val());
    }
</script>
</head>
<body>

<input type="text" id="message" />
<input type="button" value="전송" onclick="messageSend();" />
<div id="console">
# console<br>
</div>

<hr>

<input type="text" id="message2" />
<input type="button" value="전송" onclick="messageSend2();" />
<div id="console2">
# console2<br>
</div>

</body>
</html>