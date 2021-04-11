$(document).ready(function() {

	$("#submitBtn").click(function() {
		console.log("on");
		var values = $("input[name='question[]']")
        .map(function(){return $(this).val();}).get();
		
		
		let arr = [];
		let count = 1;
		for(let x of values){
			let question = {
				"id":count,
				"answer":x,
			};
			
			count++;
			arr.push(question);
		}
		
		let question = {
				answers:arr
		}
		
		$.ajax({
    		type: "POST",
    		contentType: "application/json",
    		url: "http://localhost:8082/answeredQuestion",
    		dataType: "json",	
    		data: JSON.stringify(question),	
    		cache: false,
    		//present the response in the html content dynamically 
    		success: function(result){
    				 console.log();
    				 $("#percent").replaceWith( "<h3>"+result["percent"]+"<h3/>" );
    		},
    		error: function(e){
    			alert("Error!");
    			console.log("ERROR: ", e);
    	}
    });

    });

});