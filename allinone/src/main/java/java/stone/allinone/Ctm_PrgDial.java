package java.stone.allinone;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.zip.Inflater;

public class Ctm_PrgDial extends Dialog {
    protected Ctm_PrgDial(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener,String str) {
        super(context, cancelable, cancelListener);
//        WindowManager.LayoutParams params = Objects.requireNonNull(getWindow()).getAttributes();
//        params.gravity = Gravity.CENTER;
//        getWindow().setAttributes(params);
        //LayoutInflater inflater = getLayoutInflater();
        View v = LayoutInflater.from(context).inflate(R.layout.progress_bar,null,false);
        TextView tv = v.findViewById(R.id.tvProBar);
        tv.setText(str);
        setContentView(v);
    }
}
