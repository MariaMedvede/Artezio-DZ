/*Задание 1
for (var i =10; i<=20; i++)
{
 console.log(Math.pow(i,2));
}

for (var i =10; i<=20; i++)
{
	function sumTo(n) {
  return n * (n + 1) / 2;
}

 console.log(sumTo(i));
}*/

/* Задание 2*/

function buttonClick() {
	
	var x1 = document.getElementById('x1').value;
	var x2 = document.getElementById('x2').value;
	if (x1 == "" || x2 =="") {
	alert("Поля х1 и х2 должны быть заполнены!");
	} else{
		x1 = parseInt(x1);
		x2 = parseInt(x2);
	if (Number.isNaN(x1) || Number.isNaN(x2)){
	alert("В поля х1 и х2 должны быть введены числовые значения!");
	}else{
	var resultDiv = document.getElementById("result");
	
	function sumTo(x1,x2) {
		var sum = x1;
		for (var i = x1+1; i <= x2; i++) {
		sum += i;}
		return sum;
	}
	
	function multTo(x1,x2) {
		var mult = x1;
		for (var i = x1+1; i <= x2; i++) {
		
		mult = mult*i;}
		return mult;
	}
  
  if(document.getElementById("sum").checked==true){
	var result = sumTo(x1,x2);
	resultDiv.innerHTML = result;
	}else {
		var result = multTo(x1,x2);
		resultDiv.innerHTML = result;
		}
}
	}
/*Задание №6*/
	var primeDiv = document.getElementById("prime");
	primeDiv.append("Простые числа: ");
	
	if (x1==1) {var i = 2;}
	else {var i=x1;}
	
	nextPrime:
  for ( i; i <= x2; i++) {

    for (var j = 2; j < i; j++) {
      if (i % j == 0) continue nextPrime;
    }
primeDiv.append(i +" ");
    
  }
}
function Clear() {
	document.getElementById('myform').reset();
}


