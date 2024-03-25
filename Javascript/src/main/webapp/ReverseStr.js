function ReverseString()
{
	// read the dollar store the variable
	const String=document.getElementById('String').value;
	
	//convert the Dollar into Indian Rupee
	const Reversestring=String.split('').reverse().join('');
	
	//set the output to Indian Rupee field
	document.getElementById('Reversestring').value=Reversestring;
	
}