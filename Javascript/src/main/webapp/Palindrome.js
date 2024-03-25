function ReverseNumber()
{
	// read the number store the variable
	const Num=document.getElementById('Number').value;
	
	//convert the number into reverse
	const Revnum=Num.split('').reverse('').join('');
	
		//set the output to reverse number field
	document.getElementById('Reversenumber').value=Revnum;
	}
	
