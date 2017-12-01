package com.jeench.shoplist.ui;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Radik on 01.12.2017.
 */

public class BindingAdapters {
    @BindingAdapter("app:imageUrlCircle")
    public static void loadImageCircled(ImageView iw, String url) {
        loadImage(iw, url, new CircleCrop());
    }

    @BindingAdapter("app:imageUrlRoundCorners")
    public static void loadImageRounded(ImageView iw, String url) {
        loadImage(iw, url, new MultiTransformation<>(
                new CenterCrop(),
                new RoundedCorners(15)));
    }

    private static void loadImage(ImageView iw, String url, Transformation<Bitmap> transformation) {
        Glide
                .with(iw.getContext())
                .load(url)
                .apply(RequestOptions.bitmapTransform(transformation))
                .into(iw);
    }
}
