package java.stone.allinone.frgment;

import static java.nio.file.Files.createDirectory;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.stone.allinone.R;
import java.stone.allinone.ToastMsg;
import java.util.Objects;

public class MusicFrg extends Fragment implements View.OnClickListener {
    View v;
    // Add this code in your activity or fragment
    private static final int REQUEST_STORAGE_PERMISSION = 1;
    Context context;
    String text;
    TextView tvPath;
    EditText etText;
    Button btnInternalCache,btnExternalCache,btnExternalStoragePrivate,btnExternalStoragePublic,btnGoNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_music_frg, container, false);
        return v;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_STORAGE_PERMISSION) {
            // If the request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with your code
                //createDirectory();
            } else {
                // Permission denied, show a message or take appropriate action
                Toast.makeText(getContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvPath = v.findViewById(R.id.tvPath);
        etText = v.findViewById(R.id.etText);
        btnInternalCache = v.findViewById(R.id.btnInternalCache);
        btnExternalCache = v.findViewById(R.id.btnExternalCache);
        btnExternalStoragePrivate = v.findViewById(R.id.btnExternalStoragePrivate);
        btnExternalStoragePublic = v.findViewById(R.id.btnExternalStoragePublic);
        btnGoNext = v.findViewById(R.id.btnGoNext);

        btnInternalCache.setOnClickListener(this);
        btnExternalCache.setOnClickListener(this);
        btnExternalStoragePrivate.setOnClickListener(this);
        btnExternalStoragePublic.setOnClickListener(this);
        btnGoNext.setOnClickListener(this);

// Check if the app has permission to write to external storage
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_STORAGE_PERMISSION);
        } else {
            // Permission is already granted, proceed with your code
            //createDirectory();
            ToastMsg.toastMsg(getContext(),"Permission");
        }


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnInternalCache) {
            saveInternalCache();
        } else if (id == R.id.btnExternalCache) {
            saveExternalCache();
        } else if (id == R.id.btnExternalStoragePrivate) {
            saveExternalStoragePrivate();
        } else if (id == R.id.btnExternalStoragePublic) {
            saveExternalStoragePublic();
        } else if (id == R.id.btnGoNext) {
            goNext();
        }
    }

    private void goNext() {
    }

    private void saveExternalStoragePublic() {
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        text = etText.getText().toString();
        File file = new File(path,"text5.txt");
        FileOutputStream fops = null;
        try {
            fops = new FileOutputStream(file);
            fops.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fops != null) {
                    fops.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        tvPath.setText(text+" was created in "+path.getAbsolutePath());
    }

//    private void saveExternalStoragePublic() {
//        File publicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
//        text = etText.getText().toString();
////        if (!publicDir.exists()) {
////            publicDir.mkdirs();
////        }
//        File txtFile = new File(publicDir,"text4.txt");
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(txtFile);
//            fileOutputStream.write(text.getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        tvPath.setText(text+" was created in "+publicDir.getAbsolutePath());
//    }

    private void saveExternalStoragePrivate() {
        File path = requireContext().getExternalFilesDir("mmt");
        text = etText.getText().toString();
        File file = new File(path,"text3.txt");
        FileOutputStream fops = null;
        try {
            fops = new FileOutputStream(file);
            try {
                fops.write(text.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fops != null) {
                try {
                    fops.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (path != null) {
            tvPath.setText(text+" was created in "+path.getAbsolutePath());
        }
    }

    private void saveExternalCache() {
        File path = requireContext().getExternalCacheDir();
        text = etText.getText().toString();
        File file = new File(path,"text2.txt");
        FileOutputStream fosp = null;
        try {
            fosp = new FileOutputStream(file);
            fosp.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fosp != null) {
                try {
                    fosp.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (path != null) {
            tvPath.setText(text+" was created in "+path.getAbsolutePath());
        }
    }

    private void saveInternalCache() {
        File path = requireContext().getCacheDir();
        File file = new File(path,"text1.txt");
        text = etText.getText().toString();
        FileOutputStream fops = null;
        try {
            fops = new FileOutputStream(file);
            fops.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fops != null) {
                    fops.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        tvPath.setText(text+" was created in "+path.getAbsolutePath());
    }
}