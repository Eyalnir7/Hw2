public abstract class MultiOperation extends Expression{

    protected Expression[] expressions;

    public MultiOperation(Expression... expressions){
        this.expressions = new Expression[expressions.length];
        System.arraycopy(expressions, 0, this.expressions, 0, expressions.length);
    }
}
