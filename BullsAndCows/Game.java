import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private final StringToConsole STRING_TO_CONSOLE = new StringToConsole();//Вывод в консоль
    private final Counter COUNTER = new Counter();//Счетчик
    private final GameOperation ARRAY_CREATOR = new GameOperation();//Создает и обрабатывает массивы
    private final Logger LOGGER = new Logger();
    private final Scanner SCANNER = new Scanner(System.in);
    private boolean endOfProgram;

    public Game() throws IOException {
    }
    public void start() throws IOException {
        while (!endOfProgram) {
            STRING_TO_CONSOLE.selectAction();//Список возможных действий
            String action = SCANNER.nextLine();//Читаю строку с номером действия
            switch (action) {//Кейсы возможных действий
                case ("1")://Игра
                    int numberOfGame = COUNTER.getGameNumber();//Переменная с номером игры
                    int bulls = 0;
                    int stepCounter = 0;
                    int[] machineNumbers = ARRAY_CREATOR.getMachineNumbers();//Создаю массив из 4 случайных цифр
                    STRING_TO_CONSOLE.getGameNumber(numberOfGame);//Вывожу номер игры в консоль
                    LOGGER.writeStartNewGame(numberOfGame, machineNumbers);//Записываю в лог загаданное число, дату, номер игры
                    STRING_TO_CONSOLE.getSayEnterYourValue();//Прошу сделать первый ход
                    while (bulls != 4) {
                        int[] humanNumbers = ARRAY_CREATOR.getHumanNumbers();//Создаю массив из считанной строки
                        bulls = COUNTER.getBullCounts(machineNumbers, humanNumbers);//Передаю созданные массивы в качестве аргумента и считаю кол-во быков
                        int cows = COUNTER.getCowCounts(machineNumbers, humanNumbers);//Передаю созданные массивы в качестве аргумента и считаю кол-во кооров
                        STRING_TO_CONSOLE.getSayMoveResult(bulls, cows);//сообщение в консоль о наличии коров и быков
                        if (bulls != 4) {
                            STRING_TO_CONSOLE.getSayNextMove();//Прошу сделать следущий ход
                        }
                        stepCounter++;//Счетчик корректных ходов
                        LOGGER.writeStep(humanNumbers, bulls, cows);
                    }//Выхожу из цикла, если нашел всех быков
                    LOGGER.gameResult(stepCounter);
                    STRING_TO_CONSOLE.getSayIfWin(stepCounter);//Вывод сообщения о победе
                    break;
                case ("2")://Вывод правил
                    STRING_TO_CONSOLE.getSayRules();
                    break;
                case ("3")://Выход
                    STRING_TO_CONSOLE.endGame();
                    endOfProgram=true;
                    break;
                default:
                    STRING_TO_CONSOLE.incorrectAction();
            }
        }
        GameOperation.SC.close();//Закрываю scanner
        LOGGER.writerClose();//Закрываю writer

    }
    }

