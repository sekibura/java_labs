package Classes;

public class Paths {
    private static String AnimalBase=".\\animals";
    private static String PlantsBase=".\\plants";
    private static String UsersBase=".\\users";

    public static String getAnimalBasePath() {
        return AnimalBase;
    }

    public static String getPlantsBasePath() {
        return PlantsBase;
    }

    public static String getUsersBasePath() {
        return UsersBase;
    }
}
