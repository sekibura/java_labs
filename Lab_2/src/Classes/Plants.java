package Classes;

public class Plants {
    private String name;
    private float height;
    private int age;
    private boolean haveFruit;

    public Plants(){
        setName("Empty");
        setAge(0);
        setHaveFruit(false);
        setHeight(0);
    }

    public Plants(String name,float height, int age, boolean haveFruit){
        setName(name);
        setAge(age);
        setHaveFruit(haveFruit);
        setHeight(height);

    }
//setters----------------------------
    public void setAge(int age) {
        this.age = age;
    }

    public void setHaveFruit(boolean haveFruit) {
        this.haveFruit = haveFruit;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }
    //getters--------------------------------

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHaveFruit() {
        return haveFruit;
    }

    public float getHeight() {
        return height;
    }
}
