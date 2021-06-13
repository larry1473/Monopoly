package board;

import java.util.ArrayList;
//import java.util.HashMap;
/**
 * @author Larry Fotso
 */
public class Utility {


    public static ArrayList<String> CITIES = new ArrayList<>();
    public static ArrayList<Integer> COSTS  = new ArrayList<>();

    private static String[] cities = {"New York Avenue","Tennessee Avenue","St. James Place","Pennsylvania Railroad","Virginia Avenue" ,
                       "States Avenue","Electric Company","St. Charles Place","Connecticut Avenue","Vermont Avenue",
                       "Oriental Avenue","Reading Railroad","Baltic Avenue","Mediter-ranean Avenue",
                        "Boardwalk","Park Place","Short Line","Pennsylvania Avenue","North Carolina Avenue",
                        "Pacific Avenue","Kentucky Avenue","Indiana Avenue","Illinois Avenue","B&O Railroad","Atlantic Avenue","Ventnor Avenue","Marvin Gardens"};
    private static int[] cost = {200,180,180,200,160,140,150,140,120, 100,100,200,60,60,400,350,100,200,320,300,300,220,240,200,260,260,280};
    

    
    public static  void fillCities1(){

        for(int i = 0; i < cities.length;i++){
         CITIES.add(cities[i]);
            COSTS.add(cost[i]);

        }
    }

    public Board getBoardInstance(){
        return Board.instance;

    }
}
