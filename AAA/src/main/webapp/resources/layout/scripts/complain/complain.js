$(function(){
	
	var type_cat;
	var dong;
	/*$('.select_target').addClass('hide');
	$('.select_ho').addClass('hide');
	$('.select_type_detail').addClass('hide');*/
	
	$('.btn-group').on('click','a',function(event){
		event.preventDefault();
		$(this).parent().parent().prevAll('button').html($(this).text()+'<span class="caret"></span>');
	})
	
	
	//항의 유형 선택
	$('.select_type a').on('click',function(){
		type_cat = $(this).text();
		
		$('.select_target').addClass('hide');
		$('.select_ho').addClass('hide');
		$('.select_type_detail').addClass('hide');
		
		
		$('.select_target').removeClass('hide');
		if($(this).text()=='시설'){
			$('[ name ="disclosure_status"]').removeAttr("disabled");
			 $('[ name ="disclosure_status"]').bootstrapToggle('on');
			getFacilityList();
		}else if($(this).text()=='입주민'){
			getDongList();
			 $('[ name ="disclosure_status"]').bootstrapToggle('off');
			 $('[ name ="disclosure_status"]').attr('disabled','disabled');
		}
	})
	
	//시설 선택
	$('.select_target').on('click','.facility',function(){
		$('.select_type_detail').removeClass('hide');
		getTypeList(type_cat);
		$('[name="comp_target"]').val($(this).text());
	})
	
	//동선택
	$('.select_target').on('click','.resident',function(){
		$('.select_ho').removeClass('hide');
		get_hoList($(this).text());
	
		dong = $(this).text();
		
		$('[name="comp_target"]').val(dong);
		//$('.select_type_detail').removeClass('hide');
		//getTypeList(type_cat);
	})
	
	//호 선택
	$('.select_ho').on('click','a',function(){
		$('.select_type_detail').removeClass('hide');
		getTypeList(type_cat);

		$('[name="comp_target"]').val(dong + "/"+$(this).text());
		
	})
	
	//항의 이유 선택
	$('.select_type_detail').on('click','a',function(){
		$('[name="type_id"]').val($(this).attr('href'));
	})
})

/* 시설 목록 불러오기 */
function getFacilityList(){
	$('.select_target ul').empty();
	$('.select_target').find('label').html('시설 목록<span>*</span>');
	$('.select_target').find('button').html('시설 선택<span class="caret"></span>');
	$.ajax({
		type:'get',
		url:'/complain/getFacilityList',
		success:function(data){
			var html ="";
			$(data).each(function(index,item){
				html +='<li><a class="facility">'+item.f_name+'</a><li>';
			})
			//$('.select_target ul').addClass('facility');
			$('.select_target ul').append(html);
		}
	})
}


/* 입주민 동 목록 불러오기  */
function getDongList(){
	$('.select_target ul').empty();
	$('.select_target').find('label').html('동 목록<span>*</span>');
	$('.select_target').find('button').html('동 선택<span class="caret"></span>');
	$.ajax({
		type:'get',
		url:'/complain/get_dong_ho',
		success:function(data){
			var html ="";
			$(data).each(function(index,item){
				html +='<li><a class="resident">'+item+'</a><li>';
			})
			//$('.select_target ul').addClass('resident');
			$('.select_target ul').append(html);
		},
		error:function(){
			alert('입주민 동 목록 불러오는거 실패');
		}
	})
}
/* 호 목록 불러오기 */
function get_hoList(r_dong){
	$('.select_ho ul').empty();
	$.ajax({
		type:'get',
		url:'/complain/get_dong_ho'+r_dong,
		success:function(data){
			var html ="";
			$(data).each(function(index,item){
				html +='<li><a>'+item+'</a><li>';
			})
			//$('.select_target ul').addClass('resident');
			$('.select_ho ul').append(html);
		},
		error:function(){
			alert('입주민 호 목록 불러오는거 실패');
		}
	})
}

/*타입 유형 불러오기*/
function getTypeList(select_type){
	$('.select_type_detail ul').empty();
	$.ajax({
		type:'get',
		url:'/complain/getType'+select_type,
		success:function(data){
			var html ="";
			$(data).each(function(index,item){
				console.log(item);
				html +='<li><a href="'+item.TYPE_ID+'">'+item.TYPE_DETAIL+'</a></li>';
			})
			$('.select_type_detail ul').append(html);
		}
	})
	
}
