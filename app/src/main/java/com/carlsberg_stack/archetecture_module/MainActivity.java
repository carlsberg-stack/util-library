package com.carlsberg_stack.archetecture_module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.carlsberg_stack.architecture_module_library.base.CarlsActivity;
import com.carlsberg_stack.architecture_module_library.base.fragment.broadcast.CarlsBroadcastActivity;
import com.carlsberg_stack.architecture_module_library.helper.ToastMessage;

public class MainActivity extends CarlsActivity implements MainFragmentInterface {


    @Override
    public void call() {
        ToastMessage.makeDebugToast(getApplicationContext(), "call").show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void carlsBindViews() {
        setContentView( R.layout.activity_main);
    }

    public void toast(View view) {
        switch (view.getId()) {
            case R.id.simple_toast:
                ToastMessage.makeSimpleToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.app_toast:
                ToastMessage.makeAppToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.warning_toast:
                ToastMessage.makeWarningToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.error_toast:
                ToastMessage.makeErrorToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.success_toast:
                ToastMessage.makeSuccessToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.info_toast:
                ToastMessage.makeInfoToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.show_list:
                carlsShowListDialog(R.array.test, null);
                break;
            case R.id.show_alert:
                carlsShowAlert(R.string.app_name);
                break;
            case R.id.show_confirm:
                carlsShowConfirmDialog(R.string.app_name, null);
                break;
        }
    }

}
