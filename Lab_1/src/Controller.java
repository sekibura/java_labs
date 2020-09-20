import java.util.Scanner;
public class Controller {
    private int CountStrings=2; // Number of strings in array

    public void Control(){
        Scanner scaner = new Scanner(System.in);  // Create a Scanner object
        String[] array=new String[CountStrings];  // Create array of strings

        // Get value for each string in array
        for (int i=0;i<CountStrings;i++){
            System.out.println("Input string №"+i);
            array[i]=scaner.nextLine().toString();
            if(array[i].isEmpty()){ // Check empty string
                i--;
                System.err.println("String is empty!"); // Error of empty string
            }
        }
        View view=new View(); //Create a View object
        view.Display(array);  //Display unsorted array
        Model model=new Model(); //Create a Model Object
        String[] result=model.SortString(array); // Use Model for sort array
        view.Display(result); // Display result of models work

    }
}
