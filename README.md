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
## Bài 2:
Bài tổng hợp số 8
### **Câu 1**: Lớp Phân số có 2 thuộc tính là các số nguyên xác định tử số và mẫu số. Hãy xây dựng lớp PhanSo có các thuộc tính như trên và có phương thức sau:
* a. Phương thức nhapDL() để nhập vào một phân số.
* b. Tìm dạng tối giản của phân số đã nhập.

``` java
import java.util.Scanner;

public class PhanSo {

	private int tuSo;
	private int mauSo;

	public void nhapDL() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap Tu so: ");
				tuSo = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap Mau so: ");
				mauSo = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				tuSo = 0;
				mauSo = 0;
			}
			if (mauSo == 0)
				System.err.println("Nhap sai!!!\nMau so phai khac 0!\nMau so la mot so\nNhap lai!!");
		} while (mauSo == 0);

	}

	public void hienDL() {
		System.out.println("Phan so vua nhap: " + tuSo + "/" + mauSo);
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
			if (tuSo > mauSo) {
				tuSo -= mauSo;
			} else {
				mauSo -= tuSo;
			}
		}
		return mauSo;
	}

	public void rutGon() {
		int UCLN = UCLN(tuSo, mauSo);
		tuSo = tuSo / UCLN;
		mauSo = mauSo / UCLN;
		System.out.println("Dang toi gian: " + tuSo + "/" + mauSo);
	}

	public static void main(String[] args) {
		PhanSo ps = new PhanSo();
		ps.nhapDL();
		ps.hienDL();
		ps.rutGon();
	}

}

```

### **Câu 2: Chưa cập nhật

***

# Bài 3:
Bài tổng hợp số 4
## Câu 1:

```java
import java.util.Scanner;

public class MaTran_A {
	private int m;
	private int A[][];

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Nhap so phan tu: ");
				m = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				m = -1;
			}
		} while (m < 2 || m > 100);

		A = new int[m][m];
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				try {
					System.out.print("A[" + i + "]["+j+"] = ");
					A[i][j] = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					A[i][j] = 0;
				}
			}
		}
	}

	public void demBoi3() {
		int dem = 0;
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				if (A[i][j] % 3 == 0) {
					dem++;
				}
			}
		}
		System.out.println("Tong cong cac so la boi cua 3: " + dem);
	}

	boolean isSHH(int n) {
		int s = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				s += n/i;
			}
		}
		if (s == n) {
			return true;
		}
		return false;
	}

	public void TBC_HH() {
		int dem = 0;
		int sum = 0;
		System.out.println("Cac shh: ");
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				if (isSHH(A[i][j])) {
					dem++;
					sum += A[i][j];
				}
			}
		}
		if(dem == 0) {
			System.out.println("\nTBC cac so hoan hao = 0");
		} else {
			System.out.println("\nTBC cac so hoan hao: " + sum / dem);			
		}
	}

	public void xuat() {
		System.out.println("\nMa tran A vua nhap:");
		for (int i = 0; i < m; i++) {
			for(int j = 0;j<m;j++) {
				System.out.print("\t "+A[i][j]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		MaTran_A mt = new MaTran_A();
		mt.nhap();
		mt.xuat();
		mt.demBoi3();
		mt.TBC_HH();
	}

}

```

## Câu 2:

```java
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

```

***

 ***
**_Contact me_**: [Trần Bá Quang](https://www.facebook.com/quang.tranba.37)