import java.util.*;
import java.io.*;
public class hello {
    static ArrayList<temp>user=new ArrayList<>();
     class temp{
        int id;
        String name;
        int age;
        Boolean status;
       
     public  temp(int id,String name,int age){
            Random r1=new Random();
            this.id=r1.nextInt(1000, 9999);
            this.name=name;
            this.age=age;
            this.status=true;
            System.out.println("Your detailed saved in System!");
            display();
        }
     void display(){
        System.out.println("Name is :\t"+name);
        System.out.println("id is :\t"+id);
        System.out.println("age is :\t"+name);
    }
   void change(Boolean status){
     if(this.status){
        this.status=false;
     }
     else{
        System.out.println("Already is false");
     }
  }
    }
    public class tut {
        File f1=new File("/Users/syedmuhammadaskari/Desktop/coding/java/file/files.txt");
        void openfile() {
            try {
                user.clear();
                FileReader f2= new FileReader(this.f1);
                BufferedReader R1=new BufferedReader(f2);
                String line;
                while ((line=R1.readLine()) != null) {
                   String h1[]=line.split(",");
                   int id=Integer.parseInt(h1[0]);
                   String name=h1[1];
                   int age=Integer.parseInt(h1[2]);

                   user.add(new temp(id,name,age));
                }
                R1.close();
                f2.close();
                
            } catch (IOException E) {
                E.printStackTrace();
            }     
        }
         void writefile(String name,int id,int age,boolean status){
          try {
              FileWriter f2=new FileWriter(this.f1,true);
              BufferedWriter R1=new BufferedWriter(f2);
              R1.write(String.valueOf(id) + "," + name + "," + String.valueOf(age) + "," + String.valueOf(status));
              R1.newLine();   
              R1.close();
              f2.close();
          } catch (IOException e) {
            e.printStackTrace();
              
          }        
         }}
  private  final String name="ASKARI";
    final String password="P@kistan786";
    temp t1= new temp(0, name, 0);
    void admin(){
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the admin name:\t");
        String test1=s1.nextLine();
        System.out.println("Enter the admin Password:\t");
        String test2=s1.nextLine();
        if(name==test1 && password==test2){
            System.out.println("ACCESS AUTHORIZED");
            // function inside add update delete 
          
        }
        else{
            System.out.println(" not allowed");
        }


    }

}