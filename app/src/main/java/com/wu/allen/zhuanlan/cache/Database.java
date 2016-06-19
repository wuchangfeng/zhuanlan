// (c)2016 Flipboard Inc, All Rights Reserved.
// here reference is https://github.com/rengwuxian/RxJavaSamples/tree/master/app/src/main/java/com/rengwuxian/rxjavasamples/module/cache_6/data
package com.wu.allen.zhuanlan.cache;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wu.allen.zhuanlan.App;
import com.wu.allen.zhuanlan.model.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class Database {
    private static String DATA_FILE_NAME = "data.db";

    private static Database INSTANCE;
    File dataFile = new File(App.getInstance().getFilesDir(), DATA_FILE_NAME);
    Gson gson = new Gson();
    //System.out.println()

    private Database() {
        Log.e("App.getInstance()",App.getInstance().getFilesDir().toString());
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
            Log.e("TAG","getInstance");
        }
        Log.e("App.getInstance()",App.getInstance().getFilesDir().toString());
        Log.e("TAG","getInstance1");
        return INSTANCE;
    }

    public List<Item> readItems() {
        // Hard code adding some delay, to distinguish reading from memory and reading disk clearly
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Log.e("TAG","read");
            Reader reader = new FileReader(dataFile);
            return gson.fromJson(reader, new TypeToken<List<Item>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeItems(List<Item> items) {
        String json = gson.toJson(items);
        try {
            if (!dataFile.exists()) {
                try {
                    dataFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Writer writer = new FileWriter(dataFile);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        dataFile.delete();
    }
}
