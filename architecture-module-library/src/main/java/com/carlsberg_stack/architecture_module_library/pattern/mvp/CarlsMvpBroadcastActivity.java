package com.carlsberg_stack.architecture_module_library.pattern.mvp;

import android.os.Bundle;

import com.carlsberg_stack.architecture_module_library.base.CarlsBroadcastActivity;
import com.carlsberg_stack.architecture_module_library.base.base.CarlsMvp;

public abstract class CarlsMvpBroadcastActivity<T extends CarlsMvp.BasePresenter> extends CarlsBroadcastActivity implements CarlsMvp.BaseView {

    /**
     * The Presenter attached to this View
     */
    protected T presenter;

    /**
     * Must be overriden to define the Presenter used by this activity.
     *
     * @return The presenter that will be used by this View.
     */
    protected abstract T createPresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.presenter = this.createPresenter();
        if (this.presenter != null) {
            this.presenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (this.presenter != null) {
            this.presenter.detachView();
        }
        super.onDestroy();
    }
}