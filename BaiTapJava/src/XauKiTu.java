import java.util.Scanner;

public class XauKiTu {
	private String st;

	public XauKiTu() {
	}

	public XauKiTu(String st) {
		this.st = st;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi: ");
		st = sc.nextLine();
	}

	public void demSo() {
		int dem = 0;
		for (int i = 0; i < st.length(); i++) {
			if (Character.isDigit(st.charAt(i))) {
				dem++;
			}
		}
		System.out.println("\n>> So ki tu la CHU SO trong chuoi: " + dem);
	}

	public void ketThu_H() {
		StringBuffer st2;
		st2 = new StringBuffer(st);
		int dem = 0;
		for (int i = 0; i < st.length() - 1; i++) {
			if (st.charAt(i) == 'H' && st.charAt(i + 1) == ' ') {
				dem++;
			}
		}
		if (st.charAt((st.length() - 1)) == 'H')
			dem++;
		System.out.println("\n>> So tu ket thu la ki tu H la: " + dem);
	}

	public void chuanHoaXau() {
		StringBuffer st2;
		st = st.trim();
		System.out.println(">> Xoa khoang trang dau cuoi: " + st);

		st2 = new StringBuffer(st);

		// Dùng while cho ngắn cũng đc :v
		for (int i = 0; i < st2.length() - 1; i++) {
			while (st2.charAt(i) == ' ' && st2.charAt(i + 1) == ' ') {
				st2.deleteCharAt(i);
			}
		}
		System.out.println(">> Xoa khoang trang thua: " + st2);

		st = new String(st2);
		st = st.toLowerCase();
		Character ch = st2.charAt(0);
		ch = Character.toUpperCase(ch);
		st2.setCharAt(0, ch);
		for (int i = 0; i < st.length(); i++) {
			if (st2.charAt(i) == ' ' && st2.charAt(i + 1) != ' ') {
				ch = Character.toUpperCase(st2.charAt(i + 1));
				st2.setCharAt(i + 1, ch);
			}
		}
		st = new String(st2);
		System.out.println(">> Chu Hoa cac tu: " + st);

	}

	public static void main(String[] args) {
		XauKiTu xkt = new XauKiTu();
		xkt.nhap();
		xkt.demSo();
		xkt.ketThu_H();
		xkt.chuanHoaXau();
	}

}
