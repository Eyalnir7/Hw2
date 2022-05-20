/**
 * An expression that rounds the value of another expression
 */
public class RoundedExpression extends Expression{
    private final Expression expression;
    private final int precision;

    public RoundedExpression(Expression expression, int precision){
        this.expression = expression;
        this.precision = precision;
    }


    @Override
    public String toString() {
        return expression.toString();
    }

    @Override
    public double evaluate() {
        double scale = Math.pow(10, precision);
        return Math.round(expression.evaluate() * scale) / scale;
    }
}
