import java.util.Scanner;
public class calc_charges_for_passengers {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int number_of_groups,number_of_passengers,count;
        char Class; 
        double weight,charge;
            System.out.println("enter number of groups");
            number_of_groups=sc.nextInt();
            while(number_of_groups<=0){
                System.out.println("invalid number");
                number_of_groups=sc.nextInt();
            }
            for(int groups=1;groups<=number_of_groups;groups++)    //it's global forloop to play every package of group
            {
                  System.out.println("enter number of passengers in group no"+groups);
                    number_of_passengers=sc.nextInt();
                    while(number_of_passengers<=0){
                        System.out.println("invalid number");
                        number_of_passengers=sc.nextInt();
                    }
                    for(count=1;count<= number_of_passengers;count++)          //it's sub-forloop to play on every passenger
                    {
                            System.out.println("enter the class for passenger no"+count);       //input passenger's class
                            System.out.println("\n");
                            System.out.println("\'F\'- for first class \n \'B\'- for second class \n \'E\'- for third class\n");
                            Class=sc.next().charAt(0);
                            while(Class!='F'&& Class!='B'&& Class!='E')         // check from input passenger's class 
                            {
                                System.out.println("invalid entery");
                                System.out.println("\'F\'- for first class \n \'B\'- for second class \n \'E\'- for third class\n");
                                Class=sc.next().charAt(0);
                            }
                            System.out.println("enter the weight for passenger no"+count);   //input weight for passenger's stuff
                            weight=sc.nextDouble();
                            while(weight<=0){                    //check 
                                System.out.println("invalid weight");
                                weight=sc.nextDouble();
                            }
                            switch(Class){
                                case'F':
                                if(weight>30){
                                    charge=(weight-30)*10;
                                System.out.println("U have an extra charge equal"+charge);
                                    System.out.println("$");
                                }
                                else
                                System.out.println("U have no charge");
                                break;
                                
                                case'B':
                                if(weight>25){
                                    charge=(weight-25)*10;
                                    System.out.println("U have an extra charge equal"+charge);
                                    System.out.println("$");
                                }
                                else
                                System.out.println("U have no charge");
                                break;
                                case'E':
                                if(weight>20){
                                    charge=(weight-20)*10;
                                    System.out.println("U have an extra charge equal"+charge);
                                    System.out.println("$");
                                }
                                else
                                System.out.println("U have no charge");
                                break;


                    }

     
                }

        }
    }


    }
