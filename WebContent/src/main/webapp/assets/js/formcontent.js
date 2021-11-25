$().ready(function() {
	$("#addContent").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"title": {
				required: true
			},
			"brief": {
				required: true
			},
			"content": {
				required: true
				
			}

		},
		messages: {
			"title": {
				required: "Bắt buộc nhập title",
			},
			"brief": {
				required: "Bắt buộc nhập brief",

			},
			"content": {
				required: "Bắt buộc nhập content",
			}
			
		}
	});
});

