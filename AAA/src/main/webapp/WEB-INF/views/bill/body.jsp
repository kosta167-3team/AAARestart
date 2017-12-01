<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<!--
Template Name: Viral
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<style type="text/css">
#month_list ul li a{
	color: gray;
}

</style>



<title>Viral | Pages | Full Width</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="/resources/images/bill/css/billMonth.css" rel="stylesheet" type="text/css">
<script src="/resources/layout/scripts/jquery.min.js"></script>
<script src="/resources/images/bill/js/billBody.js"></script>

</head>
<body id="top">

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2 bgded" style="background-image:url('resourcesimages/main/backgrounds/01.png');">
  <div class="overlay">
    <div id="breadcrumb" class="clear"> 
      <!-- ################################################################################################ -->
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">Lorem</a></li>
        <li><a href="#">Ipsum</a></li>
        <li><a href="#">관리비 조회</a></li>
      </ul>
      <!-- ################################################################################################ -->
    </div>
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->

			<div id="select_month">
				<p id="select_month_content">${billMonth.p_month}</p>
				<a data-rno="${billMonth.p_month}" id="select_month_btn" href="">
				<img src="/resources/images/bill/img/arw_select.png"> </a>
				<div id="month_list">
				</div>
			</div>

			<div id="header_article">
				<div id="save_tile">
					<p>${paymentDate }</p>
					<p>납기내</p>
				</div>
				<div id="payment_endDate">
					<p>납부 마감일</p>
					<p id="p_year" data-rno="${dateMap.year }">${dateMap.year }년</p> <p id="p_month" data-rno="${dateMap.month }">${dateMap.month } 월</p><p id="p_date" data-rno="${dateMap.date }"> ${dateMap.date }일</p>
				</div>
				<div id="payment_content">
					<p id = "content_month">${dateMap.month }월 부과금액 </p> <p id="content_monthP"> ${allBill }</p>
					<p>${dateMap.year }년 ${dateMap.month } 월 ${dateMap.date }일</p>
					<button id="payment_detail" data-rno = "${billMonth.u_id }" value = "${billMonth.p_month }">상세보기</button>
				</div>
				
				
				
				
				<div id="detail_content">
					<select id="detail_content_select">
						<option>sdf</option>
					</select>
				
				</div>


			</div>

			<h1> 관리비 항목 상세 </h1>
			<div id="payment_details" class = "scrollable">
				<table id="payment_details_table">
				<thead>
					<tr>
						<th>항목</th>
						<th>당월</th>
						<th>전월</th>
						<th>증감</th>
					</tr>
				</thead>
					<c:forEach var="bill" items="${billSerise }">
					<tr>
						<td><a href="" class="selectDetail" data-rno1 = "${billMonth.p_month }" data-rno="${bill.listName }"> ${bill.listName }</a></td>
						<td>${bill.monthBill }</td>	
						<td>${bill.preMonthBill} </td>
						<td>${bill.compareBill} </td>
					</tr>
					
					</c:forEach>
					

				</table>

			</div>
			<div id="selectDetailDiv">
			
			</div>


			<h1>&lt;h1&gt; to &lt;h6&gt; - Headline Colour and Size Are All The Same</h1>
      <img class="imgr borderedbox inspace-5" src="/resources/images/main/imgr.gif" alt="">
      <p>Aliquatjusto quisque nam consequat doloreet vest orna partur scetur portortis nam. Metadipiscing eget facilis elit sagittis felisi eger id justo maurisus convallicitur.</p>
      <p>Dapiensociis <a href="#">temper donec auctortortis cumsan</a> et curabitur condis lorem loborttis leo. Ipsumcommodo libero nunc at in velis tincidunt pellentum tincidunt vel lorem.</p>
      <img class="imgl borderedbox inspace-5" src="/resources/images/main/imgl.gif" alt="">
      <p>This is a W3C compliant free website template from <a href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a>. For full terms of use of this template please read our <a href="http://www.os-templates.com/template-terms">website template licence</a>.</p>
      <p>You can use and modify the template for both personal and commercial use. You must keep all copyright information and credit links in the template and associated files. For more website templates visit our <a href="http://www.os-templates.com/">free website templates</a> section.</p>
      <p>Portortornec condimenterdum eget consectetuer condis consequam pretium pellus sed mauris enim. Puruselit mauris nulla hendimentesque elit semper nam a sapien urna sempus.</p>
      <h1>Table(s)</h1>
      
      <div class="scrollable">
        <table>
          <thead>
            <tr>
              <th>Header 1</th>
              <th>Header 2</th>
              <th>Header 3</th>
              <th>Header 4</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><a href="#">Value 1</a></td>
              <td>Value 2</td>
              <td>Value 3</td>
              <td>Value 4</td>
            </tr>
            <tr>
              <td>Value 5</td>
              <td>Value 6</td>
              <td>Value 7</td>
              <td><a href="#">Value 8</a></td>
            </tr>
            <tr>
              <td>Value 9</td>
              <td>Value 10</td>
              <td>Value 11</td>
              <td>Value 12</td>
            </tr>
            <tr>
              <td>Value 13</td>
              <td><a href="#">Value 14</a></td>
              <td>Value 15</td>
              <td>Value 16</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="comments">
        <h2>Comments</h2>
        <ul>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="/resources/images/main/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="/resources/images/main/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="/resources/images/main/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
        </ul>
        <h2>Write A Comment</h2>
        <form action="#" method="post">
          <div class="one_third first">
            <label for="name">Name <span>*</span></label>
            <input type="text" name="name" id="name" value="" size="22">
          </div>
          <div class="one_third">
            <label for="email">Mail <span>*</span></label>
            <input type="text" name="email" id="email" value="" size="22">
          </div>
          <div class="one_third">
            <label for="url">Website</label>
            <input type="text" name="url" id="url" value="" size="22">
          </div>
          <div class="block clear">
            <label for="comment">Your Comment</label>
            <textarea name="comment" id="comment" cols="25" rows="10"></textarea>
          </div>
          <div>
            <input name="submit" type="submit" value="Submit Form">
            &nbsp;
            <input name="reset" type="reset" value="Reset Form">
          </div>
        </form>
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->

<script src="/resources/layout/scripts/jquery.backtotop.js"></script>
<script src="/resources/layout/scripts/jquery.mobilemenu.js"></script>

</body>
</html>