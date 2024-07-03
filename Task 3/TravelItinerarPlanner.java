// TASK:3

// Travel Itinerar Planner

/*Create a travel itinerary planner that allows users to
input destinations, dates, and preferences to generate
a detailed travel plan. Include features like maps,
weather information, and budget calculations.*/

import java.util.*;

public class TravelItineraryPlanner {
    Map<String, travelPlanner> hmap;

    TravelItineraryPlanner() {
        hmap = new HashMap<>();
        travelPlanner tplanner = new travelPlanner("16/06/2024", 90000.0, "Sunny", "https://maps.google.com/?q=Bali");
        hmap.put("Bali", tplanner);
        tplanner = new travelPlanner("16/07/2024", 1100000.0, "Rainy", "https://maps.google.com/?q=Singapore");
        hmap.put("Singapore", tplanner);
        tplanner = new travelPlanner("16/08/2024", 70000.0, "Cloudy", "https://maps.google.com/?q=Mauritius");
        hmap.put("Mauritius", tplanner);
        tplanner = new travelPlanner("16/09/2024", 120000.0, "Sunny", "https://maps.google.com/?q=Thailand");
        hmap.put("Thailand", tplanner);
        tplanner = new travelPlanner("16/10/2024", 130000.0, "Windy", "https://maps.google.com/?q=Paris");
        hmap.put("Paris", tplanner);
        tplanner = new travelPlanner("16/11/2024", 1900000.0, "Snowy", "https://maps.google.com/?q=Moscow");
        hmap.put("Moscow", tplanner);
    }

    public static class travelPlanner {
        String avdate;
        double total_budget;
        String weather;
        String mapLink;

        travelPlanner(String avdate, double total_budget, String weather, String mapLink) {
            this.avdate = avdate;
            this.total_budget = total_budget;
            this.weather = weather;
            this.mapLink = mapLink;
        }
    }

    public static boolean checkDate(String d1, String d2) {
        String yr1 = d1.substring(d1.length() - 4);
        String yr2 = d2.substring(d2.length() - 4);
        int y1 = Integer.parseInt(yr1);
        int y2 = Integer.parseInt(yr2);
        if (y2 < y1) return true;
        else if (y2 > y1) return false;

        String mn1 = d1.substring(3, 5);
        String mn2 = d2.substring(3, 5);
        int m1 = Integer.parseInt(mn1);
        int m2 = Integer.parseInt(mn2);
        if (m2 < m1) return true;
        else if (m2 > m1) return false;

        String dy1 = d1.substring(0, 2);
        String dy2 = d2.substring(0, 2);
        int b1 = Integer.parseInt(dy1);
        int b2 = Integer.parseInt(dy2);
        return b2 < b1;
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        Scanner scn = new Scanner(System.in);
        System.out.println("WELCOME TO THE TRAVEL PLANNER AGENCY:");
        System.out.print("Enter your available date for travel start (DD/MM/YYYY): ");
        String date = scn.next();
        if (date.length() != 10) {
            System.out.print("Your input format is not correct...");
            return;
        }
        System.out.print("Enter your budget: ");
        int total_budget = scn.nextInt();
        travelPlanner newtravel = new travelPlanner(date, total_budget, "", "");
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, travelPlanner> mp : planner.hmap.entrySet()) {
            String key = mp.getKey();
            travelPlanner tplanner = mp.getValue();
            boolean check = checkDate(tplanner.avdate, newtravel.avdate);
            if (check && newtravel.total_budget >= tplanner.total_budget) {
                list.add(key);
            }
        }
        if (list.size() == 0) {
            System.out.print("Your budget is not sufficient...");
            return;
        }
        System.out.println("For the given budget you can visit the following places:");
        for (String location : list) {
            System.out.print(location + " ");
        }
        System.out.println();
        System.out.print("Enter your preferred location: ");
        String location = scn.next();
        if (!list.contains(location)) {
            System.out.print("You don't have enough budget....");
            return;
        }
        travelPlanner selectedLocation = planner.hmap.get(location);
        System.out.println("You can visit " + location + " from " + selectedLocation.avdate + " and you need a minimum of " + selectedLocation.total_budget + ".");
        System.out.println("The weather will be " + selectedLocation.weather + ".");
        System.out.println("Here is the map link: " + selectedLocation.mapLink);
    }
}
