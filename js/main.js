$(document).ready(function(){
	var c=document.getElementById("drawArea");
	var WIDTH = 1280;
	var HEIGHT = 720;
	var PADDING = 400;

	c.width = WIDTH + PADDING;
	c.height = HEIGHT + PADDING;

	var ctx = c.getContext("2d");

	var imgPlayer = new Image();
	imgPlayer.onload = function(){ drawScene()};
	imgPlayer.src = "img/ship_player.png";

	var nowChoosing = 0; // 0: start, 1:end, 2:mid

	c.addEventListener("mousedown", function(event){
		var x = event.x;
		var y = event.y;
		x -= c.offsetLeft;
		y -= c.offsetTop;
		x = Math.floor(c.width / 740 * x);
		y = Math.floor(c.height / 460 * y);

		drawScene();
		drawShip($(".selectedShip").get()[0], x,y,true);
		var tX = x - PADDING / 2;
		var tY = y - PADDING / 2;
		var str = "";
		if ( nowChoosing == 0){
			str = "start";
		} else if ( nowChoosing == 1){
			str = "end";
		} else if ( nowChoosing == 2){
			str = "mid";
		} else {
			alert("noluo lan");
		}
		$("#" + str + "X").val(tX);
		$("#" + str + "Y").val(tY);		
	}, false);



	function drawScene(){
		ctx.clearRect(0,0,c.width, c.height);
		drawShip(imgPlayer, 1080, 310);
		ctx.beginPath();
		ctx.rect(PADDING / 2, PADDING / 2, c.width - PADDING, c.height - PADDING);
		ctx.strokeStyle = "red";
		ctx.stroke();		
	}

	function drawShip(img, x, y, isScreenCoordinates){
		if ( isScreenCoordinates){
			ctx.drawImage(img, x, y);  
		} else {
			ctx.drawImage(img, x + PADDING / 2, y + PADDING / 2);  
		}	
	}

	$(".shipSelect").click(function(){
		$(".shipSelect").removeClass("selectedShip");
		$(this).toggleClass("selectedShip");

		drawScene();
		drawShip($(this).get()[0], 0,0);

	});

	var ships = [];

	$("#addToScene").click(function(){
		var src = ($(".shipSelect.selectedShip").attr("src"));

	});

	$("#chooseStart").click(function(){ nowChoosing = 0});
	$("#chooseEnd").click(function(){ nowChoosing = 1});
	$("#chooseMid").click(function(){ nowChoosing = 2});
	
	function writeState(){
		if ( ships.length > 0){
			var s = ships[ships.length - 1];

		}
	}
});
