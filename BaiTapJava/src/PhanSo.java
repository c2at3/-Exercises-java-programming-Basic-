import java.util.Scanner;

public class PhanSo {
	private int tuSo;
	private int mauSo;

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap tu so: ");
				tuSo = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap mau so: ");
				mauSo = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				tuSo = 0;
				mauSo = 0;
			}
			if (mauSo == 0)
				System.out.println("Nhap lai!!!\n");
		} while (mauSo == 0);
	}

	public int UCLN(int tuSo, int mauSo) {
		tuSo = this.tuSo;
		mauSo = this.mauSo;
		tuSo = Math.abs(tuSo);
		mauSo = Math.abs(mauSo);
		if (tuSo == 0) {
			return 1;
		}
		while (tuSo != mauSo) {
			if (tuSo > mauSo)
				tuSo = tuSo - mauSo;
			if (mauSo > tuSo)
				mauSo = mauSo - tuSo;
		}
		return tuSo;
	}
	
	public void rutGon() {
		int mauSoChung = UCLN(tuSo, mauSo);
		tuSo = tuSo/mauSoChung;
		mauSo = mauSo/mauSoChung;
		System.out.println("Rut gon: "+tuSo+"/"+mauSo);
	}

	public void hienThi() {
		System.out.println("Rut gon: "+tuSo+"/"+mauSo);
	}

	public static void main(String[] args) {
		PhanSo ps = new PhanSo();
		ps.nhap();
		ps.hienThi();
		ps.rutGon();
	}

}
