import javax.swing.*;

class Program{
    String fName;
    String lName;
    int hours;
    float services;
    float options;
    float items;

    int smallBoxes;
    int largeBoxes;
    char pkg;
    float totalCost;

    Program()
    {
        fName = "Madhav";
        lName = "Jasti";
        hours = 24;
        pkg = 'A';
        smallBoxes = 10;
        largeBoxes = 10;
    }

    Program(String firstName, String lastName,int hoursTaken, char pkg, int nLargeBoxes, int nSmallBoxes)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setHoursTaken(hoursTaken);
        setLargeBoxes(nLargeBoxes);
        setPkg(pkg);
        setSmallBoxes(nSmallBoxes);
    }

    public float getItemsCost() {
        items = 2.50f * smallBoxes + 4.50f * largeBoxes;
        return items;
    }

    public float getOptionsCost() {
        options = (8.0f + 20.11f) * hours/24;
        return options;
    }

    public float getServicesCost() {
        if(pkg == 'A')
            services = 100 * hours;
        if(pkg == 'B')
            services = 150 * hours;
        return services;
    }

    public float getTotalCost() {
        totalCost = getServicesCost() + getItemsCost() + getOptionsCost();
        return totalCost;
    }

    public void setHoursTaken(int hoursTaken) {
        this.hours = hoursTaken;
    }

    public void setFirstName(String firstName) {
        this.fName = firstName;
    }

    public void setLastName(String lastName) {
        this.lName = lastName;
    }

    public void setSmallBoxes(int nSmallBoxes) {
        this.smallBoxes = nSmallBoxes;
    }

    public void setLargeBoxes(int nLargeBoxes) {
        this.largeBoxes = nLargeBoxes;
    }

    public void setPkg(char pkg) {
        this.pkg = pkg;
    }

    public String getData()
    {
        String s = "Customer : "+fName+" "+lName;
        s += "\nServices Cost : "+getServicesCost();
        s += "\nOptions Cost : "+getOptionsCost();
        s += "\nItems Cost : "+getItemsCost();
        s += "\nTotal Cost : "+getTotalCost();

        return  s;
    }



}

public class Main {

    public static void main(String[] args) {
        String userName = "Will123";
        String password = "will123";
        int tries = 0;
        String un = JOptionPane.showInputDialog("Enter Username :");
        String pass = JOptionPane.showInputDialog("Enter Password :");
        while( !(un.equals(userName) && pass.equals(password)) && tries < 2)
        {
            tries++;
            JOptionPane.showMessageDialog(null,"Incorrect Credentials!\nEnter Again..");
            un = JOptionPane.showInputDialog("Enter Username :");
            pass = JOptionPane.showInputDialog("Enter Password :");
        }
        if(tries >= 2)
        {
            JOptionPane.showMessageDialog(null,"You've exceeded your try's\nGood Bye!");
            System.exit(1);
        }

        try {
            String firstName = JOptionPane.showInputDialog("Enter the Customer's First Name : ");
            String lastName = JOptionPane.showInputDialog("Enter the Customer's Last Name : ");
            char pkg = Character.toUpperCase(JOptionPane.showInputDialog("Enter the package selected (A or B): \n").charAt(0));
            if(pkg!='A' && pkg!= 'B')
                throw new Exception();
            int hoursTaken = Integer.parseInt(JOptionPane.showInputDialog("Enter the hours taken : \n"));
            int nSmallBoxes = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of small boxes : \n"));
            int nLargeBoxes = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of large boxes : \n"));
            Program p = new Program(firstName,lastName,hoursTaken,pkg,nLargeBoxes,nSmallBoxes);
            JOptionPane.showMessageDialog(null,p.getData());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Wrong Input, Exiting..!");
            System.exit(1);
        }
    }
}
