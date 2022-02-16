package com.example.andoridproject;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadData extends AsyncTask {

    private String data ="";
    private String dataParsed = "";
    private String singleParsed ="";

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            URL url = new URL("https://api.myjson.com/bins/1b1s4e");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "Food: " + JO.get("food") + "\n"+
                        "Description: " + JO.get("description") + "\n"+
                        "Nutrition: "+ "\n";
                JSONArray ja2= JO.getJSONArray("Nutrition");
                for(int j=0;j<ja2.length();j++){
                    JSONObject jo2= (JSONObject) ja2.get(j);
                    if(j==0){
                        singleParsed+="Protein: "+jo2.get("Proteins")+"\n";
                    }
                    if(j==1){
                        singleParsed+="Carbs: "+jo2.get("Carbs")+"\n";
                    }
                    if(j==2){
                        JSONArray ja3=jo2.getJSONArray("Vitamins");
                        JSONObject jo3= (JSONObject) ja3.get(0);
                        singleParsed+="Vitamin:\n"+jo3.get("1")+"\n"+jo3.get("2")+"\n"+jo3.get("3")+"\n";
                    }

                }

                dataParsed = dataParsed + singleParsed +"\n" ;


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        FoodTips_Json.jsonData.setText(dataParsed);
    }
}