package Case.Menu;

import Case.Managers.ManageAccount;
import Case.Managers.ManageHotel;
import Case.OOP.Acount;

import java.util.Scanner;

public class MenuAccount {
    Scanner sc = new Scanner(System.in);
    ManageAccount manageAccount = new ManageAccount();
    MenuHotel menuHotel = new MenuHotel();
    MenuUser menuUser = new MenuUser();
    MenuFood menuFood = new MenuFood();
    MenuAdmin menuAdmin = new MenuAdmin();
    int choice = 0;
    int number = 0;

    public void menu() {
        while (true) {

            System.out.println("Chào mừng bạn đến với chúng tôi.");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice <= 0 || choice > 3) {
                    System.out.println("Nhập Số Từ 1-3");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Nhập Số Từ 1-3");
                continue;
            }

            boolean isBreak = false;
            switch (choice) {
                case 1:
                    Acount acount = manageAccount.Login();
                    if (acount != null && acount.getRole().equals("admin")) {
                        while (!isBreak) {
                            System.out.println("Nhập Số Để Chọn");
                            System.out.println("1. Quản Lý Khách Sạn");
                            System.out.println("2. Quản Lý Đồ Ăn");
                            System.out.println("3. Quản Lý Nhân Viên");
                            System.out.println("4. Thoát");
                            try {
                                number = Integer.parseInt(sc.nextLine());
                                if (number <= 0 || number > 4) {
                                    System.out.println("Nhập Số Từ 1-4");
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println("Nhập Số Từ 1-4");
                                continue;
                            }
                            switch (number) {
                                case 1:
                                    menuHotel.menu();
                                    break;
                                case 2:
                                    menuFood.menu();
                                    break;
                                case 3:
                                  menuAdmin.menu();
                                  break;
                                case 4:
                                    isBreak = true;
                                    break;
                            }
                        }
                    }
                    if (acount != null && acount.getRole().equals("user")) {
                        menuUser.menu();
                    }
                    else  {
                        System.out.println("Tài Khoản Không Tồn Tại");
                    }
                    break;
                case 2:
                    manageAccount.register();
                    break;
                case 3:
                    return;
            }
        }
    }
}
