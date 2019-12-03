import java.util.Scanner;

import javax.sound.midi.SysexMessage;

class MaTran {
	private int m;
	private int n;
	private int M[][];

	MaTran() {
	}

	public MaTran(int m, int n, int[][] m2) {
		this.m = m;
		this.n = n;
		M = m2;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void setPhanTu(int m, int n, int pt) {
		this.M[m][n] = pt;
	}

	public int getPhanTu(int m, int n) {
		return this.M[m][n];
	}

	public void setMaTran(int m, int n) {
		this.m = m;
		this.n = n;
		M = new int[m][n];
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap so hang: ");
				m = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap so cot: ");
				n = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				m = -1;
				n = -1;
			}
		} while (m < 1 || n < 1);

		M = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				try {
					System.out.print("[" + i + "][" + j + "] = ");
					M[i][j] = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					M[i][j] = 0;
				}
			}
		}
	}

	public void xuat() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("\t " + M[i][j]);
			}
			System.out.println("");
		}
	}

}

public class XuLyMaTran {

	boolean isSNT(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public void demSNT(MaTran A) {
		int dem = 0;
		for (int i = 0; i < A.getM(); i++) {
			for (int j = 0; j < A.getN(); j++) {
				if (isSNT(A.getPhanTu(i, j))) {
					dem++;
				}
			}
		}
		System.out.println("\n>>So phan tu la so nguyen so trong ma tran A la: " + dem);
	}

	public void tong(MaTran A, MaTran B, MaTran C) {
		C.setMaTran(A.getM(), A.getN());
		if (A.getM() != B.getM() || A.getN() != B.getN()) {
			System.err.println("\n>>Hai Ma tran A va B co kich thuoc khong bang nhau!\n>>Khong the tinh!!\n>>Ahihi ^^");
		} else {
			System.out.println("\nA + B = \n");
			for (int i = 0; i < C.getM(); i++) {
				for (int j = 0; j < C.getN(); j++) {
					C.setPhanTu(i, j, A.getPhanTu(i, j) + B.getPhanTu(i, j));
					System.out.print("\t "+C.getPhanTu(i, j));
				}
				System.out.println("");
			}
		}
	}

	public static void main(String[] args) {
		XuLyMaTran xl = new XuLyMaTran();
		MaTran A = new MaTran();
		MaTran B = new MaTran();
		MaTran C = new MaTran();
		System.out.println("Nhap ma tran A:");
		A.nhap();
		System.out.println("\nNhap ma tran B:");
		B.nhap();
		System.out.println("======CAC MA TRAN VUA NHAP=====\n");
		System.out.println("======MA TRAN A=====\n");
		A.xuat();
		System.out.println("=====MA TRAN B=====\n");
		B.xuat();
		xl.demSNT(A);
		xl.tong(A, B, C);
		

	}

}
