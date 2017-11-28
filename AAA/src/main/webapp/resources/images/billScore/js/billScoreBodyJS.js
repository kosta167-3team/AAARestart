/**
 * 
 */

$(function(){
	
	startBody();
	setBillScore();
	
	function setBillScore(){
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
				
				console.log(avgElec + " : " + avgWater + " : " + avgFever);
				
				$.each($("#energyValueTable").find("tr").find("td:gt(0)"),function(){
					var intNum = parseInt($(this).html());
					
					if( count <5){
						console.log(avgElec + " : " + intNum);
						if( intNum > avgElec){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}
					else if ( count >4&&count < 10){
						console.log(avgWater + " : " + intNum);
						if( intNum > avgWater){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}
					else if (count > 9 && count < 15){
						console.log(avgFever + " : " + intNum);
						if( intNum > avgFever){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}else {
						count = 0;
					}
						

				});
				
			}
		});
	};
	
	
	
	
	
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
				
				console.log(avgElec + " : " + avgWater + " : " + avgFever);
				
				$.each($("#energyValueTable").find("tr").find("td:gt(0)"),function(){
					var intNum = parseInt($(this).html());
					
					if( count <5){
						console.log(avgElec + " : " + intNum);
						if( intNum > avgElec){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}
					else if ( count >4&&count < 10){
						console.log(avgWater + " : " + intNum);
						if( intNum > avgWater){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}
					else if (count > 9 && count < 15){
						console.log(avgFever + " : " + intNum);
						if( intNum > avgFever){
							$(this).css({"color" : "red"});
						}
						else{
							$(this).css({"color" : "blue"});
						}
						count += 1;
					}else {
						count = 0;
					}
						

				});
				
			}
		});
		
	}
	
});