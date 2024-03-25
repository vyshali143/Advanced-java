function ConvertToCelsius()
{
	// read the  Farhenheit store thr variable
	const Farenheit=document.getElementById('Farenheit').value;
	
	//convert the Farhenheit into Celsius
	const Celsius=(parseFloat(Farenheit)-32)*5/9;
	
	//set the output to Celsius field
	document.getElementById('Celsius').value=Celsius.toFixed(2);
	
}
