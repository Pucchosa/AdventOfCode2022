package aOc21;
import java.util.LinkedList;

public class Day17_2021 {
	public static long calculate1(String s) {
		int xMax=0;
		int xMin=0;
		int yMax=0;
		int yMin=0;
		int q=0;
		int ris=0;
		LinkedList<int[]> possibiliXF=new LinkedList<int[]>();
		LinkedList<int[]> pos=new LinkedList<int[]>();
		String inp = s;
		String[] first=inp.split(" ");
		String[] ics=first[2].split("\\..");
		String[] ips=first[3].split("\\..");
		String xmm="";
		
		
		for (int i=0;i<ics[0].length();i++){
			if (ics[0].charAt(i)>='0'&&ics[0].charAt(i)<='9'){
				xmm=xmm+ics[0].charAt(i);
			}
			if (ics[0].charAt(i)=='-'){
				xmm=xmm+ics[0].charAt(i);
			}
		}
		String xMM="";
		for (int i=0;i<ics[1].length();i++){
			if (ics[1].charAt(i)>='0'&&ics[1].charAt(i)<='9'){
				xMM=xMM+ics[1].charAt(i);
			}
			if (ics[1].charAt(i)=='-'){
				xMM=xMM+ics[1].charAt(i);
			}
		}
		String ymm="";
		for (int i=0;i<ips[0].length();i++){
			if (ips[0].charAt(i)>='0'&&ips[0].charAt(i)<='9'){
				ymm=ymm+ips[0].charAt(i);
			}
			if (ips[0].charAt(i)=='-'){
				ymm=ymm+ips[0].charAt(i);
			}
		}
		String yMM="";
		for (int i=0;i<ips[1].length();i++){
			if (ips[1].charAt(i)>='0'&&ips[1].charAt(i)<='9'){
				yMM=yMM+ips[1].charAt(i);
			}
			if (ips[1].charAt(i)=='-'){
				yMM=yMM+ips[1].charAt(i);
			}
		}
		xMin = Integer.parseInt(xmm);
		xMax = Integer.parseInt(xMM);
		yMin = Integer.parseInt(ymm);
		yMax = Integer.parseInt(yMM);

// calculate evry possible X
		for (int x=0;x<xMax;x++){
			int t=0;
			for (int f=0;f<x;f++){
				t=t+f;
				int X=(x*(f+1))-t;
				if (X>=xMin&&X<=xMax){
					int coor[]={x,f,t};
					possibiliXF.add(coor);
					break;
					}
				}
			}
			
// calculate evry possible Y 
		for (int[] j:possibiliXF){
					
			for (int y=1000;y>yMin;y--){
				int x=j[0];
				int t=j[2]-j[1];
				for (int f=j[1];f<1000;f++){
					t=t+f;
					int Y=(y*(f+1))-t;
					if (Y>=yMin&&Y<=yMax){
						int[] k={x, y};
						pos.add(k);
						break;
						}
					}
				}
			}

// find maximum Y
		for (int[] d:pos){
			if (d[1]>q){
				q=d[1];
				}
			}

// find minimum Y
			int t=0;
			for (int f=0;f<=q+1;f++){
				t=t+f;
				int Y=(q*(f+1))-t;
				if (Y>ris){
					ris=Y;
					}
				}
// print result
		
		
		
		return (long) ris;
	}
	
	public static long calculate2(String s) {
		int xMax=0;
		int xMin=0;
		int yMax=0;
		int yMin=0;
		LinkedList<int[]> possibiliXF=new LinkedList<int[]>();
		LinkedList<int[]> possibiliYF=new LinkedList<int[]>();
		LinkedList<int[]> pos=new LinkedList<int[]>();

// get value out of input
		String inp = s;
		String[] first=inp.split(" ");
		String[] ics=first[2].split("\\..");
		String[] ips=first[3].split("\\..");
		String xmm="";
		for (int i=0;i<ics[0].length();i++){
			if (ics[0].charAt(i)>='0'&&ics[0].charAt(i)<='9'){
				xmm=xmm+ics[0].charAt(i);
			}
			if (ics[0].charAt(i)=='-'){
				xmm=xmm+ics[0].charAt(i);
			}
		}
		String xMM="";
		for (int i=0;i<ics[1].length();i++){
			if (ics[1].charAt(i)>='0'&&ics[1].charAt(i)<='9'){
				xMM=xMM+ics[1].charAt(i);
			}
			if (ics[1].charAt(i)=='-'){
				xMM=xMM+ics[1].charAt(i);
			}
		}
		String ymm="";
		for (int i=0;i<ips[0].length();i++){
			if (ips[0].charAt(i)>='0'&&ips[0].charAt(i)<='9'){
				ymm=ymm+ips[0].charAt(i);
			}
			if (ips[0].charAt(i)=='-'){
				ymm=ymm+ips[0].charAt(i);
			}
		}
		String yMM="";
		for (int i=0;i<ips[1].length();i++){
			if (ips[1].charAt(i)>='0'&&ips[1].charAt(i)<='9'){
				yMM=yMM+ips[1].charAt(i);
			}
			if (ips[1].charAt(i)=='-'){
				yMM=yMM+ips[1].charAt(i);
			}
		}
		xMin = Integer.parseInt(xmm);
		xMax = Integer.parseInt(xMM);
		yMin = Integer.parseInt(ymm);
		yMax = Integer.parseInt(yMM);

// calculate evry possible X
		for (int x=0;x<=xMax;x++){
			int t=0;
			for (int f=0;f<=x;f++){
				t=t+f;
				int X=(x*(f+1))-t;
				if (X>=xMin&&X<=xMax){
					int coor[]={x,f};
					possibiliXF.add(coor);
				//	break;
					}
				}
			}

// calculate evry possible Y 
		for (int y=1000000;y>=yMin;y--){
			int Y=0;
			for (int f=0;f<1000;f++){
				int vel=y-f;
				Y=Y+vel;
				if (Y>=yMin&&Y<=yMax){
					int coor[]={y,f};
					possibiliYF.add(coor);
				//	break;
					}
				}
			}

// look for doubles
			for (int[] a:possibiliXF){
			int x=a[0];
			int rip=a[1];
			for (int[]b:possibiliYF){
				int y=b[0];
				int rep=b[1];
				if (rep==rip){
					int prova=0;
					for (int[] u:pos){
						int px=u[0];
						int py=u[1];
						if (px==x&&py==y){
							prova=1;
						}
					}
					if (prova==0){
						int[] coor={x,y,rep};
						pos.add(coor);
					}
				}
			}
		}
		
		for (int[] a:possibiliXF){
			int x=a[0];
			int rip=a[1];
			if (x==rip){
				for (int[]b:possibiliYF){
					int y=b[0];
					int rep=b[1];
					if (rep>rip){
						int prova=0;
						for (int[] u:pos){
							int px=u[0];
							int py=u[1];
							if (px==x&&py==y){
								prova=1;
							}
						}
						if (prova==0){
							int[] coor={x,y,rep};
							pos.add(coor);
						}
						
					}
				}
			}
		}
		return (long) pos.size();
	}
}
