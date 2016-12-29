package com.flydance.tutu.AppUI;

import android.app.Activity;

import com.flydance.basemodule.base.ActivityStack;
import com.flydance.basemodule.superToast.Style;
import com.flydance.basemodule.superToast.SuperActivityToast;
import com.flydance.basemodule.superToast.utils.PaletteUtils;

/**
 * Created by tutu on 2016/12/29.
 */

public class Toast {
    public static void showToast(String msg){
        Activity activity = ActivityStack.getTopActivityNoRemove();
        SuperActivityToast.create(activity, new Style(), Style.TYPE_STANDARD)
                .setText(msg)
                .setDuration(Style.DURATION_SHORT)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.PRIMARY))
                .setAnimations(Style.ANIMATIONS_POP).show();
    }
}
