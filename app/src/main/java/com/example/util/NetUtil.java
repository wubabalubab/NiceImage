package com.example.util;

import com.example.bean.ImageBean;
import com.example.common.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
*   author K.K
*   created on 2020/9/16
*   @Describe NetUtil
*/


public class NetUtil {
    private static final String TAG = "NetUtil";
    public ArrayList<ImageBean> getImageList(int count, int page) {
        String url = Constant.netUrl+page+"/count/"+count;
        ArrayList<ImageBean> imageList = new ArrayList<>();
        try {
            URL netUrl=new URL(url);
            HttpURLConnection connection= (HttpURLConnection) netUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            int code= connection.getResponseCode();
            if (code==200) {
                InputStream inputStream=connection.getInputStream();
                byte[] buffer= readfromInputStream(inputStream);
                String data= new String(buffer,UTF_8);
                imageList=parseJson(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageList;
    }

    private ArrayList<ImageBean> parseJson(String data) {
        ArrayList<ImageBean> imageList = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(data);
            JSONArray array = new JSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                ImageBean bean = new ImageBean();
                JSONObject material= (JSONObject) array.get(i);
                bean.set_id(material.getString("_id"));
                bean.setAuthor(material.getString("author"));
                bean.setCategory(material.getString("category"));
                bean.setCreatedAt( material.getString("createdAt"));
                bean.setDesc(material.getString("desc"));
                bean.setLikeCounts(material.getInt("likeCounts"));
                bean.setPublishedAt(material.getString("publishedAt"));
                bean.setStars(material.getInt("stars"));
                bean.setTitle(material.getString("title"));
                bean.setType(material.getString("type"));
                bean.setUrl(material.getString("url"));
                bean.setViews(material.getInt("views"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    private byte[] readfromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int length;
        while ((length=inputStream.read(buffer))!=-1) {
            outputStream.write(buffer,0,length);
        }
        inputStream.close();
        return outputStream.toByteArray();
    }
}
