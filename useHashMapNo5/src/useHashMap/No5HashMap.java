package useHashMap;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class No5HashMap {

    static Scanner scan = new Scanner(System.in);
    static int studentNum = 4;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        HashMap<String, StudentInfo> StudentInfoHashMap = new HashMap<>();

        init(StudentInfoHashMap);
        displayAll(StudentInfoHashMap);
        displayStudentInfo(StudentInfoHashMap);

        scan.close();
    }

    public static void init(HashMap<String, StudentInfo> StudentInfoHashMap) {
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
            StudentInfoHashMap.put(name, new StudentInfo(name, major, studentId, creditAverage));
        }
        System.out.println("---------------------------");
    }

    public static void displayAll(HashMap<String, StudentInfo> StudentInfoHashMap){
        DecimalFormat form = new DecimalFormat("#.##");
        Iterator<String> keys = StudentInfoHashMap.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            System.out.println("이름:" + StudentInfoHashMap.get(key).getName());
            System.out.println("학과:" + StudentInfoHashMap.get(key).getMajor());
            System.out.println("학번:" + StudentInfoHashMap.get(key).getStudentId());
            System.out.println("평균학점:"+form.format(StudentInfoHashMap.get(key).getCreditAverage()));
            System.out.println("---------------------------");
        }
    }

    public static void displayStudentInfo(HashMap<String, StudentInfo> StudentInfoHashMap){
        String inputname = "";
        while(true){
            System.out.print("학생 이름 >> ");
            inputname = scan.next();
            if(inputname.equals("그만")){
                break;
            }
            if(StudentInfoHashMap.containsKey(inputname)){
                System.out.println(StudentInfoHashMap.get(inputname).toString());
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
