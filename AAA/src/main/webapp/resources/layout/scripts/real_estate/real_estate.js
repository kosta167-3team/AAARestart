var area = 34;
var chart_tartget;
var table_target;
var tab_id;
var aptName ;

$(function() {
	var id = $('.in').attr('id');
	getarea();

	$('.tab').on('click', function(event) {
		
		$('li').removeClass('active');
		$(this).parent().addClass('active');
		event.preventDefault();
		
		href = $(this).attr('href');
		
		$('.tab-pane').removeClass('in active');
		$(href).addClass('in active');
		
		tab_id = $('.in').attr('id');
		draws(tab_id);
		
		getarea();
		
	})
	
	
});


$(function() {
	
	
	tab_id = $('.in').attr('id');
	console.log(tab_id);
	chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
	table_target =  $('#' + tab_id).find('.real_estateData').find('tbody');
	
	draws(tab_id);
	//check_tabId();
});


//평수 선택
$(function() {
	$('.dropdown-menu').on('click', 'a', function() {
		event.preventDefault();
		area = $(this).attr('href');
		
		alert('ddd');
		var html = $(this).text() + '<span class="caret"></span>';
		$(this).parent().parent().prev().html(html);
		
		draws(tab_id,area);
		
		
	});
})


function getarea() {
	console.log('ddddd');
	var div = $('.in').find('.dropdown-menu');
	div.empty();
	$.ajax({
		type : 'get',
		url : '/real_estate/rest/area_list',
		dataType : 'json',
		success : function(data) {
			
			var html = "";
			
			$(data).each(
					function(index, item) {
						// console.log(item);
						html += '<li class="area List"><a href="' + item + '">'
						+ item + " ㎡" + '</a></li>';
						
					});
			
			div.append(html);
			
		}
	
	});
	
	
}



function draws(tab_id,area){
	var url;
	if(tab_id === 'tab1primary'){
		console.log('면적별 시세 조회');
		chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
		drawLastMonth(chart_tartget);
		
		table_target =  $('#' + tab_id).find('.real_estateData').find('tbody');
		url ='/real_estate/rest/getmonthlyList';
		showTable(table_target,url);
	}
	else if(tab_id === 'tab2primary'){
		console.log('면적별 시세 추이');
		
		chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
		console.log(chart_tartget);
		if( $('.type_select').attr('href') == 'rent'){
			drawAnnualRentChart(chart_tartget);
			
		}else if($('.type_select').attr('href') == 'trade'){
			drawAnnualTradeChart(chart_tartget);
		}
		console.log(tab_id);
		table_target =  $('#' + tab_id).find('.real_estateData').find('tbody');
		console.log(table_target);
		url='/real_estate/rest/getAnnualList';
		showTable(table_target,url);
		
	}else if(tab_id === 'tab3primary'){
		
	}
	
}
/**************************************** tab1 *********************************************/

function showTable(table_target,url){
	var html="";
	$(table_target).empty();
	$.ajax({
		type:'post',
		url:url,
		dataType:'json',
		data:JSON.stringify({
			rent_area : area
		}),
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		success:function(data){
			
			
			$(data).each(function(index,item){
				
				console.log(item);
				
				aptName = item.kaptname;
				html += '<tr>';
				
				if(url =='/real_estate/rest/getmonthlyList'){
					
					html += '<td class="area">'+item.area+'㎡'+'</td>';
				}else{
					if(item.trade_month != 0){
						html += '<td class="area">'+item.trade_year +'.' +item.trade_month +'</td>';
					}else{
						html += '<td class="area">'+item.rent_year +'.' +item.rent_month +'</td>';
					}
				}
				
				if(item.rent_max == null){
					html += '<td class="max">'+'-'+'</td>';
					html += '<td class="min">'+'-'+'</td>';
				}else{
					html += '<td class="max">'+item.rent_max+'</td>';					
					html += '<td class="min">'+item.rent_min+'</td>';
				}
				
				if(item.trade_max == null){
					html += '<td class="max">'+'-'+'</td>';
					html += '<td class="min">'+'-'+'</td>';
				}else{
					html += '<td class="max">'+item.trade_max+'</td>';					
					html += '<td class="min">'+item.trade_min+'</td>';
				}
				
				html+= '</tr>';
			})
			
			console.log(html);
			$('#apart_title').find('h1').text(aptName);
			$(table_target).append(html);
		}
	})
}



