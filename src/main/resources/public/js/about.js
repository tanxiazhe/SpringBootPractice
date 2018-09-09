$(function() {

    $('#userInfo').click(function(e) {
		$("#userInfoList").delay(100).fadeIn(100);
		$(this).addClass('active');

		$("#changeUser-form").fadeOut(100);
		$('#changeUser').removeClass('active');
		$("#changePwd-form").fadeOut(100);		
		$('#changePwd').removeClass('active');
		
		e.preventDefault();
	});
	$('#changeUser').click(function(e) {
		$("#changeUser-form").delay(100).fadeIn(100);
		$(this).addClass('active');

 		$("#userInfoList").fadeOut(100);
		$('#userInfoList').removeClass('active');
		$("#changePwd-form").fadeOut(100);
		$('#changePwd').removeClass('active');
		
		e.preventDefault();
	});

	$('#changePwd').click(function(e) {
		$("#changePwd-form").delay(100).fadeIn(100);
		$(this).addClass('active');

 		$("#userInfoList").fadeOut(100);
		$('#userInfoList').removeClass('active');
		$("#changeUser-form").fadeOut(100);
		$('#changeUser').removeClass('active');
		
		e.preventDefault();
	});

});
