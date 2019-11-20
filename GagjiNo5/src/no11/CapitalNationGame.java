package no11;

import java.util.*;

public class CapitalNationGame {
    private HashMap<String, Nation> nationHashMap = new HashMap<>();
    private Scanner scan = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
        System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
        int menuSelect = scan.nextInt();
        switch (menuSelect) {
            case 1: input(); break;
            case 2: game(); break;
            case 3:
                System.out.println("게임을 종료합니다.");
                break;
            default:
                System.out.println("Error");
        }
    }

    public void input() {
        int nationNum = nationHashMap.size();
        String inputNaion, inputCapital;
        System.out.println("현재 " + nationNum + "개 나라와 수도가 입력되어 있습니다.");
        nationNum++;
        while (true) {
            System.out.print("나라와 수도 입력" + nationNum+">>");
            inputNaion = scan.next();
            if (inputNaion.equals("그만")) {
                nationNum--;
                mainMenu();
                break;
            }
            inputCapital = scan.next();
            if (nationHashMap.containsKey(inputNaion)) {
                System.out.println(inputNaion + "는 이미 있습니다!");
            }
            else {
                nationHashMap.put(inputNaion, new Nation(inputNaion, inputCapital));
                nationNum++;
            }
        }
    }
    public void game(){
        Iterator<String> keys = nationHashMap.keySet().iterator();
        //Object[] test = nationHashMap.keySet().toArray();
        List<String> keyList = new ArrayList<>(nationHashMap.keySet());
        Random r = new Random();
        while(true){
            Nation randomNation = nationHashMap.get(keyList.get(r.nextInt(keyList.size())));

            String asking = randomNation.getCountry();
            String answer = randomNation.getCapital();

            System.out.print(asking+"의 수도는? ");
            String userInput = scan.next();
            if(userInput.equals("그만")){
                mainMenu();
                break;
            }
            if(userInput.equals(answer)){
                System.out.println("정답!!");
            }
            else{
                System.out.println("아닙니다!!");
            }
        }
    }
    public CapitalNationGame(){
        nationHashMap.put("멕시코", new Nation("멕시코", "멕시코시티"));
        nationHashMap.put("스페인", new Nation("스페인", "리스본"));
        nationHashMap.put("프랑스", new Nation("프랑스", "파리"));
        nationHashMap.put("영국", new Nation("영국", "런던"));
        nationHashMap.put("그리스", new Nation("그리스", "아테네"));
    }

    public static void main(String[] args) {
        CapitalNationGame capitalNatinoGame = new CapitalNationGame();
        capitalNatinoGame.mainMenu();
    }
}

class Nation {
    private String country;
    private String capital;

    public Nation(String country, String capital) {
        this.capital = capital;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }
}

