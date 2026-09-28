import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.*;

//define student class
class student{
    String name,address,performance;
    int age;
    float math,literature,english,mean_point;
    Boolean first_time = Boolean.TRUE; //the problem raised is that the teacher only set scores for the first access
}

//define student manager class
class student_manager {
    void query(student a_student) {
        if (a_student.first_time) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Họ và tên: ");
            a_student.name = sc.nextLine();
            System.out.print("Tuổi: ");
            a_student.age = sc.nextInt();
            sc.nextLine();
            System.out.print("Địa chỉ: ");
            a_student.address = sc.nextLine();
            System.out.print("Điểm toán: ");
            a_student.math = sc.nextFloat();
            System.out.print("Điểm văn: ");
            a_student.literature = sc.nextFloat();
            System.out.print("Điểm anh: ");
            a_student.english = sc.nextFloat();
            a_student.mean_point = (a_student.math + a_student.literature + a_student.english) / 3;
            if (a_student.mean_point >= 8) a_student.performance = "Xuất sắc";
            else if (a_student.mean_point >= 7) a_student.performance = "Giỏi";
            else if (a_student.mean_point >= 6) a_student.performance = "Khá";
            else if (a_student.mean_point >= 5) a_student.performance = "trung Bình";
            else a_student.performance = "Yếu";
            a_student.first_time = Boolean.FALSE;
        } else {
            System.out.printf("Name: %s\n", a_student.name);
            System.out.printf("Name: %d\n", a_student.age);
            System.out.printf("Name: %s\n", a_student.address);
            System.out.printf("Name: %.2f\n", a_student.math);
            System.out.printf("Name: %.2f\n", a_student.literature);
            System.out.printf("Name: %.2f\n", a_student.english);
            System.out.printf("Name: %.2f\n", a_student.mean_point);
            System.out.printf("Name: %s\n", a_student.performance);
        }
    }
}

public class Btvn_B1{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số lượng học sinh: ");
        int numb = sc.nextInt();
        student[] ds_hocsinh = new student[numb+10];
        for(int i=1;i<=numb;i++)
        {
            System.out.printf("Học sinh thứ %d\n",i);
            System.out.println("________________________________________________________________");
            ds_hocsinh[i] = new student();
            student_manager Q = new student_manager();
            Q.query(ds_hocsinh[i]);
            System.out.println("________________________________________________________________");
        }
        System.out.print("Số lượng truy vấn: ");
        int q = sc.nextInt();
        for(int i=1;i<=q;i++)
        {
            System.out.print("Cho gọi học sinh có STT: ");
            int temp = sc.nextInt();
            if(temp>numb) ds_hocsinh[temp] = new student();
            student_manager Q = new student_manager();
            Q.query(ds_hocsinh[temp]);
        }
    }
}