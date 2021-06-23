import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

/**
 * A graphical user interface for the calculator. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class UserInterface
    implements ActionListener
{
    private CalcEngine calc;
    private boolean showingAuthor;

    private JFrame frame;
    private JTextField display, display2, result;
    private JLabel status;

    /**
     * Create a user interface.
     * @param engine The calculator engine.
     */
    public UserInterface(CalcEngine engine)
    {
        calc = engine;
        showingAuthor = true;
        makeFrame();
        frame.setVisible(true);
    }

    /**
     * Set the visibility of the interface.
     * @param visible true if the interface is to be made visible, false otherwise.
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

    /**
     * Make the frame for the user interface.
     */
    private void makeFrame()
    {
        frame = new JFrame(calc.getTitle());

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        JPanel textInputPanel = new JPanel(new GridLayout(2, 1));

        display = new JTextField();
        textInputPanel.add(display);

                display2 = new JTextField();
        textInputPanel.add(display2);
        contentPane.add(textInputPanel,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
        addButton(buttonPanel, "Union");
        addButton(buttonPanel, "Intersection");
        addButton(buttonPanel, "Subtraction");
        addButton(buttonPanel, "Clear");

        addButton(buttonPanel, "Push Set A");
        addButton(buttonPanel, "Push Set B");
        addButton(buttonPanel, "Length Set A");
        addButton(buttonPanel, "Length Set B");
            
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        JPanel southInputPanel = new JPanel(new GridLayout(2, 1));
        result = new JTextField();
        southInputPanel.add(result);

        status = new JLabel(calc.getAuthor());
        southInputPanel.add(status);

        contentPane.add(southInputPanel,BorderLayout.SOUTH);

        frame.pack();
    }

    /**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    private void addButton(Container panel, String buttonText)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
    }

    /**
     * An interface action has been performed.
     * Find out what it was and handle it.
     * @param event The event that has occured.
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        String a = display.getText();
        String b = display2.getText();

        Set setA = calc.getSetA();
        setA.clear();
        String[] collectionA = a.split(",");
        for (String s : collectionA){
            setA.add(s);
        }


        Set setB = calc.getSetB();
        setB.clear();
        String[] collectionB = b.split(",");
        for(String s : collectionB){
            setB.add(s);
        }




        if(command.equals("Union")){
            calc.union();
        }
        else if(command.equals("Intersection")) {
            calc.intersection();
        }
        else if(command.equals("Subtraction")) {
            calc.subtraction();
        }
        else if(command.equals("Push Set A")) {
            calc.pushSetA();
        }
        else if(command.equals("Clear")) {
            display.setText("");
            display2.setText("");
            result.setText("");
        }
        else if(command.equals("Length Set A")) {
            calc.sizeOfSetA();
        }
        else if(command.equals("Push Set B")) {
            calc.pushSetB();
        }
        else if(command.equals("Length Set B")) {
            calc.sizeOfSetB();
        }
        // else unknown command.

        redisplay();
    }

    /**
     * Update the interface display to show the current value of the 
     * calculator.
     */
    private void redisplay()
    {
        result.setText(calc.getDisplayValue());
    }

    /**
     * Toggle the info display in the calculator's status area between the
     * author and version information.
     */
    private void showInfo()
    {
        if(showingAuthor)
            status.setText(calc.getVersion());
        else
            status.setText(calc.getAuthor());

        showingAuthor = !showingAuthor;
    }
}
