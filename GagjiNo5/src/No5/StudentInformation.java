package No5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformation {

    private  ArrayList<StudentInfo> studentInfoArrayList = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private int studentNum = 4;

    public static void main(String[] args) {
        StudentInformation studentInformation = new StudentInformation();
        studentInformation.run();
    }

    public  void run() {

        init();
        displayAll();
        displayStudentInfo();

        scan.close();
    }

    public void init() {
        String name, major;
        int studentId;
        double creditAverage;
        System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
        for (int i = 0; i < studentNum; i++) {
            System.out.print(">> ");
            name = scan.next().trim().replace(",", "");
            major = scan.next().trim().replace(",", "");
            studentId = Integer.parseInt(scan.next().trim().replace(",", ""));
            creditAverage = Double.parseDouble(scan.next().trim());
            studentInfoArrayList.add(new StudentInfo(name, major, studentId, creditAverage));
        }
        System.out.println("---------------------------");
    }

    public void displayAll(){
        DecimalFormat form = new DecimalFormat("#.##");
        for (int i = 0; i < studentNum; i++) {
            System.out.println("이름:" + studentInfoArrayList.get(i).getName());
            System.out.println("학과:" + studentInfoArrayList.get(i).getMajor());
            System.out.println("학번:" + studentInfoArrayList.get(i).getStudentId());
            System.out.println("평균학점:"+form.format(studentInfoArrayList.get(i).getCreditAverage()));
            System.out.println("---------------------------");
        }
    }

    public void displayStudentInfo(){
        String inputname = "";
        int studentIndex;
        while(true){
            studentIndex = -1;
            System.out.print("학생 이름 >> ");
            inputname = scan.next();
            if(inputname.equals("그만")){
                break;
            }
            for(int i=0;i<studentNum;i++){
                if(studentInfoArrayList.get(i).getName().equals(inputname)){
                    studentIndex = i;
                    break;
                }
            }
            if(studentIndex != -1){
                System.out.println(studentInfoArrayList.get(studentIndex).toString());
            }
            else{
                System.out.println("해당 학생의 정보가 없습니다.");
            }
        }
    }


}

class StudentInfo {
    private String name;
    private String major;
    private int studentId;
    private double creditAverage;

    public StudentInfo(String name, String major, int studentId, double creditAverage) {
        this.name = name;
        this.major = major;
        this.studentId = studentId;
        this.creditAverage = creditAverage;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getCreditAverage() {
        return creditAverage;
    }

    @Override
    public String toString() {
        return name+", "+major+", "+studentId+", "+creditAverage;
    }
}
