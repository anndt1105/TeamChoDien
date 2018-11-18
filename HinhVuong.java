
public class HinhVuong extends HinhHoc{
	public double tinhChuVi(double size1) {
		return size1*4;
	}
	public double tinhDienTich(double size1) {
		return size1*size1;
	}
	public void justDisplay(double size1) {

		System.out.println("Chieu dai cua canh: "+size1);
		System.out.println("--Chu Vi cua hinh chu nhat la--"+tinhChuVi(size1));
		System.out.println("--Dien tich Vi cua hinh chu nhat--"+tinhDienTich(size1));
	}
}
