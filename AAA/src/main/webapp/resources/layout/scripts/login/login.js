//$(function(){
//var textfield = $("input[name=user]");
//            $('button[type="submit"]').click(function(e) {
//                e.preventDefault();
//                //little validation just to check username
//                if (textfield.val() != "") {
//                    $("body").scrollTo("#output");
//                    $("#output").addClass("alert alert-success animated fadeInUp").html("Welcome back " + "<span style='text-transform:uppercase'>" + textfield.val() + "</span>");
//                    $("#output").removeClass(' alert-danger');
//                    $("input").css({
//                    "height":"0",
//                    "padding":"0",
//                    "margin":"0",
//                    "opacity":"0"
//                    });
//                    //change button text 
//                    $('button[type="submit"]').html("continue")
//                    .removeClass("btn-info")
//                    .addClass("btn-default").click(function(){
//                    $("input").css({
//                    "height":"auto",
//                    "padding":"10px",
//                    "opacity":"1"
//                    }).val("");
//                    });
//                    
//                    //show avatar
//                    $(".avatar").css({
//                        "background-image": "url('http://api.randomuser.me/0.3.2/portraits/women/35.jpg')"
//                    });
//                } else {
//                    //remove success mesage replaced with error message
//                    $("#output").removeClass(' alert alert-success');
//                    $("#output").addClass("alert alert-danger animated fadeInUp").html("sorry enter a username ");
//                }
//                //console.log(textfield.val());
//
//            });
//});
//

$(function () {
	var textfield = $("input[name=urd]");
	var pass = $("input[name=upw]");
	
	$('#loginForm').submit(function(event) {
		 event.preventDefault();
		 
		 var that = $(this);
		 
		 if (textfield.val() != "" && pass.val() != "") {
             //$("body").scrollTo("#output");
            // $("#output").addClass("alert alert-success animated fadeInUp").html("Welcome back " + "<span style='text-transform:uppercase'>" + textfield.val() + "</span>");
            // $("#output").removeClass(' alert-danger');
             $("input").css({
             "height":"0",
             "padding":"0",
             "margin":"0",
             "opacity":"0"
             });
             //change button text 
             $('button[type="submit"]')
             .removeClass("btn-info")
             .addClass("btn-default").click(function(){
             $("input").css({
             "height":"auto",
             "padding":"10px",
             "opacity":"1"
             }).val("");
             });
             
             //show avatar
             $(".avatar").css({
                 "background-image": "url('http://api.randomuser.me/0.3.2/portraits/women/35.jpg')"
             });
             
             that.attr("action", "/user/loginPost");
             that.get(0).submit();
         } else {
        	 if(textfield.val() == ""){
        		 $("#output").removeClass(' alert alert-success');
                 $("#output").addClass("alert alert-danger animated fadeInUp").html("아이디 입력해주세요~");
        	 }else if(pass.val() == ""){
        		 $("#output").removeClass(' alert alert-success');
                 $("#output").addClass("alert alert-danger animated fadeInUp").html("비밀번호를 입력해주세요~");
        	 }
         }
         //console.log(textfield.val());
     });
	
})






