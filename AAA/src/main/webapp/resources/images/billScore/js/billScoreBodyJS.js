/**
 * 
 */

$(function(){
	
	startBody();
	setBillGrade();
	
	
	function setBillGrade(){
		
		var getElec = 'elec';
		var getHeat = 'heat';
		var getInputNum = $("#pme_input_num").val();
		console.log("getElec : " + getElec + " getHeat : " + getHeat + " getInputNum : " + getInputNum);
		// getElecGrade Ajax
		$.ajax({
			type : 'GET',
			url : "/billScoreRest/setScoreBill/" + getElec + '/' + getInputNum,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'text',
			success : function(result) {
				var elecHtml = "";
				$("#elecTableTD").html(result);
				
				// getHeat Grade Ajax
				$.ajax({
					type : 'GET',
					url : "/billScoreRest/setScoreBill/" + getHeat + '/' + getInputNum,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "GET"
					},
					dataType : 'text',
					success : function(result) {
						var heatHtml = "";
						heatHtml += "<a href='/billScoreRest/heat/allGrade'>" + result + "</a>";
						$("#heatTableTD").html(heatHtml);
					}
					/*heat callback function end*/
				});
				//////heat Jquery ajax end//////////

			}
			/*elec callback function end*/
				
			});
		////////elec Jquery ajax end////////////
		};
	/* function end */
	
	function startBody(){
		var avgElec;
		var avgHeat;
		var count = 0;
		$.ajax({
			type : 'GET',
			url : "/billScoreRest/AverageEnergy",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET"
			},
			dataType : 'json',
			success : function(result) {
				avgElec = result.elec;
				avgWater = result.water;
				avgFever = result.fever;
				
				$.each($("#energyValueTable").find("tr").find("td:gt(0)"),function(){
					var intNum = parseInt($(this).html());
					
					if( count <5){

						if( intNum > avgElec){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}
					else if ( count >4&&count < 10){

						if( intNum > avgWater){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}
					else if (count > 9 && count < 15){
						if( intNum > avgFever){
							$(this).css({"color" : "red"});
							count += 1;
						}
						else{
							$(this).css({"color" : "blue"});
							count += 1;
						}
						if( count == 15){
							count = 0;						
						}
						
					}
				});				
			}
		});		
	}	
});