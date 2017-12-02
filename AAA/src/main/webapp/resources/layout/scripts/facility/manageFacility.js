/**
 * 
 */ 
					$("#fs_start").datepicker({
						showButtonPanel : false,
						dateFormat : "yy-mm-dd",
						altField : '#fs_start'
					});
					
					$("#fs_end").datepicker({
						dateFormat : "yy-mm-dd",
						altField : '#fs_end'
					});
				
				$('#submit').on("click", function() {

					event.preventDefault();
			
					var popupX = (window.screen.width/2) - (400/2);
					var popupY= (window.screen.height/2) - (400/2);
					
					window.open('/facility/changePopup','childWindow', 'status=no, height=200, width=400, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
		});
							 