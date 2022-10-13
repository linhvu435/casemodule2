package Case.Menu;

import Case.IO.IOFood;
import Case.IO.IOHotel;
import Case.Managers.ManageCart;
import Case.OOP.Food;
import Case.OOP.Hotel;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUser {
    File file = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Hotel.txt");
    File filefood = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Food.txt");
    IOHotel<Hotel> ioHotel = new IOHotel<>();
    IOFood ioFood = new IOFood();
    ArrayList<Hotel> arrhotel = ioHotel.read(file);
    ArrayList<Food> arrfood = ioFood.read(filefood);

    Scanner sc = new Scanner(System.in);
    ManageCart manageCart = new ManageCart();
    int number =0;


    public void menu() {
        System.out.println("Kính Chào Quý Khách");

        while (true) {
            System.out.println("1. Chọn Phòng Theo ID");
            System.out.println("2. Chọn Đồ Ăn Theo ID");
            System.out.println("3. Kiểm Tra Giỏ Hàng");
            System.out.println("4. Thoát");
            try{
                number = Integer.parseInt(sc.nextLine());
                if (number<=0 || number>4)
                {
                    System.out.println("Nhập Số Từ 1-4");
                    continue;
                }
            }catch (Exception e)
            {
                System.out.println("Nhập Số Từ 1-4");
                continue;
            }
            switch (number) {
                case 1:
                    manageCart.PickRoom();
                    break;
                case 2:
                    manageCart.PickFood();
                    break;
                case 3:
                    boolean check = false;
                    System.out.println("Nhập Số Từ 1-4 Để Chọn");
                    while (!check)
                    {
                        System.out.println("1. Hiển Thị Giỏ Hàng");
                        System.out.println("2. Trả Lại Phòng");
                        System.out.println("3. Trả Lại Đồ Ăn");
                        System.out.println("4. Thoát");
                        try {
                            number = Integer.parseInt(sc.nextLine());
                            if (number<0||number>4)
                            {
                                System.out.println("Nhập Số Từ 1-4");
                            }
                        }catch (Exception e)
                        {
                            System.out.println("Nhập Số Từ 1-4");
                            continue;
                        }
                        switch (number){
                            case 1:
                                manageCart.showCart();
                                break;
                            case 2:
                                manageCart.ReturnsRoom();
                                break;
                            case 3:
                                manageCart.ReturnsFood();
                                break;
                            case 4:
                                check = true;
                                break;
                        }

                    }
                    break;
                    case 4:
                   return;
            }
        }

    }
}
