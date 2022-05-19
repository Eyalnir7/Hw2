public class ReversePolishNotationParser extends ExpressionParser{
    public ReversePolishNotationParser(){
        super(-1, 1);
    }

    @Override
    protected Expression newNumber(String number){
        return new DoubleLiteral(Double.parseDouble(number));
    }
}
