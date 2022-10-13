package Case.Menu;

import Case.Managers.ManageHotel;
import Case.OOP.Hotel;

import java.util.Scanner;

public class MenuHotel {
    Scanner sc = new Scanner(System.in);
    ManageHotel manageHotel = new ManageHotel();
    int choice =0;
    public void menu() {
        while(true) {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice<=0 || choice >5)
                {
                    System.out.println("Chọn Số Từ 1-5");
                    continue;
                }
            }
            catch (Exception e)
            {
                System.out.println("Chọn Số Từ 1-5");
                continue;
            }

            switch (choice) {
                case 1:
                    manageHotel.show();
                    break;
                case 2:
                    Hotel ht = manageHotel.create();
                    manageHotel.add(ht);
                    break;
                case 3:
                    manageHotel.edit();
                    break;
                case 4:
                    manageHotel.delete();
                    break;
                case 5:
                    return;
            }
        }
    }
}
