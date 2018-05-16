package com.example.mvpreaderjava.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

/**
 * @author savion
 */
public abstract class ExtraDelegate<TARGET extends ExtraDelegateBehavior> {

    protected TARGET target;

    public static <TARGET extends ExtraDelegateBehavior> ExtraDelegate create(TARGET target) {
        if (target instanceof Fragment) {
            return new ExtraDelegateFragment(target);
        } else if (target instanceof Activity) {
            return new ExtraDelegateActivity(target);
        }
        return null;
    }

    public ExtraDelegate(TARGET target) {
        this.target = target;
    }
}
