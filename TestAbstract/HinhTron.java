
public class HinhTron extends HinhVuong{
	@Override
	public double tinhChuVi(double size1) {
		return size1*2*3.14;
	}
	
	@Override
	public double tinhDienTich(double size1) {
		return size1*size1*3.14;
	}
	@Override
	public void justDisplay(double size1) {
		System.out.println("Ban kinh cua hinh tron la: "+size1);
		System.out.println("--Chu Vi cua hinh chu nhat la--"+tinhChuVi(size1));
		System.out.println("--Dien tich Vi cua hinh chu nhat--"+tinhDienTich(size1));
	}
}
