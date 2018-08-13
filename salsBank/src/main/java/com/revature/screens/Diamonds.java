package com.revature.screens;

public class Diamonds {
	
	public void make(int start, int end) {
		start=start+15;
		end=end+15;
		String wait="";
		 String wait1="";
		 for(int j=0; j<start;j++) {
			 if(j%30<15) {
					
					wait=wait+"o";
					wait1=wait1.replaceFirst(" ", "");
					
				}
				else if(j%30==29){
					wait1=wait1+" ";
					wait=wait.replaceFirst("o", "");

				}
					
				else {
					wait1=wait1+" ";
					wait=wait.replaceFirst("o", "");
				
				}
			
		}

		for(int i=start; i<end;i++) {
			try {
				Thread.sleep(15l, 100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%30<15) {
				
				try {
					Thread.sleep(5l, 50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				wait=wait+"o";
				wait1=wait1.replaceFirst(" ", "");
				System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait );
			}
			else if(i%30==29){
				System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
				wait1=wait1+" ";
				wait=wait.replaceFirst("o", "");

			}
				
			else {
				wait1=wait1+" ";
				wait=wait.replaceFirst("o", "");
				System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
			}
			
		}
	}
}
