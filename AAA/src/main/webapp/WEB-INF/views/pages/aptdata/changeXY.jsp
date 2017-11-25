
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<script type="text/javascript"
	src="http://map.vworld.kr/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="http://map.vworld.kr/js/map/proj4js.js"></script>
<script type="text/javascript"
	src="http://map.vworld.kr/js/map/OpenLayers-2.13/OpenLayers.js"></script>
</head>

<body>
<script type="text/javascript">
$(function(){
	Proj4js.defs["EPSG:4019"] = "+proj=longlat +ellps=GRS80 +no_defs";
	Proj4js.defs["EPSG:3857"] = "+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +no_defs";
	Proj4js.defs["EPSG:900913"] = "+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +no_defs";

	//UTM-K
	Proj4js.defs["EPSG:5179"] = "+proj=tmerc +lat_0=38 +lon_0=127.5 +k=0.9996 +x_0=1000000 +y_0=2000000 +ellps=GRS80 +units=m +no_defs";
	//중부원점(50만)
	Proj4js.defs["EPSG:5181"] = "+proj=tmerc +lat_0=38 +lon_0=127 +k=1 +x_0=200000 +y_0=500000 +ellps=GRS80 +units=m +no_defs";
	//서부원점
	Proj4js.defs["EPSG:5185"] = "+proj=tmerc +lat_0=38 +lon_0=125 +k=1 +x_0=200000 +y_0=600000 +ellps=GRS80 +units=m +no_defs";
	//중부원점-o
	Proj4js.defs["EPSG:5186"] = "+proj=tmerc +lat_0=38 +lon_0=127 +k=1 +x_0=200000 +y_0=600000 +ellps=GRS80 +units=m +no_defs";
	//동부원점
	Proj4js.defs["EPSG:5187"] = "+proj=tmerc +lat_0=38 +lon_0=129 +k=1 +x_0=200000 +y_0=600000 +ellps=GRS80 +units=m +no_defs";
	//동해(울릉)원점
	Proj4js.defs["EPSG:5188"] = "+proj=tmerc +lat_0=38 +lon_0=131 +k=1 +x_0=200000 +y_0=600000 +ellps=GRS80 +units=m +no_defs";

	console.log('테스트');
	
	request();
	
});
function request(){
	//lat,lon
	//setCurrentCoord("1946411.15132","959975.551426");
	
	$.getJSON('/aptData/rest/allAptList',function(data){
		console.log(data);
	});
};
function setCurrentCoord(lat,lon) {
	try {
		//var value = $("#crs").val();
		//var scrs = $("#scrs").val();
		var value = "epsg:4326";
		var scrs = "epsg:5179";
		var epsg = value.toUpperCase();

		if (value == scrs) {

		} else {
			//alert('dd');
			/* var lonlat = new OpenLayers.LonLat($("#lon").val(),$("#lat").val()); */

			var lonlat = new OpenLayers.LonLat(lon,lat);
			var SCRS = new OpenLayers.Projection(scrs);
			var TCRS = new OpenLayers.Projection(epsg);
			var point = lonlat.transform(SCRS, TCRS);
			//$("#point").val(point.lon + "," + point.lat);
			console.log(point.lat + "," + point.lon);
		}
	} catch (e) {
	}

};


</script>
</body>

</html>

