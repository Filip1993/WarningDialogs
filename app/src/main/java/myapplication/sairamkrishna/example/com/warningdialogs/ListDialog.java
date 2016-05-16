package myapplication.sairamkrishna.example.com.warningdialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by programer on 16.5.2016..
 */
public class ListDialog extends DialogFragment {

    private String[] languages = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        languages = getResources().getStringArray(R.array.languages);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.choose_lang);

        //samo jedan izbor:
        /*builder.setItems(languages, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String lang = languages[which];

                //moramo castati u MainActivity jer se koristimo s TextView-om iz MainActivity-ja
                MainActivity ma = (MainActivity) getActivity();
                ma.setLang(lang);
            }
        });*/

        //Multi Choice:

        builder.setMultiChoiceItems(languages, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                MainActivity ma = (MainActivity) getActivity();
                String lang = languages[which];
                String text = ma.getLang();

                //distinkcija:
                if (isChecked) {
                    text += lang + "; ";
                } else {
                    text = text.replace(lang + ";", "");
                }

                ma.setLang(text);
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }
}
