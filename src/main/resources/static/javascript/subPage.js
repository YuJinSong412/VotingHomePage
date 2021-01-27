/**
 * 
 */
 
var currentIndex = -1; 
 
function myFunction(index) {
		if(currentIndex == -1 || currentIndex == index ) {
			let a = document.getElementById("subPage");
			if (a.style.display === "none") {
				a.style.display = "block";
			} else {
				a.style.display = "none";
			}
			currentIndex = index;	
		}
		
		let x = document.getElementById("subPage_" + index);
		let y = document.getElementById("appDetail");
		if (x.style.display === "none") {
			x.style.display = "block";
			y.style.backgroundColor = "red";
		} else {
			x.style.display = "none";
			y.style.backgroundColor = "white";
		}
}