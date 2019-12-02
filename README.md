# Bài tập Lập trình Java cơ bản - ICTU
## Bài 1:
Bài tập tổng hợp 11
### **Câu 1**: Lớp các bài toán phương trình bậc 2 có dạng: ax2 + bx + c = 0 với a, b, c là các hệ số được nhập từ bàn phím.
Hãy xây dựng lớp PTBacHai có các thuộc tính a, b, c và có các phương thức:

* Nhập và hiển thị một phương trình bậc 2

* Viết chương trình nhập vào một phương trình bậc 2 và in ra nghiệm của phương trình đã nhập.

``` java
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
```
### **Câu 2**: Một công ty cần quản lý hồ sơ nhân sự gồm các thông tin: mã số, họ và tên, trình độ, năm tuyển dụng.

  **a.** Hãy xây dựng một lớp NhanSu có các thuộc tính như trên và các phương thức sau:
     
* Một số toán tử tạo lập.
* Phương thức để nhập thông tin của một nhân sự.
* Phương thức để hiển thị thông tin của một nhân sự.

**b.** Xây dựng lớp QL_NhanSu, với các phương thức:
   
 * Nhập và hiển thị một danh sách các nhân sự của một công ty.
 * Nhập vào một số nguyên m đại diện cho năm tuyển dụng. Đếm số và hiện thị của các nhân sự được tuyển dụng sau năm đó.

``` java
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

```
 ***
**_Contact me_**: [Trần Bá Quang](https://www.facebook.com/quang.tranba.37)