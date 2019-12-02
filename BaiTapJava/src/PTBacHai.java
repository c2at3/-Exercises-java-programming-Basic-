import java.util.Scanner;

public class PTBacHai {
	private float a, b, c;

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap a: ");
			a = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap b: ");
			b = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap c: ");
			c = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			a = b = c = 0;
		}
	}

	public void pTrBacMot(float b, float c) {
		if (b == 0) {
			if (c == 0) {
				System.out.println("Ptrinh co vo so nghiem!");
			} else {
				System.out.println("Ptrinh vo nghiem!");
			}
		} else {
			System.out.println("Ptrinh co nghiem: X = " + (-c / b));
		}
	}

	public void pTrBacHai() {
		if (a == 0) {
			pTrBacMot(b, c);
		} else {
			float delta = b * b - 4 * a * c;
			if (delta > 0) {
				System.out.println("Phuong trinh co 2 nghiem: ");
				System.out.println("X1 = " + ((-b + Math.sqrt(delta)) / (2 * a)));
				System.out.println("X2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
			}
			if (delta < 0) {
				System.out.println("Phuong trinh vo nghiem!");
			}
			if (delta == 0) {
				System.out.println("Ptrinh co nghiem kep: X = " + (-b / (2 * a)));
			}
		}
	}

	public void xuat() {
		System.out.println("Ptrinh vua nhap: " + a + "x2 + " + b + "x + " + c + " = 0");

	}

	public static void main(String[] args) {
		PTBacHai ptr = new PTBacHai();
		ptr.nhap();
		ptr.xuat();
		ptr.pTrBacHai();

	}

}
