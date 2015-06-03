/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghosttrophy;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Shilpa's PC
 */
public class GhostTrophy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int days, ghosts,key,largestKey,largestValue;
        Scanner in = new Scanner(System.in);
        days = in.nextInt();
        ghosts = in.nextInt();
        
        key= in.nextInt();
        largestKey = key;
        largestValue =0;
        
        for(int i=0; i<days;i++){
  
            if(hm.containsKey(key)){
               hm.put(key,hm.get(key)+1);
            }
           else{
               hm.put(key,1);
           }
            if(hm.get(key)>largestValue){
                System.out.println(key+" "+hm.get(key)+" ");
                largestKey = key;
                largestValue = hm.get(key);
                
            }
            else if(hm.get(key)==largestValue){
                if(key>largestKey){
                System.out.println(key+" "+hm.get(key)+" ");
                largestKey = key;
                largestValue = hm.get(key);
                }
                else  
                    System.out.println(largestKey+" "+largestValue+" ");
                    
            }
            else
                    System.out.println(largestKey+" "+largestValue+" ");
                       key = in.nextInt();
        }
     
       // System.out.println(hm);
        
    }
}
