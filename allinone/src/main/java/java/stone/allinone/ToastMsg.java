package java.stone.allinone;

import android.content.Context;
import android.widget.Toast;

public class ToastMsg {
    public static void toastMsg(Context context, String Msg) {
        Toast.makeText(context,Msg,Toast.LENGTH_SHORT).show();
    }
}
