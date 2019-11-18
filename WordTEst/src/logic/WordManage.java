package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class WordManage {

    private static WordManage instance;
    private static String filePath = "D:\\WordGame\\src\\my\\word.txt";
    private Vector<String> wordData;

    private WordManage(){
        wordData = readFromFile(filePath);
    }

    public static WordManage getInstance(){
        if(instance == null){
            instance = new WordManage();
        }
        return instance;
    }

    public void addWord(String word){
        wordData.add(word);
    }
    public void deleteWord(String word){
        wordData.remove(word);
    }
    public void replaceWordData(Vector<String> newWordData){
        wordData = newWordData;
    }
    public Vector<String> getWordData(){
        return new Vector<String>(wordData);
    }
    private Vector<String> readFromFile(String path){

        Vector<String> wordSet = new Vector<>();
        wordSet.clear();
        File filepath = new File(path);
        BufferedReader bufferedReader;
        try{
            if(filepath.exists()){
                bufferedReader = new BufferedReader(new FileReader(filepath));
                String line;
                while((line = bufferedReader.readLine()) != null){
                    wordSet.add(line);
                }
            }
        }
        catch(IOException e1){
            e1.printStackTrace();
        }
        return wordSet;
    }

    public void changeScene(){

    }

}
