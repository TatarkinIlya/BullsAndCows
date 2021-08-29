import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Logger {
    private final FileWriter writer = new FileWriter("log.txt", true);
    private final SimpleDateFormat FORMAT_FOR_DATE_NOW = new SimpleDateFormat();
    private final GameUtils COUNT_TO_STRING = new GameUtils();

    public Logger() throws IOException {
    }

    Date dateNow = new Date();
    void writeStartNewGame(int numberOfGame, int[] machineNumbers) throws IOException {
        writer.write("Game #" + numberOfGame + " " + FORMAT_FOR_DATE_NOW.format(dateNow) + ". Загаданная строка " + Arrays.toString(machineNumbers) + "\n");//Записал номер игры, дату и сгенерированный массив в логи
    }

    void writeStep(int[] humanNumbers, int bulls, int cows) throws IOException {
        writer.write("\tЗапрос: " + Arrays.toString(humanNumbers) + ". Ответ: " + COUNT_TO_STRING.getBullToString(bulls) + " и " + COUNT_TO_STRING.getCowToString(cows) + "\n");//Записал ход в логи
    }

    public void gameResult(int stepCounter) throws IOException {
        writer.write("Игра была завершена за " + COUNT_TO_STRING.getStepToString(stepCounter) + "\n" + "\n");//Запись результата игры в логи
        writer.flush();//Сохраняю результат игры
    }
    public void writerClose() throws IOException {
        writer.close();
    }
}
