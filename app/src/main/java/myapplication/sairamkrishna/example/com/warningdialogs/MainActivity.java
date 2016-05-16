package myapplication.sairamkrishna.example.com.warningdialogs;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnWarning;
    private Button btnExit;
    private Button btnList;
    private TextView tvLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnExit = (Button) findViewById(R.id.btnExit);
        btnWarning = (Button) findViewById(R.id.btnWarning);
        btnList = (Button) findViewById(R.id.btnList);
        tvLang = (TextView) findViewById(R.id.tvLang);
    }

    private void setupListeners() {
        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new WarningDialog();
                dialogFragment.show(getFragmentManager(), null);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new ExitDialog();
                dialogFragment.show(getFragmentManager(), null);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new ListDialog();
                dialogFragment.show(getFragmentManager(), null);
            }
        });
    }

    public void setLang(String lang) {
        tvLang.setText(lang);
    }

    public String getLang() {
        return tvLang.getText().toString();
    }
}
