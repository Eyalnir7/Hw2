public class UnaryMinus extends Expression{

    private Expression expression;

    public UnaryMinus(Expression expression){
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "-("+expression.toString()+")";
    }

    @Override
    public double evaluate() {
        return -expression.evaluate();
    }
}
