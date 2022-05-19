public class DoubleLiteral extends Expression{
    private final double d;

    public DoubleLiteral(double d){
        this.d = d;
    }

    @Override
    public double evaluate(){
        return d;
    }

    @Override
    public String toString(){
        return "("+d+")";
    }
}
