package com.example.seedtrackingtracing.utils;


import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.seedtrackingtracing.R;

/**
 * Created by Bazictips on 23-Feb-16.
 */
public class FontManager {

    Context c;

    public FontManager(Context context) {
        this.c = context;
    }


    public void setAppMedium(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "AppSans_medium.otf");
        tv.setTypeface(font);
    }

    public void setBebasRegular(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "bebasbold.otf");
        tv.setTypeface(font);
    }

    public void setAppRegular(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "AppSans_regular.otf");
        tv.setTypeface(font);
    }

    public void setOpenSansRegular(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "opensans_regular.ttf");
        tv.setTypeface(font);
    }

    public void setHelvRegular(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "helv.otf");
        tv.setTypeface(font);
    }


    public void setOpenSansLight(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "opensans_light.ttf");
        tv.setTypeface(font);
    }

    public void setBackIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_angle_left));
    }

    public void setPlayIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_play_circle_o));
    }

    public void setFrontIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_angle_right));
    }

    public void setHeartIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_heart));
    }

    public void setRoundTickIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_check_circle));
    }

    public void setFrontRoundIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_chevron_circle_right));
    }

    public void setCameraIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_camera_retro));
    }

    public void setRocketIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_rocket));
    }


    public void setPlusCircleIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_plus_circle));
    }

    public void setUserIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_user));
    }

    public void setPlusIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_plus));
    }

    public void setUserPlusIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_user_plus));
    }

    public void setCancelIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_close));
    }

    public void setAcceptIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_check));
    }

    public void setRejectIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_close));
    }

    public void setCommentIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_comment));
    }

    public void setLikeIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_thumbs_up));
    }

    public void setStarIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_star));
    }

    public void setTimeIcon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_clock_o));
    }


    public void setCheckicon(TextView tv) {

        Typeface font = Typeface.createFromAsset(c.getAssets(), "FontAwesome.otf");
        tv.setTypeface(font);
        tv.setText(c.getString(R.string.fa_check_square_o));
    }


}
