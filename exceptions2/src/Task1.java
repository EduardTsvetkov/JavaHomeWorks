
public class Task1 {
    public static float task1(String s) throws ExitException, BadDataException {
        float result;

        if (s.equalsIgnoreCase("exit")) {
            throw new ExitException("Выход из программы.");
        }

        try {
            result = Float.parseFloat(s);
        } catch (Exception e) {
            throw new BadDataException("Неправильные данные. Повторите ввод.");
        }
        
        return result;
    }    
}

    class ExitException extends Exception{
        public ExitException(String message){
            super(message);
        }
    }
    
    class BadDataException extends Exception{
        public BadDataException(String message){
            super(message);
        }
    }



