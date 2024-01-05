package java.stone.allinone;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Com_Word {
    ArrayList<String >arrayLists = new ArrayList<>();
    Context context;
    TableLayout tb;

        public void readFiles(Context context,TableLayout tb) {
            this.context = context;
            this.tb = tb;
            //StringBuilder sb = new StringBuilder();
            AssetManager asm = context.getAssets();
            try {
                InputStream is = asm.open("com_word.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine())!=null) {
                    arrayLists.add(line);
                }

                for (int i = 0;i<arrayLists.size();i++) {
                    if (i%2 != 0) {
                        int t = i-1;
                        createTable(arrayLists.get(t),arrayLists.get(i));

                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void createTable(String s1, String s2) {
            TableRow.LayoutParams param1 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT);
            TableRow.LayoutParams param2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT);
            TableRow tRow = new TableRow(context.getApplicationContext());
            Button t1 = new Button(context.getApplicationContext());
            Button t2 = new Button(context.getApplicationContext());
            t1.setLayoutParams(param1);
            t2.setLayoutParams(param2);
            tRow.addView(t1,param1);
            tRow.addView(t2,param2);
            param1.setMargins(4,2,2,2);
            param2.setMargins(2,2,4,2);
            t1.setBackgroundColor(Color.GRAY);
            t2.setBackgroundColor(Color.GRAY);
            t1.setGravity(Gravity.CENTER);
            t2.setGravity(Gravity.CENTER);
            t1.setTextSize(11);
            t2.setTextSize(11);
            t1.setHeight(180);
            t2.setHeight(180);
            t1.setAllCaps(false);
            t2.setAllCaps(false);
            tb.addView(tRow);
            t1.setText(s1);
            t2.setText(s2);
        }
}
