import java.util.Scanner;

public class SoHoc {
	private int m;

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap m: ");
				m = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				m = -1;
			}
		} while (m < 2 || m > 100);
	}

	public void soChinhPhuong() {
		System.out.println("Cac so chinh phuong nho hon " + m + ": ");
		for (int i = 0; i < m; i++) {
			if (Math.sqrt(i) % 1 == 0) {
				System.out.print("\t " + i);
			}
		}
	}

	public static void main(String[] args) {
		SoHoc sh = new SoHoc();
		sh.nhap();
		sh.soChinhPhuong();
	}

}
