/* You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and 
m types of toppings to choose from. You must follow these rules when making your dessert:
There must be exactly one ice cream base.
You can add one or more types of topping or have no toppings at all.
There are at most two of each type of topping.
You are given three inputs:
baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base 
flavor. toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith 
topping. target, an integer representing your target price for dessert. You want to make a dessert with a total 
cost as close to target as possible. Return the closest possible cost of the dessert to target. If there are 
multiple, return the lower one.
* Eg 1 : base = [1,7]        topping = [3,4]       target = 10                 Output = 7 + 3 = 10
* Eg 2 : base = [2,3]        topping = [4,5,100]   target = 18                 Output = 3 + (10) + (4) = 17
*/
import java.util.*;
public class Dessert
{
      public int MaximumClosest(int baseCost[], int toppingCost[], int target)
      {
            int base = baseCost[0];      // Variable base...   //*  Space Complexity -> O(1)
            for(int i = 1; i < baseCost.length; i++)     //! Time Complexity -> O(N)
            {
                  if(baseCost[i] <= target)    // Taking the maximum base...
                        base = Math.max(base, baseCost[i]);
            }
            Arrays.sort(toppingCost);    //! Sorting -> O(N log N)
            int index = 0;   // Checking the index of the least maximum topping...
            for(int i = toppingCost.length - 1; i >= 0; i--)
            {
                  if(toppingCost[i] > (target - base))    // Getting the required index...
                  {
                        index  = i;     // Storing the index...
                        i = -1;    // Breaking the loop (termination condition)...
                  }
            }
            boolean var = true;
            int topping = 0, left = target - base;    // Left cost to reach the target...  //* Variable -> O(1)
            while(var)     //! Time Complexity -> O(N)
            {
                  if((index > -1) && ((2 * toppingCost[index]) <= left))
                  {     // If two toppings can be added...
                        topping = topping + (2 * toppingCost[index]);
                        System.out.println(toppingCost[index]+" twice!!");
                        left = left - topping;
                        index--;
                  }
                  else if((index > -1) && (toppingCost[index] <= left))
                  {     // If one topping can be added...
                        topping = topping + toppingCost[index];
                        System.out.println(toppingCost[index]+" once!!");
                        left = left - topping;
                        index--;
                  }
                  else if(index < 0)     // If no topping can be added...
                        var = false;
                  else       // Otherwise, we reached the end of the toppings array...
                        var = false;
            }
            return base + topping;    // Returning the sum of base and topping value...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of bases of ice cream flavours : ");
            x = sc.nextInt();
            int base[] = new int[x];
            for(int i = 0; i < base.length; i++)
            {
                  System.out.print("Enter cost (scoop) : ");
                  base[i] = sc.nextInt();
            }
            System.out.print("Enter number of bases of ice cream toppings : ");
            x = sc.nextInt();
            int top[] = new int[x];
            for(int i = 0; i < top.length; i++)
            {
                  System.out.print("Enter cost (topping) : ");
                  top[i] = sc.nextInt();
            }
            System.out.print("Enter the target cost : ");
            x = sc.nextInt();
            Dessert dessert = new Dessert();      // Object creation...
            System.out.println("The Closest cost to target cost is : "+dessert.MaximumClosest(base, top, x));
            sc.close();
      }
}


//! Time Complexity -> O(N log N)
//* Space Complexity -> O(1)

/** //? DEDUCTIONS :-
 * ? We take the maximum base flavour, to reach to the closest to the target sum...
 * ? The index of the maximum base toppings which can be added to the target after sorting is taken...
 * ? Then, we check if two, one or none toppings are to added to reach to the closest to the target...
 */