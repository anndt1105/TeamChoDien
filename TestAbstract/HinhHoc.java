
public class HinhHoc {
	private double size1;
	private double size2;
	
	public HinhHoc() {
		
	}
	public HinhHoc(double size1) {
		this.size1 = size1;
	}
	public HinhHoc(double size1, double size2) {
		this.size1 = size1;
		this.size2 = size2;
	}
	public double getSize1() {
		return size1;
	}
	public void setSize1(double size1) {
		this.size1 = size1;
	}
	public double getSize2() {
		return size2;
	}
	public void setSize2(double size2) {
		this.size2 = size2;
	}
	public double tinhChuVi(double size1, double size2) {
		return (size1+size2)*2;
	}
	public double tinhDienTich(double size1, double size2) {
		return size1*size2;
	}
	
	public void justDisplay(double size1, double size2) {
		System.out.println("Chieu dai: "+size1);
		System.out.println("Chieu rong: "+size2);
		System.out.println("--Chu Vi cua hinh la--"+tinhChuVi(size1, size2));
		System.out.println("--Dien tich Vi cua hinh la--"+tinhDienTich(size1, size2));
	}
}
