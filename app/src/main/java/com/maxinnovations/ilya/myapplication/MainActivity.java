package com.maxinnovations.ilya.myapplication;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AlertDialog chooserDialog;
    String message="hey buddy";
    String rangers[]={"red","blue","pink","green","yellow"};

private static boolean blue=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView= (TextView) findViewById(R.id.textView);
        final Button submitBtn=(Button)findViewById(R.id.button);
        final RelativeLayout layout=(RelativeLayout)findViewById(R.id.backgorund);
        final Button btnclick2=(Button)findViewById(R.id.button2);
        final Button btnDialog= (Button) findViewById(R.id.btndialog);
        final ImageView iv= (ImageView) findViewById(R.id.iv);
        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.e(message,"was printed dude");
                Toast.makeText(MainActivity.this," was clicked ",Toast.LENGTH_LONG).show();
                textView.setText("hello guy");

            }
        });

        btnclick2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
if(blue) {
    layout.setBackgroundColor(Color.BLUE);
    blue=!blue;
    return;
}
                blue=!blue;
                layout.setBackgroundColor(Color.DKGRAY);

            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Its Morphin Time!! please choose ranger");
                alertDialog.setSingleChoiceItems(rangers, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int rangers) {
                        switch (rangers){
                            case 0: iv.setImageResource(R.drawable.red);
                               layout.setBackgroundColor(Color.RED);
                                break;
                            case 1: iv.setImageResource(R.drawable.blue);
                                layout.setBackgroundColor(Color.BLUE);
                                break;
                            case 2: iv.setImageResource(R.drawable.pink);
                                layout.setBackgroundColor(Color.MAGENTA);
                                break;
                            case 3: iv.setImageResource(R.drawable.green);
                               layout.setBackgroundColor(Color.GREEN);
                                break;
                            case 4: iv.setImageResource(R.drawable.yellow);
                                layout.setBackgroundColor(Color.YELLOW);
                                break;

                        }
                        chooserDialog.dismiss();
                    }
                });
                chooserDialog=alertDialog.create();
                chooserDialog.show();
            }
        });
    }



}
