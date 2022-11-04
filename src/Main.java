import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_2b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> listOfStrings = new ArrayList<>();

        String s;
        //put Strings in array
        while ((s = br.readLine()) != null) {
            if (s.isBlank()) continue;

            listOfStrings.add(s);
        }

        int numOfCorrectPasswords = 0;

        // lista brojeva
        List<String> splitedData = new ArrayList<>();
        // lista passworda
        List<String> splitedPassword = new ArrayList<>();
        // lista kontrolnog slova
        List<Character> splitedChar = new ArrayList<>();

        for (String str : listOfStrings){
            String [] splitedString = str.split(":");

            splitedChar.add(splitedString[0].charAt(splitedString[0].length()-1));
            splitedData.add(splitedString[0].substring(0, splitedString[0].length()-2));
            splitedPassword.add(splitedString[1].trim());
        }


        // popunjavanje liste brojevima
        List<Integer []> listaBrojeva = new ArrayList<>();

        for(String stringOfNum : splitedData){
            String [] splitetNum = (stringOfNum.split("-"));

            int firstNum = Integer.parseInt(splitetNum[0]);
            int secondNum = Integer.parseInt(splitetNum[1]);

            Integer [] niz = new Integer[2];
            niz[0] = firstNum;
            niz[1] = secondNum;

            listaBrojeva.add(niz);
        }

        for(int i=0; i<splitedPassword.size(); i++) {
            String password = splitedPassword.get(i);
            char letter = splitedChar.get(i);
            int minNum = listaBrojeva.get(i)[0];
            int maxNum = listaBrojeva.get(i)[1];

            if ((password.charAt(minNum-1) == letter && password.charAt(maxNum-1) != letter) || (password.charAt(minNum-1) != letter && password.charAt(maxNum-1) == letter)) {
                numOfCorrectPasswords++;

            }
        }

        System.out.println(numOfCorrectPasswords);
    }
}