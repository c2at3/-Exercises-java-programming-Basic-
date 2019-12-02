# Bài tập Lập trình Java cơ bản - ICTU
## Bài 1: bài tập tổng hợp 11
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

 ***