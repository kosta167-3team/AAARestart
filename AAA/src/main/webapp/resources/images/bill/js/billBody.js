/**
 * 
 */

var state = 0;
var detailState = 0;
var a = [1,2,3];
var list = [
	"일반 관리비", "청소비", "소독비", "승강기 유지비", "수선유지비", "장기 수선 충당금", "건물 보험료", "경비비", "관리 수수료", "세대전기료", "공동전기료",
	"TV 수신료","세대수도료","세대 급탕비","생활 폐기물수거","입대위운영비","선관위 운영비","기본 난방비","공동 난방비","기타 난방비","세대 가스비","공동 가스비","세대 난방비"
];
var EngList = [ "general_mgmt", "clean", "fumigate", "elevator_maintain", "repair",
	"long_term_repair", "building_insurance", "security", "consignment", "personal_elec", "public_elec", "tv",
	"personal_water", "personal_heat_water", "trash_pick_up", "resident_repre", "emc","basic_heat","public_heat","etc_heat",
	"personal_gas","public_gas","personal_heat"

];


	$(function() {		
		var tableCount = 0;
		function initTable(){
			$("#selectDetailTable").find("tr").find('td:eq(3)').each(function(){
				if(  parseInt($(this).html()) > 0 && tableCount > 0){
					$(this).html(function(i,orgText){
						return "<img src = '/resources/images/bill/img/icon_up.png'>" + orgText;
					}).css({
						"color" : "red"
					});
				}
				else if(parseInt($(this).html()) < 0 && tableCount > 0){
					$(this).html(function(i,orgText){
						return "<img src = '/resources/images/bill/img/icon_down(1).png'>" + orgText;
						
					}).css({
						"color" : "blue"
					});				
				}
				tableCount++;
			});
		};
		function initDetailTable(){
			console.log('ha');
			$("#selectDetailTable").find("tr").find('td:eq(1)').each(function(){
				
				if(  parseInt($(this).html()) > 0){
					console.log($(this).html);
					$(this).html(function(i,orgText){
						return "<img src = '/resources/images/bill/img/icon_up.png'>" + orgText;
					}).css({
						"color" : "red"
					});
				}
				else if(parseInt($(this).html()) < 0 ){
					$(this).html(function(i,orgText){
						return "<img src = '/resources/images/bill/img/icon_down(1).png'>" + orgText;
						
					}).css({
						"color" : "blue"
					});				
				}
				tableCount++;
			});
		};
	
		initTable();
		
		
		$("#payment_detail").on("click",function(){
			event.preventDefault();
			var point = $(this).offset();
			var p_month = $(this).attr("value");
			var u_id = $(this).attr("data-rno");
			var month = $("#p_month").attr("data-rno");
			
			if(detailState == 0){
				$.ajax({
					type : 'GET',
					url : "/billRest/selectMonthDetail/" + p_month + "/" + u_id,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "GET"
					},
					dataType : 'json',
					success : function(result) {
						var htm = "<table id='table_payment'>";					
						htm += "<tr class = 'table_title'>"+
									"<td> "+month+"월 분 부과금액</td>"+
									"<td> "+result.bill +"</td>"+
								"<tr>"+
									"<td> 할인 총계 </td>"+
									"<td>"+ result.saleBill+"</td>"+
								"</tr>"+
								"<tr>"+
									"<td> 미납액 </td>"+
									"<td>"+ result.outsideing+"</td>"+
								"</tr>"								
								;
						htm += "</table>";
						$("#detail_content").html(htm);
						$("#detail_content").css('display','block');
						console.log( point.left + " : " + point.top);						
						$("#detail_content").css('top',(point.top+29)+"px");
						$("#detail_content").css('left',(point.left)+"px");
						detailState = 1;						
					}
				});
			}
			else{
				$("#detail_content").css('display','none');
				detailState = 0;
			}
			
			
			
			
			
		});
		
		$(".selectDetail").on("click",function(event){
			event.preventDefault();
			var detailName = $(this).attr("data-rno");
			var choiseNum = 0;
			var point = $(this).offset();
			var engDetailName;
			for( var i = 0; i < list.length; i++){
				if( list[i] == detailName){
					
					choiseNum = i
					console.log(list[i] + " : " + EngList[i] + " : " + choiseNum);
				}
			}
			engDetailName = EngList[choiseNum];
			console.log(engDetailName );
			if(detailState == 0){
			$.ajax({
				type : 'GET',
				url : "/billRest/SelectDetail/" + $(this).attr("data-rno1") + "/" + $(this).attr("data-rno"),
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "GET"
				},
				dataType : 'json',
				success : function(result) {					
					var htm ="";
					htm += "<table id='selectDetailTable'>";
					htm += "<tr class = 'table_title'>";
					htm += "<td>날짜 </td>";
					htm += "<td>우리집 </td>";
					
					htm += "</tr>";
					$.each(result,function(index,data){
						
						htm += "<tr><td>" +data.p_month+  "</td> <td>"+ data[engDetailName] +"</td></tr>";											
					});
					htm += "</table>";
					
					$("#selectDetailDiv").html(htm);
					$("#selectDetailDiv").css('display','block');
					$("#selectDetailDiv").css('top',(point.top+29)+"px");
					$("#selectDetailDiv").css('left',(point.left)+"px");
					/*initDetailTable();*/
					detailState = 1;
				}
				
				
			});
			}
			else{
				$("#selectDetailDiv").css('display','none');
				detailState = 0;
			}
			
		});
		
		
		
		$("#select_month_btn").on("click", function(event) {
			var detailState = 0;
			event.preventDefault();
			var point = $("#select_month_content").offset();
			if( state == 0 ){
				$.ajax({
					type : 'GET',
					url : "/billRest/selectMonth/" + $(this).attr("data-rno"),
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "GET"
					},
					dataType : 'json',
					success : function(result) {
						var htm = "<ul>";
						
						htm += "<li><a href=/bill/full-width/"+result.select0 + ">" +result.select0 + "</a></li>";
						htm += "<li><a href=/bill/full-width/"+result.select1 + ">" +result.select1 + "</a></li>";
						htm += "<li><a href=/bill/full-width/"+result.select2 + ">" +result.select2 + "</a></li>";
						htm += "<li><a href=/bill/full-width/"+result.select3 + ">" +result.select3 + "</a></li>";
						htm += "</ul>";
						$("#month_list").html(htm);
						$("#detail_content_month").html(htm);
						$("#month_list").css('display','block');
						console.log( point.left + " : " + point.top);
						$("#month_list").css('left',(point.left-100)+"px");
						$("#month_list").css('top',(point.top+30)+"px");

						state = 1;						
					}
				});
			}
			else{
				$("#month_list").css('display','none');
				state = 0;
			}
			
		});
	});
