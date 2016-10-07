package com.vrjco.v.vimagebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by VRUSHABH on 20-09-2016.
 */
public class VImageButtonView extends RelativeLayout {

    private static final String TAG = "VImageButtonView";
    //Main views
    private TextView textHolder;
    private ImageView underImageHolder, overImageHolder;
    //Layout parameters
    private LayoutParams textParams, imageParams;


    public VImageButtonView(Context context) {
        super(context, null);
        setupView(context, null, 0);
    }

    public VImageButtonView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        setupView(context, attrs, 0);
    }

    public VImageButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView(context, attrs, defStyleAttr);

    }

    //create main view
    private void setupView(Context context, AttributeSet attrs, int defStyleAttr) {
        try {
            //remove all views if exists
            removeAllViews();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //initializing main views
        textHolder = new TextView(context);
        underImageHolder = new ImageView(context);
        overImageHolder = new ImageView(context);

        //load text parameters
        textParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        //set text parameters
        setTextParams(textParams);

        //load image parameters
        imageParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        //set image parameters
        setImageParams(imageParams);

        //hide overlay view
        overImageHolder.setVisibility(GONE);
        //setting default background
        underImageHolder.setBackgroundColor(Color.GRAY);

        if (attrs != null) {
            try {
                TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.VImageButtonView, defStyleAttr, 0);

                /**
                 * TextView start
                 **/
                String text = "" + array.getText(R.styleable.VImageButtonView_android_text);
                //setting text
                setText(text);

                int textColor = array.getColor(R.styleable.VImageButtonView_android_textColor, Color.BLACK);
                //setting text color
                setTextColor(textColor);

                float textSize = array.getDimension(R.styleable.VImageButtonView_android_textSize, 10.0f);
                //setting text size
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);

                int textGravity = array.getInteger(R.styleable.VImageButtonView_android_gravity, Gravity.CENTER);
                //setting text gravity
                setGravity(textGravity);

                //load text padding for each {top, bottom, left, right}
                float textTopPadding = array.getDimension(R.styleable.VImageButtonView_textTopPadding, 0);
                float textBottomPadding = array.getDimension(R.styleable.VImageButtonView_textBottomPadding, 0);
                float textLeftPadding = array.getDimension(R.styleable.VImageButtonView_textLeftPadding, 0);
                float textRightPadding = array.getDimension(R.styleable.VImageButtonView_textRightPadding, 0);

                //setting text padding for each {top, bottom, left, right}
                setTextPadding((int) textLeftPadding, (int) textTopPadding,
                        (int) textRightPadding, (int) textBottomPadding);

                //load text padding single instance
                float textPadding = array.getDimension(R.styleable.VImageButtonView_textPadding, 0);
                //setting text padding
                if (((int) textPadding) != 0) {
                    setTextPadding((int) textPadding, (int) textPadding,
                            (int) textPadding, (int) textPadding);
                }

                /**
                 * TextView ends
                 **/

                /**
                 * ImageView start
                 **/

                int background = array.getResourceId(R.styleable.VImageButtonView_android_background, Color.TRANSPARENT);
                //setting background color
                setBackgroundResource(background);

                int src = array.getResourceId(R.styleable.VImageButtonView_android_src, Color.TRANSPARENT);
                //setting image source
                setImage(src);

                int IScaleType = array.getInt(R.styleable.VImageButtonView_android_scaleType, -1);
                if (IScaleType > -1) {
                    try {
                        ImageView.ScaleType[] scaleTypes = ImageView.ScaleType.values();
                        ImageView.ScaleType scaleType = scaleTypes[IScaleType];
                        //setting image scale type
                        setScaleType(scaleType);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //load image padding for each {top, bottom, left, right}
                float imageTopPadding = array.getDimension(R.styleable.VImageButtonView_imageTopPadding, 0);
                float imageBottomPadding = array.getDimension(R.styleable.VImageButtonView_imageBottomPadding, 0);
                float imageLeftPadding = array.getDimension(R.styleable.VImageButtonView_imageLeftPadding, 0);
                float imageRightPadding = array.getDimension(R.styleable.VImageButtonView_imageRightPadding, 0);

                //setting image padding for each {top, bottom, left, right}
                setImagePadding((int) imageLeftPadding, (int) imageTopPadding
                        , (int) imageRightPadding, (int) imageBottomPadding);

                //load image padding for single instance
                float imagePadding = array.getDimension(R.styleable.VImageButtonView_imagePadding, 0);
                if (((int) imagePadding) != 0) {
                    //setting image padding
                    setImagePadding((int) imagePadding, (int) imagePadding,
                            (int) imagePadding, (int) imagePadding);
                }
                /**
                 * ImageView ends
                 **/


                /**
                 * OverlayView start
                 **/
                //load overlay and overlay-alpha
                int overlay = array.getColor(R.styleable.VImageButtonView_overlay, Color.TRANSPARENT);
                float overlayAlpha = array.getFloat(R.styleable.VImageButtonView_overlayAlpha, 0.0f);

                if (overlay != Color.TRANSPARENT) {
                    //setting overlay
                    setImageOverlay(overlay);
                    //setting overlay alpha
                    setImageOverlayAlpha(overlayAlpha);
                } else {
                    removeImageOverlay();
                }

                /**
                 * OverlayView ends
                 **/

                array.recycle();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
                e.printStackTrace();
            }
        }

        addView(underImageHolder);
        addView(overImageHolder);
        addView(textHolder);
    }


    /**
     * TextView methods start
     **/

    //textView view parameter
    public void setTextParams(LayoutParams layoutParams) {
        textParams = layoutParams;
        textHolder.setLayoutParams(textParams);
    }

    //set Text
    public void setText(String text) {
        textHolder.setText(text);
    }

    //set Text Color
    public void setTextColor(int color) {
        textHolder.setTextColor(color);
    }

    //set text padding
    public void setTextPadding(int left, int top, int right, int bottom) {
        textHolder.setPadding(left, top, right, bottom);
    }

    //set text size
    public void setTextSize(int size, float textSize) {
        textHolder.setTextSize(size, textSize);
    }

    //set text gravity
    public void setGravity(int gravity) {
        textHolder.setGravity(gravity);
    }

    /**
     * TextView methods ends
     **/


    /**
     * ImageView methods start
     **/

    //set imageView view parameters
    public void setImageParams(LayoutParams layoutParams) {
        imageParams = layoutParams;
        underImageHolder.setLayoutParams(imageParams);
        overImageHolder.setLayoutParams(imageParams);
    }

    //set background color
    public void setBackgroundColor(@NonNull int color) {
        try {
            underImageHolder.setBackgroundColor(color);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    //set background image
    public void setBackgroundResource(int resource) {
        try {
            underImageHolder.setBackgroundResource(resource);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    //set source image
    //type: resource
    public void setImage(@DrawableRes int resource) {
        try {
            underImageHolder.setImageResource(resource);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    //type: drawable
    public void setImage(@NonNull Drawable drawable) {
        try {
            underImageHolder.setImageDrawable(drawable);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    //type: bitmap
    public void setImage(@NonNull Bitmap bitmap) {
        try {
            underImageHolder.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    //type: uri
    public void setImage(@NonNull Uri uri) {
        try {
            underImageHolder.setImageURI(uri);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }

    //set image scale
    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        underImageHolder.setScaleType(scaleType);
    }

    //set image padding
    public void setImagePadding(int left, int top, int right, int bottom) {
        underImageHolder.setPadding(left, top, right, bottom);
    }

    /**
     * ImageView methods ends
     **/


    /**
     * OverlayImageView methods start
     **/

    //set overlay color
    public void setImageOverlay(int color) {
        overImageHolder.setBackgroundColor(color);
        overImageHolder.setVisibility(VISIBLE);
    }

    //set overlay color alpha
    private void setImageOverlayAlpha(float alpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (alpha != 0.0f) {
                overImageHolder.setAlpha(alpha);
            } else {
                overImageHolder.setAlpha(0.0f);
            }
        }
    }

    //remove overlay
    public void removeImageOverlay() {
        overImageHolder.setVisibility(GONE);
    }

    /**
     * OverlayImageView methods ends
     **/


}
