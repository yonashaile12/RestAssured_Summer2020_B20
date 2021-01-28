package Interview_Parctice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Solution {

    private static URL url;
    private static HttpURLConnection conn;

    public static void main(String[] args) {
        retrieveProduct();
    }
        public static void retrieveProduct(){
            try{
                //creating connection anf get request
                url = new URL("http://127.0.0.1:8081/products");
                conn =(HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");


                //saving result
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String output;
                while((output = br.readLine())!=null){
                    sb.append(output);
                }

                ObjectMapper mapper = new ObjectMapper();
                POJO[] myPojos = mapper.readValue(sb.toString(),POJO[].class);
                if(myPojos.length!=0 && myPojos!=null){
                    for(POJO each:myPojos){
                        if(each.getManufacturer()!=null){
                            System.out.println("Product "+each.getName()+" has price "+each.getPrice()+" and manufacturer "+each.getManufacturer());
                        }else{
                            System.out.println("Product "+each.getName()+" has price "+each.getPrice()+" and no manufacturer");
                        }
                    }
                }else{
                    throw new IllegalArgumentException();
                }
            } catch(IOException e){
                System.out.println(e.getMessage());
            }

        }

    }


