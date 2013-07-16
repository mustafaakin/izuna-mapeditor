$(document).ready(function(){
	var c=document.getElementById("drawArea");
	var WIDTH = 1280;
	var HEIGHT = 720;
	var SCALE = 2;
	var PADDING = 200;

	c.width = HEIGHT / 2 + PADDING;
	c.height = WIDTH / 2 + PADDING;

	var ctx = c.getContext("2d");
	ctx.beginPath();
	ctx.rect(PADDING / 2, PADDING / 2, c.width - PADDING, c.height - PADDING);
	ctx.strokeStyle = "red";
	ctx.stroke();

	$(".shipSelect").click(function(){
		$(".shipSelect").removeClass("selectedShip");
		$(this).toggleClass("selectedShip");
	});

	var ships = [];

	$("#addToScene").click(function(){
		var src = ($(".shipSelect.selectedShip").attr("src"));

	});
	
	function writeState(){
		if ( ships.length > 0){
			var s = ships[ships.length - 1];

		}
	}
});
