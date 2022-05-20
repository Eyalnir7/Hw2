public class RoundedExpression extends Expression{
    private final Expression expression;
    private final int precision;

    public RoundedExpression(Expression expression, int percision){
        this.expression = expression;
        this.precision = percision;
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
