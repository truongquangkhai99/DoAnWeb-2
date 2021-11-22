$("#formEditProfile").validate({
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
