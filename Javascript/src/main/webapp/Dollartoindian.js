function ConvertToIndianRupee()
{
	// read the dollar store thr vaariable
	const Dollar=document.getElementById('Dollar').value;
	
	//convert the Dollar into Indian Rupee
	const INR=parseFloat(Dollar*82.90);
	
	//set the output to Indian Rupee field
	document.getElementById('IndianRupee').value=INR.toFixed(3);
	
}
