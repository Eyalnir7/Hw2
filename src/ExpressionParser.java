public class ExpressionParser {
    protected int location;
    protected int direction;
    protected int startingPointFlag;

    public ExpressionParser(int direction, int startingPointFlag){
        this.direction = direction;
        this.startingPointFlag = startingPointFlag;
        this.location = 0;
    }
    protected Expression parse(String stringToParse){
        String[] parts = stringToParse.split(" ");
        if(startingPointFlag == 0)
            location = 0;
        else
            location = parts.length - 1;
        return parse(parts);
    }
    private Expression parse(String[] expressionParts){
        Expression expression1, expression2 = null;
        if(location >= expressionParts.length || location <= -1)
            return null;
        int start = location;
        location += direction;
        if(isNumeric(expressionParts[location - direction]))
            return this.newNumber(expressionParts[location - direction]);
        expression1 = parse(expressionParts);
        if(!expressionParts[start].equals("-u"))
            expression2 = parse(expressionParts);
        return createExpression(expressionParts[start], expression1, expression2);
    }

    private Expression createExpression(String operator, Expression expression1, Expression expression2){
        switch(operator){
            case "+":
                return new Addition(expression1, expression2);
            case "-":
                return new Subtraction(expression1, expression2);
            case "/":
                return new Division(expression1, expression2);
            case "*":
                return new Multiplication(expression1, expression2);
            case "-u":
                return new UnaryMinus(expression1);
            default:
                return null;
        }
    }

    protected Expression newNumber(String number){
        return null;
    }

    private boolean isNumeric(String strToCheck){
        try{
            double number = Double.parseDouble(strToCheck);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
