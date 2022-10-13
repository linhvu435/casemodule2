package Case.Managers;

import Case.IO.IOCart;
import Case.IO.IOFood;
import Case.IO.IOHotel;
import Case.OOP.Acount;
import Case.OOP.Food;
import Case.OOP.Hotel;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageCart {
    File fileCart = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Cart");
    File fileFood = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Food.txt");
    File fileHotel = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Hotel.txt");
    File fileCart1 = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Cart1");
    IOCart ioCart = new IOCart();
    IOFood ioFood = new IOFood();
    IOHotel<Hotel> ioHotel = new IOHotel<>();
    ArrayList<Hotel> arrCart = ioCart.read(fileCart);
    ArrayList<Food> arrCart1 = ioCart.read(fileCart1);
    ArrayList<Hotel> arrhotel = ioHotel.read(fileHotel);
    ArrayList<Food> arrFood = ioFood.read(fileFood);
    Food food = new Food();
    Scanner sc = new Scanner(System.in);
    int id =0;
    int index =0;
    int number = 0;

    public void PickRoom()
    {
        for (int i = 0; i < arrhotel.size(); i++) {
            System.out.println(arrhotel.get(i).toString());
        }
        System.out.println("Nhập ID Phòng Bạn Muốn Chọn");
        while (true) {
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập Số Để Chọn ID");
                continue;
            }
            index = FindIDRoom(id);
            if(index!=-1)

            {
                System.out.println("Bạn Đã Chọn Phòng : " + arrhotel.get(index).toString());
                arrCart.add(arrhotel.get(index));
                arrhotel.remove(index);
                return;
            }
            else {
                System.out.println("ID Không Tồn Tại");
            }
        }
    }
    public void ReturnsRoom()
    {
        System.out.println("Nhập ID Phòng Bạn Muốn Trả Lại");
        while (true)
        {
            try {
                id= Integer.parseInt(sc.nextLine());
            }catch (Exception e)
            {
                System.out.println("Nhập Lại ID Phòng Bạn Muốn Trả");
                continue;
            }
            index = FindIDRoomInCart(id);
            if (index == -1)
            {
                System.out.println("Không Tồn Tại ID Phòng Mà Bạn Đã Chọn");
            }
            else
            {
                arrhotel.add(arrCart.get(index));
                System.out.println("Đã Xóa Phòng :" + arrCart.get(index));
                arrCart.remove(index);
                return;
            }
        }

    }
    public int FindIDRoomInCart(int id)
    {
        for (int i = 0; i < arrCart.size(); i++) {
            if(arrCart.get(i).getId()==id)
            {
                return i;
            }
        }
        return -1;
    }
    public int FindIDRoom(int id)
    {
        for (int i = 0; i < arrhotel.size(); i++) {
            if(arrhotel.get(i).getId() == id)
            {
                return i;
            }
        }
        return -1;
    }
    public void ReturnsFood()
    {
        System.out.println("Nhập ID Đồ Ăn Bạn Muốn Trả Lại");
        while (true)
        {
            try {
                id = Integer.parseInt(sc.nextLine());
            }catch (Exception e)
            {
                System.out.println("Nhập Lại ID Đồ Ăn Bạn Muốn Trả Lại");
                continue;
            }
            index = FindIdFoodCart1(id);
            if(index == -1)
            {
                System.out.println("Không Tồn Tại Món Ăn Có ID Bạn Đã Chọn");
            }
            else {
                arrFood.add(arrCart1.get(index));
                System.out.println("Đã Xóa Món Ăn : " + arrCart1.get(index));
                arrCart1.remove(index);
                return;
            }
        }
    }

    public int FindIdFoodCart1(int id)
    {
        for (int i = 0; i < arrCart1.size(); i++) {
            if(arrCart1.get(i).getFoodID()==id){
                return i;
            }
        }
        return -1;
    }

    public int FindIDFood(int id)
    {
        for (int i = 0; i < arrFood.size(); i++) {
            if(arrFood.get(i).getFoodID()==id)
            {
                return i;
            }
        }
        return -1;
    }

    public void PickFood()
    {
        for (int i = 0; i < arrFood.size(); i++) {
            System.out.println(arrFood.get(i).toString());
        }
        System.out.println("Nhập ID Đồ Ăn ");
        while (true)
        {
            try{
                id = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Nhập Số Để Chọn ID");
                continue;
            }
            index = FindIDFood(id);
            if(index!=-1)
            {
                System.out.println("Bạn Đã Chọn Món : " + arrFood.get(index).toString());
                arrCart1.add(arrFood.get(index));
                arrFood.remove(index);
                return;
            }
            else {
                System.out.println("ID Không Tồn Tại");
            }
        }
    }

    public void showCart()
    {
        if (arrCart.size() == 0 && arrCart1.size() == 0){
            System.out.println("Chưa Đặt Sản Phẩm");
        }
        else {
            for (int i = 0; i < arrCart.size(); i++) {
                System.out.println(arrCart.get(i).toString());
            }
            for (int i =0; i<arrCart1.size();i++)
            {
                System.out.println(arrCart1.get(i).toString());
            }
            System.out.println("Tổng Số Tiền Là : " + totalPrice());
        }
    }
    public double PriceHotel()
    {
        double sum = 0;
        for (int i = 0; i < arrCart.size(); i++) {
            sum += arrCart.get(i).getPrice();
        }
        return sum;
    }
    public double PriceFood()
    {
        double sum = 0;
        for (int i = 0; i < arrCart1.size(); i++) {
            sum += arrCart1.get(i).FoodPrice;
        }
        return sum;
    }
    public double totalPrice()
    {
        double sum = PriceFood()+PriceHotel();
        return sum;
    }
}
