
var area;
var chart_tartget;
var table_target;
var tab_id;
var aptName;

$(function() {
	var id = $('.in').attr('id');
	
	area = getarea();

	
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

		var html = $(this).text() + '<span class="caret"></span>';
		$(this).parent().parent().prev().html(html);
		
		draws(tab_id,area);
		
		
	});
})


function getarea() {
	var getArea ;
//	var div = $('.in').find('.dropdown-menu');
//	div.empty();
	$.ajax({
		type : 'get',
		url : '/real_estate/rest/area_list',
		dataType : 'json',
		async:false,
		success : function(data) {
			getArea = areaList(data);
		}
	
	});
	return getArea;
}


function areaList(data){
	var div = $('.in').find('.dropdown-menu');
	div.empty();
	var html = "";
	$(data).each(
			function(index, item) {
				html += '<li class="area List"><a href="' + item + '">'
				+ item + " ㎡" + '</a></li>';
				
			});
	
	div.append(html);
	
	return data[0];
}
function draws(tab_id,area){
	var url;
	if(tab_id === 'tab1primary'){
		
		$('.page-header h2').html('면적별 시세 조회<span class="pull-right label label-default">부동산</span>');
		
		console.log('면적별 시세 조회');
		chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
		drawLastMonth(chart_tartget);
		
		table_target =  $('#' + tab_id).find('.real_estateData').find('tbody');
		url ='/real_estate/rest/getmonthlyList';
		showTable(table_target,url);
		
	}
	else if(tab_id === 'tab2primary'){
		console.log('면적별 시세 추이');
		
		$('.page-header h2').html('시세 변동 추이<span class="pull-right label label-default">부동산</span>');
		
		chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
		console.log(chart_tartget);
		
		drawAnnualChart(chart_tartget,'/real_estate/rest/annulRent');
		
		if( $('.apt_type_select').attr('href') == 'rent'){
			drawAnnualChart(chart_tartget,'/real_estate/rest/annulRent');
			
		}else if($('.apt_type_select').attr('href') == 'trade'){
			drawAnnualChart(chart_tartget,'/real_estate/rest/annulTrade');
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
			
			$('#apart_title').find('h1').text(aptName);
			$(table_target).append(html);
		}
	})
}



function drawLastMonth(chart_tartget) {
	var width = $(chart_tartget).parent().parent().css('width');
	
	width = parseInt(width);
	width = width * 0.8 ;

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

				var dataChart = [ [ "Element", "가격", { role : "style" } ] ];

				dataChart.push([ "전세", vo.rent_deposit, "#2E88D2" ]);
				dataChart.push([ "매매", vo.trade_price, "#54A2CC" ]);

				
				var data = google.visualization.arrayToDataTable(dataChart);
				var view = new google.visualization.DataView(data);
				var chart = new google.visualization.ColumnChart(chart_tartget.get(0));
				chart.draw(view, options);
			}
		}
	});
}

/*****************************************tab2****************************************************/
$(function(){
	$('.apt_type').find('a').on('click',function(){
		event.preventDefault();
		
		$(this).parent().find('a').removeClass('apt_type_select');
		$(this).addClass('apt_type_select');
		
		var type = $(this).attr('href');
		chart_tartget = $('#' + tab_id).find('.real_estateData').find('.chart');
	
		if(type == 'rent'){
			drawAnnualChart(chart_tartget,'/real_estate/rest/annulRent');
		}else if(type == 'trade'){
			drawAnnualChart(chart_tartget,'/real_estate/rest/annulTrade');
		}
	})
})

function drawAnnualChart(chart_tartget,url){
	var width = $(chart_tartget).parent().parent().css('width');
	width = parseInt(width);
	
	var max;
	var min;
	var year;
	var month;

	$.ajax({
		url : url,
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
					width : width,
					height : 300,
					 series: {
			            0: { color: '#e13592' },
			            1: { color: '#6276ec' }},
				       vAxis: { gridlines: { count: 4 } }
				};
				var data = new google.visualization.DataTable();
				
				data.addColumn('string', '년/월');
				data.addColumn('number', '최저가');
				data.addColumn('number', '최고가');
				
				$(list).each(function(index, item){
					if( $('.apt_type_select').attr('href') == 'rent'){
						max = item.rent_max;
						min = item.rent_min;
						year = item.rent_year;
						month = item.rent_month;
					}else {
						max = item.trade_max;
						min = item.trade_min;
						year = item.trade_year;
						month = item.trade_month;
					}
					data.addRow([year+'/'+month,
						min,
						max]);
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
/*function drawAnnualTradeChart(chart_tartget){
	var width = $(chart_tartget).parent().parent().css('width');
	width = parseInt(width);
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

*/




