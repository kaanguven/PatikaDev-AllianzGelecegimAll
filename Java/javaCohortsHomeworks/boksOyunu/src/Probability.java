
import java.util.Random;
import java.util.random.*;
public class Probability {
    Fighter f1;

    Fighter f2;


    public Probability(Fighter f1, Fighter f2 ) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public void probabilityHit(Fighter fighter1, Fighter fighter2){
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1;

        if (randomNumber==1){
            f1.health = f2.hit(f1);
        }else {
            f2.health = f1.hit(f2);

        }



        System.out.println(randomNumber);
    }
}
