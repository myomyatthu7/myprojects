package java.stone.allinone;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.stone.allinone.library.Custm_List;
import java.util.ArrayList;

public class MyDictionary {
    Custm_List custmList;

    Context context;
    ListView lv;
    String [] aryDic;
    public MyDictionary(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }
    String readFile() {
        StringBuilder builder = new StringBuilder();
        AssetManager asm = context.getAssets();
        try {
            InputStream is = asm.open("dic.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=br.readLine())!= null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }
    void showDic() {
        ArrayList<String> alWord = new ArrayList<>();
        ArrayList<String> alPho = new ArrayList<>();
        aryDic = readFile().split("\n");
        for (String dic: aryDic) {
            String [] ary = dic.split(";");
            alWord.add(ary[0]);
            alPho.add(ary[1]);
        }
        custmList = new Custm_List(context,alWord,alPho);
        lv.setAdapter(custmList);
    }
    String itemClicked(int position) {
        //ToastMsg.toastMsg(context,String.valueOf(position));
        String [] eng = lv.getItemAtPosition(position).toString().split("/");
        return eng[0];
    }

    public void searchText(String newText,String tabChange) {
        ArrayList<String> arySearchWord = new ArrayList<>();
        ArrayList<String> arySearchPho = new ArrayList<>();
        for (String word : aryDic) {
            if (word.contains(newText)|| tabChange.contentEquals("Two")) {
                String [] words = word.split(";");
                arySearchWord.add(words[0]);
                arySearchPho.add(words[1]);
            }

            custmList = new Custm_List(context,arySearchWord,arySearchPho);
            lv.setAdapter(custmList);
        }
    }

    public void createMenu(Menu menu, String tabChange) {
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        if (searchView != null) {
            searchView.setQueryHint("Search Here");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    ArrayList<String> arySearchWord = new ArrayList<>();
                    ArrayList<String> arySearchPho = new ArrayList<>();
                    for (String word : aryDic) {
                        if (word.contains(newText)|| tabChange.contentEquals("Two")) {
                            String [] dic = word.split(";");
                            arySearchWord.add(dic[0]);
                            arySearchPho.add(dic[1]);
                        }
                    }
                    custmList = new Custm_List(context,arySearchWord,arySearchPho);
                    lv.setAdapter(custmList);
                    return true;
                }
            });
        }
    }
}