function drawLastMonth(chart_tartget) {

	var width = $(chart_tartget).parent().parent().css('width');
	width = parseInt(width);
	console.log(width);
	
	width = width * 0.8 ;
	console.log(width);
	
	$.ajax({
		url : '/real_estate/rest/lastMonth',
		type : 'post',
		async : false,
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		data : JSON.stringify({
			rent_area : area
		}),
		dataType : 'json',
		success : function(vo) {

			google.charts.load("current", {
				packages : [ 'corechart' ]
			});
			google.charts.setOnLoadCallback(drawChart);
			function drawChart() {
				var options = {
					/*
					 * title:
					 * "${lastMonthRent.a_name}의\n${lastMonthRent.rr_year}
					 * 년 ${lastMonthRent.rr_month}월시세 (㎡)",
					 */
					width : width,
					height : 350,
					bar : {
						groupWidth : '40%'
					},
					legend : {
						position : "none"
					},
					animation : {
						duration : 1000,
						easing : 'out',
					},
					
				};

				var dataChart = [ [ "Element", "가격", {
					role : "style"
				} ] ];

				console.log(vo.rent_deposit);
				dataChart.push([ "전세", vo.rent_deposit, "#2E88D2" ]);
				dataChart.push([ "매매", vo.trade_price, "#54A2CC" ]);

				// dataChart.push([ "데이터가 없습니다.", 0 ,"#53C14B"])

				var data = google.visualization
						.arrayToDataTable(dataChart);

				var view = new google.visualization.DataView(data);

				var chart = new google.visualization.ColumnChart(chart_tartget
						.get(0));
				chart.draw(view, options);
			}

		}
	})

}

/*****************************************tab2****************************************************/
$(function(){
	$('.apt_type').find('a').on('click',function(){
		event.preventDefault();
		
		$(this).parent().find('a').removeClass('type_select');
		$(this).addClass('type_select');
		
		var type = $(this).attr('href');
		
		console.log(type);
		
		chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
		if(type == 'rent'){
			drawAnnualRentChart(chart_tartget);
		}else if(type == 'trade'){
			drawAnnualTradeChart(chart_tartget);
		}
	})
})

function drawAnnualRentChart(chart_tartget){

	var width = $(chart_tartget).parent().parent().css('width');
	width = parseInt(width);
	console.log(width);
	$.ajax({
		url : '/real_estate/rest/annulRent',
		type : 'post',
		async : false,
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		data : JSON.stringify({
			rent_area : area
		}),
		dataType : 'json',
		success : function(list) {
			
			google.charts.load('current', {
				'packages' : [ 'line' ]
			});
			google.charts.setOnLoadCallback(drawChart);
			
			function drawChart() {
				var options = {
					chart : {
						/*  title: "${lastMonthRent.a_name}의 전세/매매 추이 (1㎡)",
		 			subtitle: '시세 추이' */
					},
					width : width,
					height : 300,
					 series: {
			            0: { color: '#e13592' },
			            1: { color: '#6276ec' }
			           
				       },
				       vAxis: { gridlines: { count: 4 } }
				};
				var data = new google.visualization.DataTable();
				
				data.addColumn('string', '년/월');
				data.addColumn('number', '최저가');
				data.addColumn('number', '최고가');
				
				$(list).each(function(index, item){
					//console.log(item);
					data.addRow([item.rent_year+'/'+item.rent_month,
						item.rent_min,
						item.rent_max]);
				})
				
				
				
				var chart = new google.charts.Line(chart_tartget.get(0));
				
				var formatter = new google.visualization.NumberFormat({pattern:'###,###'});
				formatter.format(data,1);
				formatter.format(data,2);
				
				 options['vAxis']['format'] = 'decimal';
				
				chart.draw(data, google.charts.Line.convertOptions(options));
			}
		}
	});
	
}
function drawAnnualTradeChart(chart_tartget){
	
	$.ajax({
		url : '/real_estate/rest/annulTrade',
		type : 'post',
		async : false,
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		data : JSON.stringify({
			trade_area : area
		}),
		dataType : 'json',
		success : function(list) {
			
			google.charts.load('current', {
				'packages' : [ 'line' ]
			});
			google.charts.setOnLoadCallback(drawChart);
			
			function drawChart() {
				var options = {
						chart : {
							/*  title: "${lastMonthRent.a_name}의 전세/매매 추이 (1㎡)",
		 			subtitle: '시세 추이' */
						},
						width : 'auto',
						height : 300,
						series: {
							0: { color: '#a561bd' },
							1: { color: '#c784de' }
							
						},
						vAxis: { gridlines: { count: 4 } }
				};
				var data = new google.visualization.DataTable();
				
				data.addColumn('string', '년/월');
				data.addColumn('number', '최저가');
				data.addColumn('number', '최고가');
				
				$(list).each(function(index, item){
					console.log(item);
					data.addRow([item.trade_year+'/'+item.trade_month,
						item.trade_min,
						item.trade_max]);
				})
				
				
				
				var chart = new google.charts.Line(chart_tartget.get(0));
				
				var formatter = new google.visualization.NumberFormat({pattern:'###,###'});
				formatter.format(data,1);
				formatter.format(data,2);
				
				options['vAxis']['format'] = 'decimal';
				
				chart.draw(data, google.charts.Line.convertOptions(options));
			}
		}
	});
	
}






