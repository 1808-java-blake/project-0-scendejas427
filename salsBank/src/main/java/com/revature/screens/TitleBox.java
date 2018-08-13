package com.revature.screens;



public class TitleBox {
	public void makeTitle(String string) {
		Diamonds here=new Diamonds();
		here.make(0,68);
		
		//screen
		String wait="        ";
		String wait1="ooooooo";
		wait=wait+" ";
		wait1=wait1.replaceFirst("o", "");
		
		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait +"____________________________________________________________"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
		wait=wait+" ";
		wait1=wait1.replaceFirst("o", "");
		
		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait +"|_|______________________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
		wait=wait+" ";
		wait1=wait1.replaceFirst("o", "");
		String s=string.split("!")[0];
		for(int i=0;i<=(52-string.split("!")[0].length())/2;i++) {
			if(s.length()%2==1) {
				s=" "+s;
			}
			s=" "+s+" ";
		}
		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|"+s+"|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
		wait=wait+" ";
		wait1=wait1.replaceFirst("o", "");
		
		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|______________________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
		wait=wait+" ";
		wait1=wait1.replaceFirst("o", "");
		int j=0;
		for( String each:string.split("!")) {
			String t=each;		
			if(each.length()%2==1) {
				t=" "+t;
			}
			else {
				t=" "+t+" ";
			}
			for(int i=0;i<(45-each.length())/2;i++) {

				t=" "+t+" ";
			}
			if(j==0) {
				j++;
			}
			else if(j==1) {
				System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter "+j+"|"+t+"|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				wait=wait+" ";
				wait1=wait1.replaceFirst("o", "");
				System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				j++;
			}
			else if(j==2) {
				System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter "+j+"|"+t+"|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				j++;
				
			}
			else {
				wait1=wait1+"o";
				wait=wait.replaceFirst(" ", "");
				
				System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter "+j+"|"+t+"|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				wait1=wait1+"o";
				wait=wait.replaceFirst(" ", "");
				
				System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				j++;
				
			}
			
		}
		
		
		//under screen
		here.make(70+j*2, 90);
	}
}
