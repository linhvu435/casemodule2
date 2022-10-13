package Case.Managers;

import Case.IO.IOAccount;
import Case.OOP.Acount;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManageAccount {
    File file = new File("C:\\Users\\VuHongLinh\\IdeaProjects\\untitled1\\src\\Case\\File\\Account.txt");
    IOAccount ioAccount = new IOAccount();
    ArrayList<Acount> account = ioAccount.read(file);
    Scanner sc = new Scanner(System.in);

    public Acount Login() {
        System.out.println("Nhập username");
        String username = sc.nextLine();
        System.out.println("Nhập password");
        String password = sc.nextLine();
        for (int i = 0; i < account.size(); i++) {
            if (account.get(i).getUsername().equals(username) && account.get(i).getPassword().equals(password)) {
                return account.get(i);
            }

        }
        return null;
    }

    public void register() {
        while (true) {

            Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
            while (true) {
                System.out.println("Nhập username Theo Định Dạng Username@domain.com ");
                String username = sc.nextLine();
                if (pattern.matcher(username).find()) {
                    if (checkUserName(username)) {
                        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
                        while (true) {
                            System.out.println("Nhập password Theo Định Dạng Tối thiểu tám ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường và một số:");
                            String password = sc.nextLine();
                            if (p.matcher(password).find()) {
                                account.add(new Acount(username, password, "user"));
                                ioAccount.write(file, account);
                                return;
                            }
                        }
                    }

                    System.out.println("Trùng username rồi");
                }

            }
        }
    }

    public boolean checkUserName(String username) {
        for (int i = 0; i < account.size(); ++i) {
            if (account.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

}
