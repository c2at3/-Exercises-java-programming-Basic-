import java.util.Scanner;

class NhanSu {
	private int maSo;
	private String hoTen;
	private String trinhDo;
	protected int namTuyenDung;

	// construciton : Phuong thuc tao lap
	NhanSu() {

	}

	NhanSu(int maSo, String hoTen) {
		maSo = this.maSo;
		hoTen = this.hoTen;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap ma so: ");
			maSo = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap ho ten: ");
			hoTen = sc.nextLine();
			System.out.print("Nhap trinh do: ");
			trinhDo = sc.nextLine();
			System.out.print("Nhap nam tuyen dung: ");
			namTuyenDung = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			maSo = 0;
			hoTen = "Khong xac dinh";
			trinhDo = "Khong co";
			namTuyenDung = 2019;
		}
	}

	public void hienThi() {
		System.out.println("Ma so: " + maSo);
		System.out.println("Ho ten: " + hoTen);
		System.out.println("Trinh do: " + trinhDo);
		System.out.println("Nam tuyen dung: " + namTuyenDung);
	}

}

public class QL_NhanSu {
	NhanSu ns[];
	private int sl;

	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap so luong nhan su: ");
				sl = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				sl = -1;
			}
			if (sl < 1)
				System.err.println("ERROR!\nNhap lai!\n");
		} while (sl < 1);

		ns = new NhanSu[sl];
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhap nhan su thu " + (i + 1) + ":");
			ns[i] = new NhanSu();
			ns[i].nhap();
			System.out.println("\n");
		}
	}

	public void hienThiDS() {
		for (int i = 0; i < sl; i++) {
			ns[i].hienThi();
		}
	}

	public void timKiem() {
		int m;
		int dem = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap nam can tim kiem: ");
			m = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			m = 2019;
		}

		System.out.println("==> Danh sach nhan su duoc tuyen sau nam " + m + " gom: ");
		for (int i = 0; i < sl; i++) {
			if (ns[i].namTuyenDung > m) {
				dem++;
				ns[i].hienThi();
				System.out.println("\n");
			}
		}
		System.out.println("==> So luong nhan su duoc tuyen: " + dem);
	}

	public static void main(String[] args) {
		QL_NhanSu ql = new QL_NhanSu();
		ql.nhapDS();
		System.out.println("================DANH SACH NHAN SU DA NHAP=============");
		ql.hienThiDS();
		System.out.println("================TIM KIEM NHAN SU==============");
		ql.timKiem();

	}

}
