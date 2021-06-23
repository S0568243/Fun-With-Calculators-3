import java.util.HashSet;
import java.util.Set;

/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  David J. Barnes and Michael Kolling 
 * @version 2008.03.30
 */
public class CalcEngine
{
    // The current value (to be) shown in the display.
    private String displayValue = "";


    Set<String> setA = new HashSet<String>();
    Set<String> setB = new HashSet<String>();
    Set<String> setResult = new HashSet<String>();


   public Set<String> getSetA() {
       return setA;
   }
   public Set<String> getSetB() {
        return setB;
    }

    /**
     * Create a CalcEngine.
     */


    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayValue()
    {   displayValue = setResult.toString();
        return displayValue;
    }

    /**
     * The 'C' (clear) button was pressed.
     * Reset everything to a starting state.
     */

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion()
    {
       return "Version 1.0";
    }


    public void sizeOfSetA(){
        setResult.clear();
        setResult.add(Integer.toString(setA.size()));
        // return setA.size();
    }

    public void sizeOfSetB(){
        setResult.clear();
        setResult.add(Integer.toString(setB.size()));
        //return setB.size();
    }

    public Set<String> pushSetA(){
        setResult.clear();
        for(String s : setA){

            setResult.add(s);
        }
        return setResult;
    }

    public Set<String> pushSetB(){
        setResult.clear();
        for(String s : setB){

            setResult.add(s);
        }
        return setResult;
    }


    public Set<String> union(){
        setResult.clear();
    setResult.addAll(setA);
    setResult.addAll(setB);
    return setResult;
    }

    public Set<String> intersection(){
        setResult.clear();
        setResult.addAll(setA);
        setResult.retainAll(setB);

        return setResult;
    }

    public Set<String> subtraction(){

        setResult.clear();
        setResult.addAll(setA);
        setResult.removeAll(setB);
        return setResult;
    }





    /**
     * Report an error in the sequence of keys that was pressed.
     */
    private void keySequenceError()
    {
        System.out.println("A key sequence error has occurred.");
        // Reset everything.

    }
}
