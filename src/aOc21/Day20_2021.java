package aOc21;
import java.util.LinkedList;

import program.Read;

public class Day20_2021 {
	public static long calculate1(String s) {
		long fin=calculate(s, 2);

		return fin;
	}
	
	public static long calculate2(String s) {
		long fin=calculate(s, 50);

		return fin;
	}
	
	public static long calculate(String s, int z) {
		String[] inp=s.split("\\n\\n");
		String[] algo = inp[0].split("");
		int[] ritmo = new int[algo.length];
		for (int d = 0; d < algo.length; d++) {
			if (algo[d].equals("#")) {
				ritmo[d] = 1;
			}
		}
		LinkedList<int[]> input =Read.inp(inp[1]);
		int t=0;
// ----- change this giri int to chose how many time to enhance the pic (2 for part-1 and 50 for part-2)-------
		int giri = z;
		
// enhance the pic for GIRI times
		while (t < giri) {
			LinkedList<int[]> img = margine(input, t);
			input.clear();

			for (int i = 1; i < (img.size() - 1); i++) {
				int[] temp = new int[img.get(0).length];

				for (int h = 1; h < (img.get(i).length) - 1; h++) {
					int[] coor = { i, h };
					int[] bb = binario(img, coor);
					int val = decimale(bb);
					int chiaro = schiara(ritmo, val);
					temp[h] = chiaro;
				}
				input.add(temp);

			}

			t++;
		}
// caculate and print result
		int finalee = conta(input);
		return (long) finalee;
	}
	// method from binary to dec
		public static int decimale(int[] w) {
			int l = w.length;
			int[] bin = new int[l];
			for (int i = 0; i < l; i++) {
				bin[l - 1 - i] = (int) Math.pow(2, i);
			}
			int val = 0;
			for (int g = 0; g < l; g++) {
				val = val + (w[g] * bin[g]);
			}
			return val;
		}

	// method to put a margin around the pic
		public static LinkedList<int[]> margine(LinkedList<int[]> w, int b) {
			int a = b % 2;
			LinkedList<int[]> aaa = new LinkedList<int[]>();
			int marr = 2;
			for (int i = 0; i < marr; i++) {
				int[] mar = new int[(w.get(0).length + (marr * 2))];
				if (a == 1) {
					for (int u = 0; u < mar.length; u++) {
						mar[u] = 1;
					}
				}
				aaa.add(mar);
			}

			for (int[] u : w) {
				int[] mar = new int[(w.get(0).length + (marr * 2))];
				for (int e = 0; e < (w.get(0).length); e++) {
					mar[e + marr] = u[e];
				}
				if (a == 1) {
					for (int p = 0; p <= marr; p++) {
						mar[p] = 1;
						mar[(mar.length) - (p + 1)] = 1;
					}
				}
				aaa.add(mar);
			}
			for (int i = 0; i < marr; i++) {
				int[] mar = new int[(w.get(0).length + (marr * 2))];
				if (a == 1) {
					for (int u = 0; u < mar.length; u++) {
						mar[u] = 1;
					}
				}
				aaa.add(mar);
			}
			return aaa;
		}

	// count lit points
		public static int conta(LinkedList<int[]> w) {
			int tot = 0;
			for (int[] u : w) {
				for (int q : u) {
					if (q == 1) {
						tot = tot + 1;
					}
				}
			}
			return tot;
		}

	// extrapolate binary into int[]
		public static int[] binario(LinkedList<int[]> w, int[] e) {
			int[] binario = new int[9];
			int x = (e[0]) - 1;
			int y = (e[1]) - 1;
			binario[0] = w.get(x)[y];
			binario[1] = w.get(x)[y + 1];
			binario[2] = w.get(x)[y + 2];
			binario[3] = w.get(x + 1)[y];
			binario[4] = w.get(x + 1)[y + 1];
			binario[5] = w.get(x + 1)[y + 2];
			binario[6] = w.get(x + 2)[y];
			binario[7] = w.get(x + 2)[y + 1];
			binario[8] = w.get(x + 2)[y + 2];
			return binario;
		}

	// find out if the point is light or dark
		public static int schiara(int[] w, int e) {
			int val = w[e];
			return val;
		}
}
