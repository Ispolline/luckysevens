package com.classic.vullks.casinoslots;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

public class PlayDialog extends DialogFragment {
    chooseDialogInterface inter;
    Context context;
    public PlayDialog(Context context, chooseDialogInterface inter){
this.context = context;
        this.inter = inter;
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Title!");
        View v = inflater.inflate(R.layout.dialog_play, null);
        final Drawable d = new ColorDrawable(Color.BLACK);
        d.setAlpha(130);

        getDialog().getWindow().setBackgroundDrawable(d);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);
        ImageView materialButton = v.findViewById(R.id.mbtn_click);
        materialButton.setOnClickListener(v1 -> {
            dismiss();
            inter.foo();
        });

        return v;
    }



    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);


    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
