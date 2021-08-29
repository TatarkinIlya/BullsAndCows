public class GameUtils {
    private String str = "";
    public String getBullToString(int bullCounter) {
        if (bullCounter == 0 || bullCounter >= 4) {
            str = bullCounter + " быков";
        } else if (bullCounter >= 2) {
            str = bullCounter + " быка";
        } else if (bullCounter == 1) {
            str = bullCounter + " бык";
        }
        return str;
    }

    public String getCowToString(int cowCounter) {
        if (cowCounter == 0 || cowCounter >= 4) {
            str = cowCounter + " коров";
        } else if (cowCounter >= 2) {
            str = cowCounter + " коровы";
        } else if (cowCounter == 1) {
            str = cowCounter + " корова";
        }
        return str;
    }

    public String getStepToString(int stepCounter) {
                str = stepCounter + " ходов";
            int rem = stepCounter % 100;
            if(rem < 11 || rem > 14){
                rem = stepCounter % 10;
                if(rem == 1) str =stepCounter + " ход";
                if(rem >= 2 && rem <= 4) str = stepCounter + " хода";
            } return str;
        }
}
