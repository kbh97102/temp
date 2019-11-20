import java.text.DecimalFormat;

public class test {
    public static void main(String[] args) {
        double t = 3.1;
        DecimalFormat form = new DecimalFormat("#.##");
        System.out.println(form.format(t));
    }
}
