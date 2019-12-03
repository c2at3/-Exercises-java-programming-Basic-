import java.util.Scanner;

public class ToanHoc {
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
			if (m < 2 || m > 100)
				System.out.println("Nhap lai!!!\n");
		} while (m < 2 || m > 100);
	}

	boolean isSNT(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void mSNT_dauTien() {
		int dem = 0;
		int i = 0;
		System.out.println(m + " so nguyen to dau tien: ");
		while (dem < m) {
			if (isSNT(i)) {
				dem++;
				System.out.print("\t " + i);
			}
			i++;
		}
	}

	public static void main(String[] args) {
		ToanHoc th = new ToanHoc();
		th.nhap();
		th.mSNT_dauTien();

	}

}
