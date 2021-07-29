package com.classic.vullks.casinoslots.presentation;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.DialogFragment;

import com.airbnb.lottie.LottieAnimationView;
import com.classic.vullks.casinoslots.R;

public class WinDialog extends DialogFragment {
    chooseDialogInterface inter;
    Context context;

    public WinDialog() {
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    LottieAnimationView winAnimation;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_win, null);
        final Drawable d = new ColorDrawable(Color.BLACK);
        d.setAlpha(130);
        getDialog().getWindow().setBackgroundDrawable(d);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);
        winAnimation = v.findViewById(R.id.animationView);
        return v;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        // Перевод пользователя на авторизацию
        if(Common.magicChecker == 1){
            startActivity(new Intent(getActivity(), AuthActivity.class));
        }
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
