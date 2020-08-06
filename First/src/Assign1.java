//import java.util.*;
public class Assign1 {
	public static void main(String[] args) {

		System.out.println(solution(2,5,6));
	}
	public static String solution(int x,int y,int z) {
		
		String a="a";
		String b="b";
		String c="c";
		int length =x+y+z;
	//	System.out.println(length);
		String str;
		int max;
		
		if(y>x && y>z) {
			max=y;
			str=b;
			y--;
		}
		else if(z>x && z>y) {
			max=y;
			str=c;
			z--;
		}
		else {
			max=x;
			str=a;
			x--;
		}
		
		
		
		String empty = " Empty String";
		
		if(length==1)
		{ 
			str=empty;
		}
		else
		{
		for(int i=1;i<length;i++) {
			
			if(str.length()==1)
			{ if(x!=0) {
				str=str.concat(a);
				x--;
			}
			else if(y!=0) {
				str=str.concat(b);
				y--;
			}
			else if(z!=0) {
					str=str.concat(c);
					z--;
				}
			}
			else {
		
			if(counter(str,i)!=1) {
				if(x!=0) {
				str=str.concat(a);
				x--;
			}
			else if(y!=0) {
				str=str.concat(b);
				y--;
			}
			else if(z!=0) {
					str=str.concat(c);
					z--;
				}
			else
				return str;
			}
			else if(y!=0) {
				str=str.concat(b);
				y--;
			}
			else if(z!=0) {
					str=str.concat(c);
					z--;
				}
			else 
				return str;
			}
		}
		}
		return str;
	}
	public static int counter(String string,int i) {
		
		int counter = 0;
	//	System.out.println(string);
			if(string.charAt(i-2)==string.charAt(i-1)) {
				counter++;
		//	System.out.println(counter);
				return counter;
			}
			else {
				//System.out.println(counter);
				return counter;
				
			}
			}
}