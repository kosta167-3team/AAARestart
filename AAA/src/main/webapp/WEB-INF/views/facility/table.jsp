<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 
<style type="text/css">

#week_fr {
	width: 900px;
	margin: 0 auto;
}

table#acrylic {
            border-collapse: separate;
            background: #fff;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            margin: 50px auto;
            -moz-box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
            cursor: pointer;
        }
        
        #acrylic thead {
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }
        
        #acrylic thead th {
            font-family: 'Roboto';
            font-size: 16px;
            font-weight: 400;
            color: #fff;
            text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.5);
            text-align: left;
            padding: 20px;
            background-size: 100%;
            background-image: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0%, #646f7f), color-stop(100%, #4a5564));
            background-image: -moz-linear-gradient(#646f7f, #4a5564);
            background-image: -webkit-linear-gradient(#646f7f, #4a5564);
            background-image: linear-gradient(#646f7f, #4a5564);
            border-top: 1px solid #858d99;
        }
        
        #acrylic thead th:first-child {
            -moz-border-top-right-radius: 5px;
            -webkit-border-top-left-radius: 5px;
            border-top-left-radius: 5px;
        }
        
        #acrylic thead th:last-child {
            -moz-border-top-right-radius: 5px;
            -webkit-border-top-right-radius: 5px;
            border-top-right-radius: 5px;
        }
        
        #acrylic tbody tr td {
            font-family: 'Open Sans', sans-serif;
            font-weight: 400;
            color: #5f6062;
            font-size: 13px;
            padding: 20px 20px 20px 20px;
            border-bottom: 1px solid #e0e0e0;
        }
        
        #acrylic tbody tr:nth-child(2n) {
            background: #f0f3f5;
        }
        
        #acrylic tbody tr:last-child td {
            border-bottom: none;
        }
        
        #acrylic tbody tr:last-child td:first-child {
            -moz-border-bottom-right-radius: 5px;
            -webkit-border-bottom-left-radius: 5px;
            border-bottom-left-radius: 5px;
        }
        
        #acrylic tbody tr:last-child td:last-child {
            -moz-border-bottom-right-radius: 5px;
            -webkit-border-bottom-right-radius: 5px;
            border-bottom-right-radius: 5px;
        }
        
        #acrylic tbody:hover > tr td {
            filter: progid: DXImageTransform.Microsoft.Alpha(Opacity=50);
            opacity: 0.5;
        }
        
        #acrylic tbody:hover > tr:hover td {
            text-shadow: none;
            color: #2d2d2d;
            filter: progid: DXImageTransform.Microsoft.Alpha(enabled=false);
            opacity: 1;
            transition: 0.2s all;
        }
</style>



<!-- 오늘의 예약 -->
<style type="text/css">
/* .accordion {
	width: 500px;
	margin: 0 auto;
} */
 
.accordion {
	width: 500px;
	margin: 0 auto;
} 
 
.accordion-toggle {
	border-bottom: 1px solid #cccccc;
	cursor: pointer;
	margin: 0;
	padding: 10px 0;
	position: relative;
}

.accordion-toggle.active:after {
	content: "";
	position: absolute;
	right: 0;
	top: 17px;
	width: 0;
	height: 0;
	border-bottom: 5px solid #f00;
	border-left: 5px solid rgba(0, 0, 0, 0);
	border-right: 5px solid rgba(0, 0, 0, 0);
}

.accordion-toggle:before {
	content: "";
	position: absolute;
	right: 0;
	top: 17px;
	width: 0;
	height: 0;
	border-top: 5px solid #000;
	border-left: 5px solid rgba(0, 0, 0, 0);
	border-right: 5px solid rgba(0, 0, 0, 0);
}

.accordion-toggle.active:before {
	display: none;
}

.accordion-content {
	display: none;
}

.accordion-toggle.active {
	color: green;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('.accordion').find('.accordion-toggle').click(function() {
			$(this).next().slideToggle('600');
			$(".accordion-content").not($(this).next()).slideUp('600');
		});
		$('.accordion-toggle').on('click', function() {
			$(this).toggleClass('active').siblings().removeClass('active');
		});
	});
</script>


<title>Insert title here</title>
</head>
<body>



		 <div class="accordion">  

					<h1>오늘의 예약</h1>
					<c:forEach var="i" items="${latestList}" varStatus="status">
						<c:choose>
							<c:when test="${status.first==null }">
								<h4 class="accordion-toggle">- 내역이 없습니다 -</h4>
							</c:when>

							<c:when test="${status.index == 0 }">
								<c:forEach var="f" items="${facility }">
									<c:if test="${i.f_id == f.f_id}">
										<c:forEach var="t" items="${timeList}">
											<c:if test="${t.t_id == i.t_id }">

												<h4 class="accordion-toggle">${f.f_name}</h4>
												<div id="now">
 													<table>
														<tr>
															<td><p>시간: ${t.t_start }~${t.t_end }</p>
																<p>인원: ${i.fr_cnt }명</p></td>
															<td>
																qr 넣기
															</td>
														</tr>
													</table>  
												</div>

											</c:if>
										</c:forEach>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="f" items="${facility }">
									<c:if test="${i.f_id == f.f_id}">
										<c:forEach var="t" items="${timeList}">
											<c:if test="${t.t_id == i.t_id }">

												<h4 class="accordion-toggle">${f.f_name}</h4>
												<div class="accordion-content">
													<p>시간: ${t.t_start }~${t.t_end }</p>
													<p>인원: ${i.fr_cnt }명</p>
												</div>
											</c:if>
										</c:forEach>
									</c:if>
								</c:forEach>


							</c:otherwise>

						</c:choose>
					</c:forEach>
				</div>






				<div id="week_fr">
  					<h1>주간 예약</h1>
        <table id="acrylic">
            <thead>
                <tr>
                  		<th>시간</th>
								<c:forEach var="dateList" items="${dateList}">
									<th><a>${dateList}</a></th>
								</c:forEach>
                </tr>
            </thead>
 						<tbody>

							<c:forEach var="t" items="${timeList }">

								<tr val="${t.t_id}">
									<td>${t.t_start }~${t.t_end }</td>
									<c:forEach var="reservation" items="${reservationList }">
										<td><c:forEach var="r" items="${reservation}">
												<c:choose>
													<c:when test="${r.t_id == t.t_id}">
														<c:forEach var="facility" items="${facility }">
															<c:if test="${r.f_id==facility.f_id}">
																<a class="reservation" href="#" val="${r.fr_id}">${facility.f_name}</a>
															</c:if>
														</c:forEach>
													</c:when> 
												</c:choose>
											</c:forEach></td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
        </table>
    </div>
    
    				<script type="text/javascript">
					$('.reservation')
							.on(
									"click",
									function() {

										event.preventDefault();

										var fr_id = $(this).attr("val");

										getReservationDetail("/facility/ReservationDetail/"
												+ fr_id);

									});

					function getReservationDetail(f_info) {

						$.getJSON(f_info, function(data) {

							var a = data.r_fr_cnt;
							var b = data.r_f_name;
							var c = data.r_time.t_start;
							var d = data.r_time.t_end;

							alert(a + "명  " + b + " " + c + "~" + d + " 예약");

						})
					}
				</script>
</body>
</html>