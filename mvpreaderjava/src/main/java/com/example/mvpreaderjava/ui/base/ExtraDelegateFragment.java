package com.example.mvpreaderjava.ui.base;

import android.os.Bundle;

import java.io.Serializable;

public class ExtraDelegateFragment<D extends Serializable, TARGET extends ExtraDelegateBehavior<D>> extends ExtraDelegate<TARGET> {
    public ExtraDelegateFragment(TARGET extraDelegateBehavior) {
        super(extraDelegateBehavior);
    }

    public void setArgument(Bundle bundle){
    }

}
