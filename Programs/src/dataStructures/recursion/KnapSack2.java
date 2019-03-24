package dataStructures.recursion;

public class KnapSack2 {
	public static void main(String[] args) {

		int[] p = { 0, 15,12,8};
		int[] wt = { 0, 4,10,5};

		int m = 11, n = 3;
		int[][] k = new int[4][12];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= m; w++) {
				if (i == 0 || w == 0) {
					k[i][w] = 0;
				} else if (wt[i] <= w) {
					k[i][w] = Math.max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
				} else {
					k[i][w] = k[i - 1][w];
				}
			}

		}
		System.out.println(k[n][m]);

		int i = n;
		int j = m;

		while (i > 0 && j > 0) {
			if (k[i][j] == k[i - 1][j]) {
				i--;
			} else {
				System.out.print(wt[i]+" ");
				j = j - wt[i];
				i--;
			}
		}

	}
}
