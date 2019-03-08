public class ReadWriteHead   {
    private static int position;
    public ReadWriteHead()   {
        position = 0;
    }

    public static int current_position()    {
        return position;
    }

    public static void move(int value)  {
        position = position + value;
    }
    
    public static void set_position(int value)  {
        position = value;
    }
}