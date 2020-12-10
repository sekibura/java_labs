public class Score {
    private static int score_1 = 0;
    private static int score_2 = 0;

    public Score() {
    }

    public static int getScore_1() {
        return score_1;
    }

    public static void setScore_1(int score_1) {
        Score.score_1 = score_1;
    }

    public static int getScore_2() {
        return score_2;
    }

    public static void setScore_2(int score_2) {
        Score.score_2 = score_2;
    }

    public static void clearScore() {
        setScore_1(0);
        setScore_2(0);
    }

    public static boolean checkEndGame() {
        if (score_1 == Constants.MAX_SCORE || score_2 == Constants.MAX_SCORE) {
            return true;
        }
        return false;
    }

}
