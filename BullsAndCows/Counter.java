import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counter {
    public int getBullCounts(int[] machineNumbers, int[] humanNumbers) {
        int bullCounter = 0;

        for (int i = 0; i < 4; i++) {
            if (machineNumbers[i] == humanNumbers[i]) {
                bullCounter++;
            }
        }
        return bullCounter;
    }

    public int getCowCounts(int[] machineNumbers, int[] humanNumbers) {
        int cowCounter = 0;
        for (int i = 0; i < 4; i++) {
            if (machineNumbers[i] != humanNumbers[i]) {
                for(int p = 0; p < 4; p++){
                    if(machineNumbers[i] == humanNumbers[p]){
                        cowCounter++;
                        break;
                    }
                }
            }
        }
        return cowCounter;
    }

    public int getGameNumber() throws IOException {
        int numberOfLastGame = 1;
        BufferedReader reader = new BufferedReader(new FileReader("log.txt"));
        String lastStr = "";
        while (reader.ready()) {
            String tmp = reader.readLine();
            if (tmp.contains("Game")) {
                lastStr = tmp;//Последняя строка, в которой есть слово Game
            }
        }
        reader.close();
        String[] a = lastStr.split(" ");//Разбиваю строку на массив
        if (a.length <= 1) {
            return numberOfLastGame;
        } else {
            numberOfLastGame = 1 + Integer.parseInt(a[1].substring(1, a[1].length()));//Достаю часть строки с номером игры и перевожу и инт
        }
        return numberOfLastGame;
    } // Метод отпределяет номер игры
}

