public class State  {
    private static int number;   //  0, 1, or 2.
    public State()  {
        number = 0;  //  Initial value
    }

    public static int current_state()   {
        return number;
    }

    public static boolean state_increment()   {
        if(number < 2)   {
            ++number;
            return true;
        }
        else
            return false;
    }
}