/**
 * An expression that calculates the opposite of another expression
 */
public class UnaryMinus extends Expression{

    private final Expression expression;

    public UnaryMinus(Expression expression){
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "(-"+expression.toString()+")";
    }

    @Override
    public double evaluate() {
        return -expression.evaluate();
    }
}
