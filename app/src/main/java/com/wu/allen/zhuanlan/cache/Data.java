// (c)2016 Flipboard Inc, All Rights Reserved.


// here reference is https://github.com/rengwuxian/RxJavaSamples/tree/master/app/src/main/java/com/rengwuxian/rxjavasamples/module/cache_6/data

package com.wu.allen.zhuanlan.cache;

import android.support.annotation.NonNull;
import android.util.Log;

import com.wu.allen.zhuanlan.model.Girl;
import com.wu.allen.zhuanlan.model.Item;
import com.wu.allen.zhuanlan.net.Network;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
public class Data {
    private static Data instance;
    // BehaviorSubject 只打印出最后一个数据
    BehaviorSubject<List<Item>> cache;
    private Data() {
    }
    // 单例
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
    // 从网络加载数据
    public void loadFromNetwork(final int page) {
        Log.e("Data","loadFromNetwork() is ok");
        Network.getGankApi()
                .getBeauties(page, 1)
                .subscribeOn(Schedulers.io())
                // Observable 返回的类型 GankBeautyResult Map 转换成 List<Map>
                .map(new Func1<Girl, List<Item>>() {
                    @Override
                    public List<Item> call(Girl girl) {
                        List<Girl.GirlResult> gankBeauties = girl.girlResults;
                        List<Item> items = new ArrayList<>(gankBeauties.size());
                        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
                        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                        for (Girl.GirlResult gankBeauty : gankBeauties) {
                            Item item = new Item();
                            try {
                                Date date = inputFormat.parse(gankBeauty.createdAt);
                                item.description = outputFormat.format(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                                item.description = "unknown date";
                            }
                            item.imageUrl = gankBeauty.url;
                            items.add(item);
                        }
                        Log.e("Data","Map data is ok");
                        return items;
                    }
                })
                // 在 doOnNext() 之前先处理一下 Action1<List<Item>> 里面的数据就是输入的数据
                .doOnNext(new Action1<List<Item>>() {
                    @Override
                    public void call(List<Item> items) {
                        // 写入缓存
                        Log.e("Data","data write in disk cache");
                        Database.getInstance().writeItems(items);
                    }
                })
                .subscribe(new Action1<List<Item>>() {
                    @Override
                    public void call(List<Item> items) {
                        Log.e("Data","data pass to subscribe");
                        cache.onNext(items);// 自动回调 cache.onNext(items);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }
    // 获取数据
    public Subscription subscribeData(@NonNull Observer<List<Item>> observer,final int number) {
        Log.e("Data",number+ "");
        if (cache == null ) {
            cache = BehaviorSubject.create();
            Observable.create(new Observable.OnSubscribe<List<Item>>() {
                @Override
                public void call(Subscriber<? super List<Item>> subscriber) {
                    List<Item> items = Database.getInstance().readItems();

                    if (items == null) {
                        Log.e("Data","no data in disk and load data from net");
                        loadFromNetwork(number);
                    } else {
                        Log.e("Data","disk has data");
                        subscriber.onNext(items);
                    }
                }
            })
                    .subscribeOn(Schedulers.io())
                    .subscribe(cache);// 观察者与被观察着通过订阅联系起来
        } else {
            Log.e("Data","memory has data just read from memory");
        }
        return cache.observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
    }

    public void clearMemoryCache() {
        cache = null;
    }
    // 内存和磁盘缓存
    public void clearMemoryAndDiskCache() {
        clearMemoryCache();
        // 删除磁盘缓存
        Database.getInstance().delete();
    }
}
