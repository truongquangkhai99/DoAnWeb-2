$().ready(function() {
	$("#formEditProfile").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"firstName": {
				required: true,
				minlength: 3
			},
			"lastName": {
				required: true,
				minlength: 3
			},
			"phone": {
				required: true,
				minlength: 9,
				maxlength: 13
				
			},
			"description": {
				required: true,
				maxlength: 200
				
			}

		},
		messages: {
			"firstName": {
				required: "Bắt buộc nhập username",
				minlength: "Hãy nhập tối đa 3 ký tự"
			},
			"lastName": {
				required: "Bắt buộc nhập password",
				minlength: "Hãy nhập ít nhất 3 ký tự"
			},
			"phone": {
				required: "Bắt buộc nhập phone",
				minlength: "Hãy nhập ít nhất 9 số",
				maxlength: "Hãy nhập nhiều nhất 11 số"
			},
			"description": {
				required: "Bắt buộc phải nhập Description",
				maxlength: "Hãy nhập ít nhất 200 ký tự"
			}
		}
	});
});

$(document).ready(function() {
		$('#submit').click(function() {
			var firstName=$('#firstName').val();
			var lastName=$('#lastName').val();
			var email=$('#email').val();
			var phone=$('#phone').val();
			var description=$('#description').val();
			$.ajax({
				url:"/WebContent/editprofile",
				type:"post",
				data:{
					firstName:firstName,
					lastName:lastName,
					email:email,
					phone:phone,
					description:description
				}
				
			}),
			$.ajax({
				url:"/WebContent/ViewContent",
				type:"get",
				data:{
					pageid:1
				}
				
			})
		})
	});