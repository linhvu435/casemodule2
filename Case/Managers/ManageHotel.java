package Case.Managers;

import Case.IO.IOHotel;
import Case.OOP.Acount;
import Case.OOP.Hotel;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageHotel {
    File file = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Hotel.txt");
    IOHotel<Hotel> ioHotel = new IOHotel<>();
    ArrayList<Hotel> arrhotel = ioHotel.read(file);
    Scanner sc = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < arrhotel.size(); i++) {
            System.out.println(arrhotel.get(i).toString());
        }
    }

    public void add(Hotel hotel) {
        arrhotel.add(hotel);
        ioHotel.write(file, arrhotel);
    }

    public int FindIndexById(int id) {
        for (int i = 0; i < arrhotel.size(); i++) {
            if (arrhotel.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    int id = 0;
    int index = 0;
    double price = 0;
    int numberOfRoom = 0;
    int numberOfPeople = 0;

    public Hotel create() {

        while (true) {
            System.out.println("Nhập ID : ");
            try {
                id = Integer.parseInt(sc.nextLine());
                index = FindIndexById(id);
                if (index == -1) {
                    while (true) {
                        System.out.println("Nhập Giá : ");
                        try {
                            price = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Nhập Chữ Số");
                            continue;
                        }
                        while (true) {
                            System.out.println("Nhập Số Phòng : ");
                            try {
                                numberOfRoom = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                System.out.println("Nhập Chữ Số :");
                                continue;
                            }
                            while (true) {
                                System.out.println("Nhập Số Người Có Thể Ở : ");
                                try {
                                    numberOfPeople = Integer.parseInt(sc.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Nhập Chữ Số ");
                                    continue;
                                }
                                System.out.println("Thành Công");
                                return new Hotel(id, price, numberOfRoom, numberOfPeople);
                            }
                        }
                    }

                } else {
                    System.out.println("ID Đã Tồn Tại");
                }

            } catch (Exception e) {
                System.out.println("Nhập Số ");
                continue;
            }

        }
    }

    public void edit() {
        while (true) {
            System.out.println("Nhập ID Bạn Muốn Sửa Thông Tin : ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập Chữ Số");
                continue;
            }
            int index = FindIndexById(id);
            if (index != -1) {
                arrhotel.set(index, create());
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
            int index = FindIndexById(id);
            if (index != -1) {
                arrhotel.remove(index);
                ioHotel.write(file, arrhotel);
                System.out.println("Đã Xóa");
                return;
            } else {
                System.out.println("ID Không Tồn Tại");
            }
        }
    }

}
