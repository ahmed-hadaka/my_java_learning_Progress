/***************************************************************************************** 
# SalesClerksDriver
# Ahmed Hadaka

## this program keep track of total sales for each sales clerk in a department store, 

#note:- we used here Array of Objects just as a practicing, instead of Arraylist.
*******************************************************************************************/
import java.util.Scanner;

public class SalesClerksDriver
{
  public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    SalesClerks clerks = new SalesClerks(2); 
    String name;
    //new  instantiated from SalesClerks class, which use the constructor SalesClerks()

    System.out.print("Enter clerk's name (q to quit): ");
    name = stdIn.nextLine();
    while (!name.equals("q"))
    {
      System.out.print("Enter sale amount: ");
      clerks.addSale(name, stdIn.nextDouble()); // [sdf]
      stdIn.nextLine(); // flush newline
      
      System.out.print("Enter clerk's name (q to quit): ");
      name = stdIn.nextLine();
    } // end while
    clerks.dumpData();
  } // end main
} // end SalesClerksDriver
