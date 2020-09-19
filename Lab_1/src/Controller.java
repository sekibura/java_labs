import java.util.Scanner;
public class Controller {
    private int CountStrings=10;

    public void Control(){
        Scanner scaner = new Scanner(System.in);  // Create a Scanner object
        String[] array=new String[CountStrings];

        for (int i=0;i<CountStrings;i++){
            System.out.println("Input string №"+i);
            array[i]=scaner.nextLine().toString();
        }

        Model model=new Model();
        String[] result=model.SortString(array);
        View view=new View();
        view.Display(result);

    }
}
