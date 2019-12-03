import java.util.Scanner;

class Sach {
	private String tenSach;
	protected String tacGia;
	private int namXuatBan;

	Sach() {

	}

	Sach(String tenSach, String tacGia, int namXuatBan) {
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap ten ten sach: ");
			tenSach = sc.nextLine();
			System.out.println("Nhap tac gia: ");
			tacGia = sc.nextLine();
			System.out.println("Nhap nam xuat ban: ");
			namXuatBan = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			tenSach = "Chua xac dinh";
			tacGia = "Chua xac dinh";
			namXuatBan = 2019;
		}
	}

	public void hienThi() {
		System.out.println("Ten Sach: " + tenSach);
		System.out.println("Tac gia: " + tacGia);
		System.out.println("Nam xuat ban: " + namXuatBan);
	}

}

public class QL_Sach {
	Sach s[];
	private int sl;

	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.println("Nhap so luong Sach: ");
				sl = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				sl = -1;
			}
		} while (sl < 1);

		s = new Sach[sl];
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhap thong tin sach thu " + (i + 1) + ": ");
			s[i] = new Sach();
			s[i].nhap();
			System.out.println("");
		}
	}

	public void hienThiDS() {
		for (int i = 0;i<sl ;i++) {
			s[i].hienThi();
			System.out.println("");
		}
	}
	
	public void timKiem() {
		String name;	
		Scanner sc =new Scanner(System.in);
		System.out.println("Nhap ten tac gia: ");
		name = sc.nextLine();
		name = name.trim();
		System.out.println("Ket qua tim kiem cho tac gia: "+name+": ");
		for(int i = 0;i<sl;i++) {
			if(s[i].tacGia.equalsIgnoreCase(name)) {
				s[i].hienThi();
			}
		}
	}

	public static void main(String[] args) {
		QL_Sach ql = new QL_Sach();
		ql.nhapDS();
		System.out.println("\n======DANH SACH THONG TIN SACH=====");
		ql.hienThiDS();
		ql.timKiem();
	}

}
