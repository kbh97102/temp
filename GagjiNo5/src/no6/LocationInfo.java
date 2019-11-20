package no6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class LocationInfo {
    private HashMap<String, LocationInfo> locationHashMap = new HashMap<>();
    private Scanner scan = new Scanner(System.in);
    private int cityNum = 1;
    public static void main(String[] args) {
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.run();
    }

    public void run(){
        String cityName;
        int latitude, longitude;
        //Init
        System.out.println("도시, 경도, 위도를 입력하세요.");
        for(int i=0;i<cityNum;i++){
            System.out.print(">> ");
            cityName = scan.next().trim().replace(",","");
            latitude = Integer.parseInt(scan.next().trim().replace(",",""));
            longitude = scan.nextInt();
        }
        System.out.println("----------------------------------");

        //DisplayAll
        Iterator<String> keys = locationHashMap.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            locationHashMap.get(key).toString();
        }

        //Search City
        while(true){
            String inputName = scan.next().trim();
            if(inputName.equals("그만")){
                break;
            }
            if(locationHashMap.containsKey(inputName)){
                locationHashMap.get(inputName).toString();
            }
            else{
                System.out.println(inputName+"는 없습니다.");
            }
        }
    }
}

class Location{
    private String cityName;
    private int latitude, longitude;

    public Location(String cityName, int latitude, int longitude){
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return cityName+" "+latitude+" "+longitude;
    }
    //System.out.printf("%-4s %-3d %-3d", cityName, latitude, longitude);
}
