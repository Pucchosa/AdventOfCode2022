package aOc22;

import java.util.ArrayList;

public class Handler {
	private int day;
	private int part;
	private int yea;
	private long ris;
	private String inp;
	
	public Handler(int y,int d, int p, String r) {
		yea=y;
		day=d;
		part=p;
		inp=r;
	}

	public long calc() {
		if (yea==1) {
			if (day==1) {
				if (part==1) {
					ris=Day01_part1_2021.calculate(inp);
				}
			}
		}
		
		else {
			for (int i=0;i<inp.length();i++) {
				ris=ris+inp.charAt(i);
			}
		}
		
		
		
		
		return ris;
	}
}
