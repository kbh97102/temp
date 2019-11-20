package logic;

import test.FileManager;

import java.util.Vector;

//TODO 제발 gitBranch따고 시작하자

public class Ingame {

    private static Vector<String> wordData;
    private static Ingame instance;
    private Vector<String> wordSet;


    public Ingame(){
        bringWordData();
    }
    private void bringWordData(){
        wordSet = WordManage.getInstance().getWordData();
    }

    public static Ingame getInstance(){
        if(instance == null){
            instance = new Ingame();
        }
        return instance;
    }

    public String generateWord(){
        int randomIndex = (int)(Math.random()*wordSet.size());
        return wordSet.get(randomIndex);

    }

    public void changeScene(){

    }
}
