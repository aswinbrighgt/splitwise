package Splitwise.Stratagies;

public class ExpenseCreatorFactory {

    static ExpenceCreator single=new singlepay();
    static ExpenceCreator multi=new multipay();
    public static ExpenceCreator create(String type){
        if(type.equals("iPay")){
            return single;
        }
        else{
            return multi;
        }
    }
}
