/**
 * 
 */
function myFunction() {
		let x = document.getElementById("subPage");
		let y = document.getElementById("appDetail");
		if (x.style.display === "none") {
			x.style.display = "block";
			y.style.backgroundColor = "red";
		} else {
			x.style.display = "none";
			y.style.backgroundColor = "white";
		}
}