import java.util.Scanner;

class SinhVien {
	private String hoTen;
	private int namSinh;
	private String lop;
	protected float diemTrungBinh;

	SinhVien() {

	}

	SinhVien(String hoTen, int namSinh, String lop, float diemTrungBinh) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.lop = lop;
		this.diemTrungBinh = diemTrungBinh;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("\nNhap ho ten: ");
			hoTen = sc.nextLine();
			System.out.print("Nhap nam sinh: ");
			namSinh = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap lop: ");
			lop = sc.nextLine();
			System.out.print("Nhap diem trung binh: ");
			diemTrungBinh = sc.nextFloat();
		} catch (Exception e) {
			hoTen = "Khong xac dinh";
			namSinh = 0;
			lop = "Khong xac dinh";
			diemTrungBinh = 0f;
		}
	}

	public void hienThi() {
		System.out.println("Ho ten: " + hoTen);
		System.out.println("Nam sinh: " + namSinh);
		System.out.println("Lop: " + lop);
		System.out.println("Diem trung binh: " + diemTrungBinh);
	}
}

public class QL_SinhVien {
	SinhVien sv[];
	private int sl;

	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap so luong sinh vien: ");
				sl = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				sl = -1;
			}
		} while (sl < 1);

		sv = new SinhVien[sl];

		for (int i = 0; i < sl; i++) {
			sv[i] = new SinhVien();
			sv[i].nhap();
			System.out.println("");
		}
	}
	
	public void hienThiDS() {
		for (int i = 0; i < sl; i++) {
			sv[i].hienThi();
			System.out.println("");
		}
	}
	
	public void sapXep() {
		for(int i = 0;i<sl;i++) {
			for(int j = i+1;j<sl;j++) {
				if(sv[i].diemTrungBinh < sv[j].diemTrungBinh) {
					SinhVien tg = sv[i];
					sv[i] = sv[j];
					sv[j] = tg;
				}
			}
		}
		hienThiDS();
	}

	public static void main(String[] args) {
		QL_SinhVien ql = new QL_SinhVien();
		ql.nhapDS();
		System.out.println("\n=====DANH SACH SINH VIEN=====");
		ql.hienThiDS();
		System.out.println("\n=====SAP XEP DANH SACH SINH VIEN=====");
		ql.sapXep();
		

	}

}
