package com.jeench.shoplist.data;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by Radik on 30.11.2017.
 */

public class Item {
    @SerializedName("shop_name")
    public String shopName;

    @SerializedName("shop_logo")
    public String shopLogoUrl;

    @SerializedName("shop_rank")
    public int shopRank;

    @SerializedName("item_image")
    public String itemImageUrl;

    @SerializedName("item_name")
    public String itemName;

    @SerializedName("item_price")
    public float itemPrice;

    @SerializedName("point_distance")
    public int pointDistance;
}
