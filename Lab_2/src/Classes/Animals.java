package Classes;

public class Animals {
    private String name;
    private  int age;
    private float weight;
//constructors----------------------------
    public Animals(){
        setAge(0);
        setName("Empty");
        setWeight(0);
    }
    public Animals(String name,int age, float weight){
        setAge(age);
        setName(name);
        setWeight(weight);
    }
//setters------------------------------
    public void setName(String value){
        this.name=value;
    }
    public void  setAge(int value){
        this.age=value;
    }
    public void setWeight(float value){
        this.weight=value;
    }

//getters---------------------------
    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
//--------------------------------------
}
