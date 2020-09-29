package Classes;

public class Main {

   public static void main(String[] args) {
      Forest forest=new Forest();
      forest.AddGrass("Travka",12,1,false,false);
      forest.AddTree("Berezka",50,15,false,"white and black",20);
      forest.AddHerbivore("Kozel",2,40,"Travka");
      forest.AddPredator("Tiger",50,4,true);


      forest.PrintAll();
   }



}
