package stone.dhamma.channel.dhammachannel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frg_MyanPyan extends Fragment {
    private TextView tvMyanPyan;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_mp, container, false);
        tvMyanPyan = v.findViewById(R.id.tvMyanPyan);
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    protected void textChange(int text) {
        if (tvMyanPyan.getText().toString().isEmpty()) {
            //Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            tvMyanPyan.setText(text);
        }
//        else {
//            Toast.makeText(getContext(),"No Empty", Toast.LENGTH_SHORT).show();
//        }
    }

    protected void textSize(int size) {
        tvMyanPyan.setTextSize(size);
    }
}
