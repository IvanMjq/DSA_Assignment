/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ListInterface;
import entity.JobPosting;
import entity.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author WEI ZHENG
 */
public class GeoUtilControl {
//    private ListInterface<Student> studentList;
//    private ListInterface<JobPosting> jobPost;
//    
//    public GeoUtilControl(ListInterface<Student> studentList, ListInterface<JobPosting> jobPost){
//        this.studentList = studentList;
//        this.jobPost = jobPost;
//    }

    public static double[] getLatLong(String area, String state) {

        String location = area + ", " + state;

        try {
            String encodedLocation = URLEncoder.encode(location, "UTF-8");
            String urlStr = "https://nominatim.openstreetmap.org/search?q=" + encodedLocation + "&format=json&limit=1";

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (SchoolProject)");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();

            // Manually extract lat and lon
            String json = response.toString();
            if (json.length() > 0 && json.contains("\"lat\":\"") && json.contains("\"lon\":\"")) {
                int latStart = json.indexOf("\"lat\":\"") + 7;
                int latEnd = json.indexOf("\"", latStart);
                int lonStart = json.indexOf("\"lon\":\"") + 7;
                int lonEnd = json.indexOf("\"", lonStart);

                double lat = Double.parseDouble(json.substring(latStart, latEnd));
                double lon = Double.parseDouble(json.substring(lonStart, lonEnd));

                return new double[]{lat, lon};
            }

        } catch (Exception e) {
            System.out.println("Error fetching lat/lng: " + e.getMessage());
        }

        return new double[]{0.0, 0.0};
    }

    public static void main(String[] args) {
        double[] wutdafak = getLatLong("ns", "idk");
        System.out.println("Latitude: " + wutdafak[0] + ", Longitude: " + wutdafak[1]);
    }

//    public void setLatLongForStdAddresses() {
//        for (int i = 1; i <= studentList.size() ; i++){
//            double[] coords = getLatLong(studentList.getData(i).getArea(), studentList.getData(i).getState());
//            studentList.getData(i).setLatitude(coords[0]);
//            studentList.getData(i).setLongitude(coords[1]);
//        }
//        
//    }
//    
//      public void setLatLongForJobAddresses() {
//
//        for(int j = 1; j <= jobPost.size(); j++){
//            double[] coords = getLatLong(jobPost.getData(j).getCompany().getArea(), jobPost.getData(j).getCompany().getState());
//            jobPost.getData(j).getCompany().setLatitude(coords[0]);
//            jobPost.getData(j).getCompany().setLongitude(coords[1]);
//        }
//        
//    }
}
