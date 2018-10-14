
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		HinhHoc hinhCN=new HinhHoc();
		hinhCN.setSize1(5);
		hinhCN.setSize2(7);
		System.out.println("\n"+"======Hinh Chu Nhat=======");
		hinhCN.justDisplay(hinhCN.getSize1(), hinhCN.getSize2());
		
		HinhVuong hinhVuong=new HinhVuong();
		hinhVuong.setSize1(8);
		System.out.println("\n"+"======Hinh Vuong=======");
		hinhVuong.justDisplay(hinhVuong.getSize1()); 
		
		HinhTron hinhTron=new HinhTron();
		hinhTron.setSize1(8);
		System.out.println("\n"+"======Hinh Tron=======");
		hinhTron.justDisplay(hinhTron.getSize1());
	}

}
