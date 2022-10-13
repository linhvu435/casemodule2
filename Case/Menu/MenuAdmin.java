package Case.Menu;


import Case.Managers.MangeAdmin;

import java.util.Scanner;

public class MenuAdmin {
    MangeAdmin manageAdmin = new MangeAdmin();
    int number = 0;
    Scanner sc = new Scanner(System.in);
    public  void menu()
    {
        while(true)
        {
            System.out.println("Chọn Số Để Thao Tác Với Nhân Viên");
            System.out.println("1. Hiển Thị Nhân Viên");
            System.out.println("2. Xóa Nhân Viên");
            System.out.println("3. Sửa Nhân Viên");
            System.out.println("4. Thoát");
            try {
                number = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập Số Từ 1-4");
                continue;
            }
            switch (number) {
                case 1:
                   manageAdmin.Show();
                    break;
                case 2:
                    manageAdmin.delete();
                    break;
                case 3:
                   manageAdmin.ChangeRoll();
                    break;
                case 4:
                    return;
            }
        }
    }


}
