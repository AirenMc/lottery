package com.jason.mytools.mytools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import static java.util.Arrays.*;

public class lottery extends AppCompatActivity {
    Button btn_change;
    TextView view_normalnum,view_specialnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lottery);
        btn_change = (Button)findViewById(R.id.btn_change);
        view_normalnum = (TextView)findViewById(R.id.view_normalnum);
        view_specialnum = (TextView)findViewById(R.id.view_specialnum);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normalnum();
                specialnum();
            }
        });
    }

    private void normalnum(){
        int normal[] = new int[6];
        //01-33
        int i,x;
        for(i = 0 ; i<6 ; i++)
        {
            Random random = new Random();
            int arr_ele = random.nextInt(33) + 1;
            if (i>0)
            {
                for (x = 0; x<=i ; x++)
                {
                    while(normal[x] == arr_ele)
                    {
                        arr_ele = random.nextInt(33) + 1;
                    }
                }
            }
            normal[i] = arr_ele;
        }
        sort(normal);
        String string = "";
        for(int z=0 ; z<6 ; z++) {

            string += normal[z] + " ";
        }

        view_normalnum.setText(String.valueOf(string));

    }



    private void specialnum(){

        /*前六位范围是1-33，最后一位范围为1-16*/
        Random random = new Random();
        int special = random.nextInt(16) + 1;
        view_specialnum.setText(String.valueOf(special));
    }
}
