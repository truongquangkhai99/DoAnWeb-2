$().ready(function() {
	$("#formEditProfile").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"firstName": {
				required: true,
				maxlength: 15
			},
			"lastName": {
				required: true,
				minlength: 8
			},
			"phone": {
				
				minlength: 8
				
			}
		},
		messages: {
			"firstName": {
				required: "Bắt buộc nhập username",
				maxlength: "Hãy nhập tối đa 15 ký tự"
			},
			"lastName": {
				required: "Bắt buộc nhập password",
				minlength: "Hãy nhập ít nhất 8 ký tự"
			},
			"phone": {
				
				minlength: "Hãy nhập ít nhất 8 ký tự"
			}
		}
	});
});


















$("#213formEditProfile").validate({
	rules:{ 
		firstName:"required",
		lastName:"required",
		phone :{
			required:true,
			minlength:9,
			maxlength:11
		},
		description:"required"
	},
	messages:{
		firstName:"Please enter your firstname",
		lastName:"Please enter your lastname",
		phone :{
			required:"please enter your phone number",
			minlength:"Your password must be at least 9 characters long",
			maxlength:"Your password must be at most 11 characters long"
		},
		description:""
	},
	submitHandler:function(form){
		form.submit();
	}
});
