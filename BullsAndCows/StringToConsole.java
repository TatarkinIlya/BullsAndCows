

public class StringToConsole {
    private final GameUtils COUNT_TO_STRING = new GameUtils();


    public void getGameNumber(int gameNumber){ System.out.println("---------------------Старт игры № " + gameNumber + " ---------------------"); }
    public void getSayRules() { System.out.println("Правила игры: \n" +
                "Компьютер задумывает четыре различные цифры из 0,1,2,...9. Игрок делает ходы, чтобы узнать эти цифры и их порядок." + "\n" +
                "Каждый ход состоит из четырёх цифр.\n" +
                "В ответ компьютер показывает число отгаданных цифр, стоящих на своих местах (число быков) и число отгаданных цифр, стоящих не на своих местах (число коров).\n" +
                "Пример:\n" +
                "Компьютер задумал 0834.\n" +
                "Игрок сделал ход 8134.\n" +
                "Компьютер ответил: 2 быка (цифры 3 и 4) и 1 корова (цифра 8).\n" +
                "Задача: угадать всех быков.\n"); }
    public void getSayEnterYourValue() { System.out.println("Первый ход. Введите число:"); }
    public void getSayNextMove() { System.out.println("Сделайте следущий ход:"); }
    public void getSayIfWin(int stepCounter) { System.out.println("Ура, вам удалось угадать всех быков! Игра завершена за " + COUNT_TO_STRING.getStepToString(stepCounter) + "."); }
    public void getSayMoveResult(int bulls, int cows) { System.out.println("Найдено: " + COUNT_TO_STRING.getBullToString(bulls) + " и " + COUNT_TO_STRING.getCowToString(cows)); }
    public void incorrectInput(){ System.out.println("Возможно, вы ввели буквы или ваше число не является четырехзначным. Пример корректного ввода: 1423"); }
    public void selectAction(){ System.out.println("Введите число для выбора действия: 1 - Новая игра. 2 - Правила игры. 3 - Выход."); }
    public void endGame(){
        System.out.println("Пока-пока!)");
    }
    public void incorrectAction(){
        System.out.println("Неверная команда. Повторите ввод");
    }
}
