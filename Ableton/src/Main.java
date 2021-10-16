import javax.swing.*;

public class Main {public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
{
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    
    //String TASOS = new String();
    App frame = new App();

    frame.setVisible(true);
}
}
