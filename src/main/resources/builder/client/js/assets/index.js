$(function(){
	var user=JSON.parse(getUser());
	$("#userName").html(user.username);
	console.log(user.username);
	$("#jifen").html("积分："+user.integration);
})