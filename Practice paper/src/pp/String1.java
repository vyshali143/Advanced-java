package pp;

public class String1 {
	public static void main(String args[])
	{
 String s="1,2,a,v,h,";
 System.out.println(s);
 
 String s1 = new String("a,r,3,h,6,8,gr,ji");
System.out.println(s1);

String s2="'a','c','r','t','f','r'";
char ch[]=s2.toCharArray();
System.out.println(s2);

String s3=new String(ch,2,4);
System.out.println(s3);

String c=("65,66,67,68,69,70");
String s4=new String(c);
System.out.println(s4);

char ch1[] = ('a','c','f','g','g','t','h');
String s5=new String(ch1,2,2);
System.out.println(s5);


 
}
}