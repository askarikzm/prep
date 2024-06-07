import java.util.*;


import java.io.*;

public class tuz {
    static ArrayList<Temp> user = new ArrayList<>();

    class Temp {
        int id;
        String name;
        int age;
        Boolean status;

        public Temp(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.status = true;
            System.out.println("Your details have been saved in the system!");
            display();
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Age: " + age);
        }

        void changeStatus() {
            if (this.status) {
                this.status = false;
            } else {
                System.out.println("Status is already false");
            }
        }
    }

    class Tut {
        File f1 = new File("/Users/syedmuhammadaskari/Desktop/coding/java/file/files.txt");

        void openFile() {
            user.clear(); 
            try {
                FileReader f2 = new FileReader(this.f1);
                BufferedReader r1 = new BufferedReader(f2);
                String line;
                while ((line = r1.readLine()) != null) {
                    String[] h1 = line.split(",");
                    int id = Integer.parseInt(h1[0]);
                    String name = h1[1];
                    int age = Integer.parseInt(h1[2]);
                    user.add(new Temp(id, name, age));
                }
                r1.close();
                f2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void writeFile() {
            try {
                FileWriter f2 = new FileWriter(this.f1);
                BufferedWriter r1 = new BufferedWriter(f2);
                for (Temp t : user) {
                    r1.write(t.id + "," + t.name + "," + t.age + "," + t.status);
                    r1.newLine();
                }
                r1.close();
                f2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void addUser(String name, int age) {
            Random r1 = new Random();
            int id = r1.nextInt(1000,9999);
            Temp newUser = new Temp(id, name, age);
            user.add(newUser);
            writeFile();
        }

        void updateUser(int id, String newName, int newAge) {
            for (Temp t : user) {
                if (t.id == id) {
                    t.name = newName;
                    t.age = newAge;
                    writeFile();
                    return;
                }
            }
            System.out.println("User not found");
        }

        void deleteUser(int id) {
            Iterator<Temp> iterator = user.iterator();
            while (iterator.hasNext()) {
                Temp t = iterator.next();
                if (t.id == id) {
                    iterator.remove();
                    writeFile();
                    return;
                }
            }
            System.out.println("User not found");
        }

        void displayAllUsers() {
            for (Temp t : user) {
                t.display();
            }
        }
    }

    private final String adminName = "ASKARI";
    private final String adminPassword = "P@kistan786";

  public  void admin() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the admin name:\t");
        String test1 = s1.nextLine();
        System.out.println("Enter the admin Password:\t");
        String test2 = s1.nextLine();
        if (adminName.equals(test1) && adminPassword.equals(test2)) {
            System.out.println("ACCESS AUTHORIZED");
            Tut tut = new Tut();
            tut.openFile();
            int choice;
            do {
                System.out.println("\n1. Add User\n2. Update User\n3. Delete User\n4. Display All Users\n5. Exit");
                System.out.print("Enter your choice: ");
                choice = s1.nextInt();
                s1.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = s1.nextLine();
                        System.out.print("Enter age: ");
                        int age = s1.nextInt();
                        tut.addUser(name, age);
                        break;
                    case 2:
                        System.out.print("Enter user ID to update: ");
                        int updateId = s1.nextInt();
                        s1.nextLine(); // consume newline
                        System.out.print("Enter new name: ");
                        String newName = s1.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = s1.nextInt();
                        tut.updateUser(updateId, newName, newAge);
                        break;
                    case 3:
                        System.out.print("Enter user ID to delete: ");
                        int deleteId = s1.nextInt();
                        tut.deleteUser(deleteId);
                        break;
                    case 4:
                        tut.displayAllUsers();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Access not allowed");
        }
        s1.close();
     }
     public static void main(String[] args) {
     tuz t1=new tuz();
     t1.admin();
    

     }
     } 
