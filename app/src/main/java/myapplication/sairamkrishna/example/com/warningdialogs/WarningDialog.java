package myapplication.sairamkrishna.example.com.warningdialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by programer on 16.5.2016..
 */
public class WarningDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //objekt izgraduje objekt:
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //iz unutarnje ugradene pohrane android.R.attr uzimamo sliku:
        builder.setIconAttribute(android.R.attr.alertDialogIcon);
        builder.setTitle(R.string.input_data);
        builder.setMessage(R.string.please_insert_name);

        //
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }
}
