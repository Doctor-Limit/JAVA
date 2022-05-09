package Work1.Day01.Example4_9;

public class MobileTelephone {
    STM sim;
    void setSim(STM card){
        sim=card;
    }
    long lookNumber(){
        return sim.getNumber();
    }
}
