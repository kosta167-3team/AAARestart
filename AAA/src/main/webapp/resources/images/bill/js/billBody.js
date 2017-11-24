/**
 * 
 */

var state = 0;
var detailState = 0;

	$(function() {		
		var tableCount = 0;
		function initTable(){
			$("#payment_details_table").find("tr").find('td:eq(3)').each(function(){
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
		}
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
						$("#detail_content").css('left',(point.left-100)+"px");
						detailState = 1;						
					}
				});
			}
			else{
				$("#detail_content").css('display','none');
				detailState = 0;
			}
			
			
			
			
			
		});
		
		
		
		$("#select_month_btn").on("click", function(event) {
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
