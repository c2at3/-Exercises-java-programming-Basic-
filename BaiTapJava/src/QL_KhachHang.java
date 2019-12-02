import java.util.Scanner;

class KhachHang {
	private String maKH;
	protected String hoTen;
	protected int tuoi;
	private String diaChi;
	private int soDienThoai;
	private String email;

	KhachHang() {

	}

	KhachHang(String maKH, String hoTen) {
		maKH = this.maKH;
		hoTen = this.hoTen;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap ma khach hang: ");
			maKH = sc.nextLine();
			System.out.print("Nhap ho ten: ");
			hoTen = sc.nextLine();
			System.out.print("Nhap tuoi: ");
			tuoi = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap dia chi: ");
			diaChi = sc.nextLine();
			System.out.print("Nhap so dien thoai: ");
			soDienThoai = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap email: ");
			email = sc.nextLine();
		} catch (Exception e) {
			maKH = "Khong xac dinh";
			hoTen = "Khong xac dinh";
			tuoi = 0;
			diaChi = "Khong xac dinh";
			soDienThoai = 0;
			email = "Khong xac dinh";
		}
	}

	public void hienThi() {
		System.out.println("Ma khach hang: " + maKH);
		System.out.println("Ho ten: " + hoTen);
		System.out.println("Tuoi: " + tuoi);
		System.out.println("Dia chi: " + diaChi);
		System.out.println("So dien thoai: " + soDienThoai);
		System.out.println("Email: " + email + "\n");
	}
}

public class QL_KhachHang {
	KhachHang kh[];
	private int n;

	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap so luong khach hang: ");
				n = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				n = -1;
			}
			if (n < 1)
				System.err.println("ERROR!!\nNhap lai!!!\n");
		} while (n < 1);
		
		kh = new KhachHang[n];
		for(int i = 0;i<n;i++) {
			System.out.println("+, Nhap khach hang thu "+(i+1)+": ");
			kh[i] = new KhachHang();
			kh[i].nhap();
		}
	}
	
	public void hienThiDS() {
		for(int i = 0;i<n;i++) {
			kh[i].hienThi();
		}
	}
	
	public void sapXep() {
		KhachHang tg;
		for(int i = 0;i<n;i++) {
			for(int j = i+1;j<n;j++) {
				if(kh[i].tuoi > kh[j].tuoi) {
					tg = kh[i];
					kh[i] = kh[j];
					kh[j] = tg;
				}
			}
		}
		hienThiDS();
	}
	
	public void timKiem() {
		String name = "Nguyen Van Duc";
		name = name.trim();
		System.out.println("======Nhung khach hang co ten \"Nguyen Van Duc\"======");
		for (int i = 0;i<n;i++) {
			if(name.equalsIgnoreCase(kh[i].hoTen)) {
				kh[i].hienThi();
			}
		}
	}

	public static void main(String[] args) {
		QL_KhachHang ql = new QL_KhachHang();
		ql.nhapDS();
		System.out.println("========DANH SACH KHACH HANG========");
		ql.hienThiDS();
		System.out.println("========SAP XEP DANH SACH KHACH HANG========");
		ql.sapXep();
		ql.timKiem();
	}

}
