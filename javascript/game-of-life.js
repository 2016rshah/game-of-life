var canvas = document.getElementById("c");
var context = canvas.getContext("2d");
var BOXSIZE = 20

gridLines()
fillBox(10, 10)
fillBox(3, 12)


function fillBox(i, j)
{
	context.rect(i*BOXSIZE, j*BOXSIZE, BOXSIZE, BOXSIZE)
	context.fillStyle = 'black'
	context.fill();
}
function gridLines()
{
	for (var x = 0; x < canvas.width; x += BOXSIZE) {
	  context.moveTo(x, 0);
	  context.lineTo(x, canvas.height);
	}

	for (var y = 0.5; y < canvas.height; y += BOXSIZE) {
	  context.moveTo(0, y);
	  context.lineTo(canvas.width, y);
	}
	// context.moveTo(0,0);
	// context.lineTo(380,380);

	context.strokeStyle = "#ddd";
	context.stroke();
}


