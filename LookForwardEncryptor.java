import javax.swing.*;
public class LookForwardEncryptor extends TuringMachine   {
    private static char ax, bx, rx, zerox;  //  4 extra registers as opposed to original Turing Machine
    private static int move_len;            //  Read-Write Head movement controller
    public LookForwardEncryptor()   {       //  Constructor
        ax = 'A';
        bx = 'A';
        rx = 'A';
        move_len = 0;
    }
    
    public static void assign_ax(char input)  {
        ax = input;
    }

    public static void assign_bx(char input)  {
        bx = input;
    }
    
    public static void assign_zerox(char input)  {
        zerox = input;
    }
    
    public static void remove_spaces()  {
        int i;
        rw_head.set_position(0);
        for(i=0;i<tape.data.length();i++)   {
            if( tape.data.charAt(rw_head.current_position()) == ' ')    {
                tape.data = tape.data.substring(0,rw_head.current_position()) + tape.data.substring(rw_head.current_position()+1);
            }
            rw_head.move(1);
        }
    }
    
    public static void encrypt()    {
        int i;
        JOptionPane.showMessageDialog(f,"All spaces in plaintext will be removed.", "NOTIFICATION", JOptionPane.INFORMATION_MESSAGE);    // f is JFrame instance from class TuringMachine
        remove_spaces();    // To remove spaces in plaintext
        System.out.print("START |-\t");
        rw_head.set_position(0);        
        id();
        q.state_increment();
        id();
        for(i=0;i<tape.data.length()-1;i++)   {                       
            assign_ax(tape.data.charAt(rw_head.current_position()));            
            rw_head.move(1);
            assign_bx(tape.data.charAt(rw_head.current_position()));
            rw_head.move(-1);
            rx = (char)((int)'A' + ((1 + ((int)ax + (int)bx) - ( 2*(int)'A'))%26));
            tape.data = tape.data.substring(0,rw_head.current_position()) + rx + tape.data.substring(rw_head.current_position()+1);
            if(rw_head.current_position()==0)
                assign_zerox(tape.data.charAt(rw_head.current_position()));
            rw_head.move(1);
            id();
            if(i%3 == 0)
                System.out.print("\n\t\t");
        }
        assign_ax(tape.data.charAt(rw_head.current_position()));
        rx = (char)((int)'A' + ((1 + ((int)ax + (int)zerox) - ( 2*(int)'A'))%26));
        tape.data = tape.data.substring(0,rw_head.current_position()) + rx + tape.data.substring(rw_head.current_position()+1);
        rw_head.move(1);
        q.state_increment();
        id();
        System.out.println("HALT");
    }
    
    public static void main(String[] args)  {
        input();
        encrypt();
        output();
    }
}
