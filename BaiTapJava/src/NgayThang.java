import java.util.Scanner;

public class NgayThang {
	private int nam;
	private int thang;
	private int ngay;

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.println("Nhap nam: ");
				nam = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				nam = -1;
			}
		} while (nam < 1);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.println("Nhap thang: ");
				thang = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				thang = -1;
			}
		} while (thang < 1 || thang > 12);
		if (thang != 2) {
			if (thang < 7 && thang % 2 != 0 || thang > 7 && thang % 2 == 0) {
				do {
					try {
						sc = new Scanner(System.in);
						System.out.println("Nhap ngay: ");
						ngay = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						ngay = -1;
					}
				} while (ngay < 1 || ngay > 31);
			} else {
				do {
					try {
						sc = new Scanner(System.in);
						System.out.println("Nhap ngay: ");
						ngay = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						ngay = -1;
					}
				} while (ngay < 1 || ngay > 30);
			}
		} else if (thang == 2 && nam % 400 == 0 || nam % 4 == 0 && nam % 100 != 0) {
			do {
				try {
					sc = new Scanner(System.in);
					System.out.println("Nhap ngay: ");
					ngay = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					ngay = -1;
				}
			} while (ngay < 1 || ngay > 29);
		} else {
			do {
				try {
					sc = new Scanner(System.in);
					System.out.println("Nhap ngay: ");
					ngay = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					ngay = -1;
				}
			} while (ngay < 1 || ngay > 28);
		}
	}

	public int soNgay(int thang) {
		if (thang != 2) {
			if (thang < 8 && thang % 2 != 0 || thang > 7 && thang % 2 == 0) {
				return 31;
			} else {
				return 30;
			}
		} else if (thang == 2 && nam % 400 == 0 || nam % 4 == 0 && nam % 100 != 0) {
			return 29;
		} else {
			return 28;
		}
	}

	public void hienThi() {
		System.out.println("Ngay vua nhap: " + ngay + "/" + thang + "/" + nam);
		int a[];
		int sum = 0;
		a = new int[12];
		for (int i = 1; i < thang; i++) {
			a[i] = soNgay(i);
			System.out.print("\t "+a[i]);
			sum += a[i];
		}
		System.out.println(ngay + "/" + thang + "/" + nam + " la ngay thu: " + (sum + ngay));
	}

	public static void main(String[] args) {
		NgayThang nt = new NgayThang();
		nt.nhap();
		nt.hienThi();

	}

}
