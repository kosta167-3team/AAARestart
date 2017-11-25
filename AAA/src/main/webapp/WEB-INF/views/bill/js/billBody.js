/**
 * 
 */

$(function(){
	$("#select_month_btn").on("click",function(event){
		event.preventDefault();
		console.log("ha");
		$.ajax({
			type : 'GET',
			url : "/billRest/selectMonth/${billMonth.p_month }",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'json',
			
			success : function(result) {
				
				console.log(result.select0);
				
			}
		});	
	});
});
