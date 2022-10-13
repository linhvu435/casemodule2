package Case.Managers;

import Case.IO.IOFood;
import Case.OOP.Food;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageFood {
    File file = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Food.txt");
    IOFood ioFood = new IOFood();
    ArrayList<Food> arrFood = ioFood.read(file);
    Scanner sc = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < arrFood.size(); i++) {
            System.out.println(arrFood.get(i).toString());
        }
    }

    public void add(Food food) {
        arrFood.add(food);
        ioFood.write(file, arrFood);
    }

    public int FindFoodId(int id) {
        for (int i = 0; i < arrFood.size(); i++) {
            if (id == arrFood.get(i).getFoodID()) {
                return i;
            }
        }
        return -1;
    }

    int id = 0;
    int index = 0;
    int FoodPrice = 0;
    int number =0;
    public Food creat() {

        while (true) {
            System.out.println("Nhập ID Đồ Ăn ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập Chữ Số");
                continue;
            }
            index = FindFoodId(id);
            if (index == -1) {
                System.out.println("Nhập Tên Đồ Ăn");
                String FoodName = sc.nextLine();
                while (true) {
                    System.out.println("Nhập Giá Đồ Ăn");
                    try {
                        FoodPrice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Nhập Số Cho Giá Đồ Ăn");
                        continue;
                    }
                    while (true)
                    {
                        System.out.println("Nhập Số Lượng Cho Đồ Ăn");
                        try {
                            number = Integer.parseInt(sc.nextLine());
                        }catch (Exception e)
                        {
                            System.out.println("Nhập Chữ Số Cho Số Lượng Của Món Ăn");
                            continue;
                        }
                        System.out.println("Thành Công");
                        return new Food(id, FoodName, FoodPrice,number);
                    }

                }
            } else {
                System.out.println("ID Đã Tồn Tại");
            }

        }

    }

    public void edit() {
        while (true) {
            System.out.println("Nhập ID Bạn Muốn Sửa");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập Số Cho ID");
                continue;
            }
            index = FindFoodId(id);
            if (index != -1) {
                arrFood.set(index, creat());
                return;
            } else {
                System.out.println("ID Không Tồn Tại");
            }
        }


    }

    public void delete() {
        while (true) {
            System.out.println("Nhập ID Bạn Muốn Xóa");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập Chữ Số");
                continue;
            }

            int index = FindFoodId(id);

            if (index != -1) {
                arrFood.remove(index);
                ioFood.write(file, arrFood);
                System.out.println("Đã Xóa");
                return;

            } else {
                System.out.println("ID Không Tồn Tại");
            }
        }
    }
}

