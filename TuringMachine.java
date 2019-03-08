import javax.swing.*;
public class TuringMachine {
    public static Tape tape;
    public static ReadWriteHead rw_head;
    public static State q;
    public static JFrame f;
    public TuringMachine()  {
        rw_head    = new ReadWriteHead();
        tape       = new Tape();
        f          = new JFrame();
    }

    public static void input()  {
        tape.data  = JOptionPane.showInputDialog(f, "Enter Input Tape : ");
    }

    public static void output() {        
        JOptionPane.showMessageDialog(f, tape.data, "Output Tape", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void id() {
        System.out.print("[ " + tape.data.substring(0,rw_head.current_position()) + "(q" + q.current_state() + ")" + tape.data.substring(rw_head.current_position()) + " ] |-\t");
    }

}
