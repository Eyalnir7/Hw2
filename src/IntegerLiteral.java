public class IntegerLiteral extends Expression{
    private final int integer;

    public IntegerLiteral(int integer){
        this.integer = integer;
    }
    @Override
    public double evaluate(){
        return integer;
    }

    @Override
    public String toString(){
        return "("+integer+")";
    }
}
