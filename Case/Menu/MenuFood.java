package Case.Menu;

import Case.Managers.ManageFood;
import Case.OOP.Food;
import Case.OOP.Hotel;

import java.util.Scanner;

public class MenuFood {
    Scanner sc = new Scanner(System.in);
    ManageFood manageFood = new ManageFood();
    int choice =0;
    public void menu()
    {
        while (true)
        {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice <=0 || choice >5)
                {
                    System.out.println("Nhập Số Từ 1-5");
                }
            }catch (Exception e)
            {
                System.out.println("Nhập Số Từ 1-5");
                continue;
            }

            switch (choice) {
                case 1:
                    manageFood.show();
                    break;
                case 2:
                    Food food = manageFood.creat();
                    manageFood.add(food);
                    break;
                case 3:
                    manageFood.edit();
                    break;
                case 4:
                    manageFood.delete();
                    break;
                case 5:
                    return;
            }
        }

    }
}
