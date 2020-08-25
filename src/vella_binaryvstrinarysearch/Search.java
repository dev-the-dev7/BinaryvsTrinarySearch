
package vella_binaryvstrinarysearch;

/****************************
 ***Class Name: Search
 ***Author: Devin Vella
 ****************************
 ***Purpose: The purpose of this class is to provide the code to use binary and 
 ***trinary search to search the array.
 **************************** 
 ***Date: 2/6/2019
 ****************************/
public class Search extends BinaryvsTrinaryGUI
{
    //set variables
    int BinaryLocation, BinaryCount, TrinaryLocation, TrinaryCount;
    long startTime, endTime, BinaryDuration, TrinaryDuration;
    
    /****************************
    ***Method Name: binarySearch
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to find a key using binary search.   
    ****************************
    ***Method Inputs:
    ***n, list[], key
    ***Date: 2/6/2019
    ****************************/
    void binarySearch(int n, int list[], int key)
    {
        //set variables
        int low , high, mid, recursiveCount, location;
        
        //set values
        low = 0; 
        high = n - 1;
        recursiveCount = 0;
        location = -1;
        
        //get startTime
        startTime = System.nanoTime();
        
        //run until we search through the entire array or until the location is found
        while(low <= high && location == -1)
        {
            //count how many recursive calls were needed to find the location of the key
            recursiveCount++;
            
            //use binary search to find the location of the key
            mid = (low + high) / 2;
            if(key == list[mid])
                location = mid;
            else if(key < list[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        //get endTime
        endTime = System.nanoTime();
        
        //return location, count, and duration
        this.BinaryLocation = location;
        this.BinaryCount = recursiveCount;
        BinaryDuration = endTime - startTime;
    }
    
    /****************************
    ***Method Name: trinarySearch
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to find a key using trinary search.   
    ****************************
    ***Method Inputs:
    ***n, list[], key
    ***Date: 2/6/2019
    ****************************/
    void trinarySearch(int n, int list[], int key)
    {
        //set variables
        int low, high, mid1, mid2, recursiveCount, location;
        
        //set values
        low = 0; 
        high = n - 1;
        recursiveCount = 0;
        location = -1;
        
        //get startTime
        startTime = System.nanoTime();
        
        //run until we search through the entire array or until location is found
        while(low <= high && location == -1)
        {
            //count how many recursive calls were needed to find location of the key
            recursiveCount++;
            
            //use trinary search to find the location of the key
            //find first boundary
            mid1 = low + (high - low) / 3;

            //find second boundary
            mid2 = high - (high - low) / 3;

            //check first boundary for key
            if (list[mid1] == key)
                location = mid1;

            //check second boundary for key
            else if (list[mid2] == key)
                location = mid2;
                
            //check first section for key
            else if (key < list[mid1])
                high = mid1 - 1; 
            
            //check third section for key
            else if (key > list[mid2])
                low = mid2 + 1;    
            
            //check second section for key
            else
            {
                low = mid1 + 1;
                high = mid2 - 1;    
            }  
        }
        
        //get endTime
        endTime = System.nanoTime();

        //return location, count, and duration
        this.TrinaryLocation = location;
        this.TrinaryCount = recursiveCount;
        TrinaryDuration = endTime - startTime;
    }
}