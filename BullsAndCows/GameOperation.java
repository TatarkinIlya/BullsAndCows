import java.util.Scanner;

public class GameOperation {
    static final Scanner SC = new Scanner(System.in);
    private final StringToConsole STRING_TO_CONSOLE = new StringToConsole();//Вывод в консоль
    private int[] humanNumbers = new int[4];

    public int[] getMachineNumbers() {
        int[] machineNumbers = new int[4];
        for (int i = 0; i < 4; i++) {
            machineNumbers[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (machineNumbers[i] == machineNumbers[j]) {
                    i--; //Если число совпало с одним из предыдущих элементов масива, то генерирую рандомное число заново
                }
            }
        }
        return machineNumbers;
    }

    public void setHumanNumbers() {
        int[] humanNumbers = new int[4];
        this.humanNumbers = humanNumbers;
        boolean flag = false;
        while (!flag) {
            String humanMessage = SC.nextLine();
            if (humanMessage.length() != 4) {
                STRING_TO_CONSOLE.incorrectInput();
                continue;
            }//Проверяю длину вводимого значения. Если не 4, прошу повторить ввод.
            String[] arrayString = humanMessage.split("");
            try {
                for (int i = 0; i < 4; i++) {
                    humanNumbers[i] = Integer.parseInt(arrayString[i]);
                }// Проверяю, все ли стринги являются интами. Если все ок, заношу данные и выхожу из цикла. Если нет, выбрасываю сообщение о некорректном вводе.
                flag = true;
            } catch (Exception e) {
                STRING_TO_CONSOLE.incorrectInput();
            }
        }
    }

    public int[] getHumanNumbers() {
        setHumanNumbers();
        return humanNumbers;
    }
}
