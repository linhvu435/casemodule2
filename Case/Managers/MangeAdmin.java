package Case.Managers;

import Case.IO.IOAccount;
import Case.OOP.Acount;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MangeAdmin {
    String name;
    String y;
    File file = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Account.txt");
    Scanner sc = new Scanner(System.in);
    IOAccount ioAccount = new IOAccount();
    ArrayList<Acount> arrAcount = ioAccount.read(file);

    public  void Show() {
        System.out.println(arrAcount);
    }

    boolean isBreak = false;

    public void delete() {
        System.out.println("Nhập Username Bạn Muốn Xóa");
        name = sc.nextLine();
        for (int i = 0; i < arrAcount.size(); i++) {
            if (arrAcount.get(i).getUsername().equals(name)) {
                System.out.println("Bấm Y Để Xóa");
                try {
                    y = sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Thông Tin Không Đổi");
                }
                if (y.toUpperCase().equals("Y")) {
                    arrAcount.remove(i);
                    ioAccount.write(file, arrAcount);
                    System.out.println("Đã Xóa");
                    isBreak = true;

                } else {
                    System.out.println("Thông Tin Không Đổi");
                    isBreak = true;
                }
            }
        }
        if (!isBreak) {
            System.out.println("Không Tồn Tại Username");
        }
    }

    public void ChangeRoll() {
        System.out.println("Nhập Username Bạn Muốn Sửa Quyền Truy Cập");
        name = sc.nextLine();
        for (int i = 0; i < arrAcount.size(); i++) {
            if (arrAcount.get(i).getUsername().equals(name)) {
                if (arrAcount.get(i).getRole().equals("admin")) {
                    System.out.println("Nhập Mật Khẩu Để Xác Nhận Sửa");
                    try {
                        y = sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Quyền Truy Cập Không Đổi");
                        isBreak = true;
                    }

                    if (y.equals("BeHuong")) {
                        arrAcount.get(i).setRole("user");
                        ioAccount.write(file, arrAcount);
                        System.out.println("Đổi Quyền Truy Cập Thành User");
                        isBreak = true;
                        return;
                    } else {
                        System.out.println("Sai Mật Khẩu Rồi");
                        isBreak = true;
                        return;
                    }
                }
                if (arrAcount.get(i).getRole().equals("user")) {
                    System.out.println("Nhập Mật Khẩu Để Xác Nhận Sửa");
                    try {
                        y = sc.nextLine();
                    }catch (Exception e)
                    {
                        System.out.println("Quyền Truy Cập Không Đổi");
                    }

                    if (y.equals("BeHuong")) {
                        arrAcount.get(i).setRole("admin");
                        ioAccount.write(file, arrAcount);
                        System.out.println("Đổi Quyền Truy Cập Thành Admin");
                        isBreak = true;
                        return;
                    } else {
                        System.out.println("Sai Mật Khẩu Rồi");
                        isBreak = true;
                        return;
                    }
                }
            }
        }
        if (!isBreak)
        {
            System.out.println("Không Tồn Tại Username");
        }
    }
}
