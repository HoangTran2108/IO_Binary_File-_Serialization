import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void main(String[] args) {
        File file = new File("student.txt");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hoàng", "CodeGym"));
        students.add(new Student(2, "Nam", "CodeGym"));
        students.add(new Student(3, "Lực", "CodeGym2"));


        write1(file, students);

        List<Student> studentList = read1(file);
        for (Student st: studentList) {
            System.out.println(st);
        }
    }
    public static void write1(File file, List<Student> students){
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> read1(File file){
        List<Student> students1 = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bos = new BufferedInputStream(fileInputStream);
            ObjectInputStream ois = new ObjectInputStream(bos);
            students1 = (List<Student>) ois.readObject();
            fileInputStream.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        } return students1;
    }
}