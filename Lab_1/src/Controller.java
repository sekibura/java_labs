public class Controller {
    private int CountStrings=10;

    public void Control(){
        String[] array={"Xyz","Yxz","Abc","Bcd"};

        Model model=new Model();
        String[] result=model.SortString(array);
        View view=new View();
        view.Display(result);

    }
}
