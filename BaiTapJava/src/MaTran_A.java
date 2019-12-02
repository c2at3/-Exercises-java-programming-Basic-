import java.util.Scanner;

public class MaTran_A {
	private int m;
	private int A[][];

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap so phan tu: ");
				m = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				m = -1;
			}
		} while (m < 2 || m > 100);

		A = new int[m][m];
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				try {
					System.out.print("A[" + i + "]["+j+"] = ");
					A[i][j] = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					A[i][j] = 0;
				}
			}
		}
	}

	public void demBoi3() {
		int dem = 0;
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				if (A[i][j] % 3 == 0) {
					dem++;
				}
			}
		}
		System.out.println("Tong cong cac so la boi cua 3: " + dem);
	}

	boolean isSHH(int n) {
		int s = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				s += n/i;
			}
		}
		if (s == n) {
			return true;
		}
		return false;
	}

	public void TBC_HH() {
		int dem = 0;
		int sum = 0;
		System.out.println("Cac shh: ");
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				if (isSHH(A[i][j])) {
					dem++;
					sum += A[i][j];
				}
			}
		}
		if(dem == 0) {
			System.out.println("\nTBC cac so hoan hao = 0");
		} else {
			System.out.println("\nTBC cac so hoan hao: " + sum / dem);			
		}
	}

	public void xuat() {
		System.out.println("\nMa tran A vua nhap:");
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				System.out.print("\t "+A[i][j]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		MaTran_A mt = new MaTran_A();
		mt.nhap();
		mt.xuat();
		mt.demBoi3();
		mt.TBC_HH();
	}

}
