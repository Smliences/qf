var startX;
var startY;
var currentLeft;
var currentTop;

var rectTag = document.getElementById("rect");
var mouseSwitch = false;
document.onmousemove = function(e) {
	if (mouseSwitch) {
	var x = e.clientX;
	var y = e.clientY;
	
	var distanceX = x - startX;
	var distanceY = y - startY;
	
	rectTag.style.left = (currentLeft + distanceX) + "px";
	rectTag.style.top = (currentTop + distanceY) + "px";
}
}
function mouseDown(e) {

	e = e ? e : window.event; //这里是为了适配不同的浏览器
mouseSwitch = true;		
	startX = e.clientX;
	startY = e.clientY;

	currentLeft = rectTag.offsetLeft;
	currentTop = rectTag.offsetTop;
}

function mouseUp() {
	mouseSwitch = false;
}
