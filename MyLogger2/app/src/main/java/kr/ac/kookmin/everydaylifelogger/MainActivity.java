package kr.ac.kookmin.everydaylifelogger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    Button insert;
    Button check;
    Button stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBManager dbManager = new DBManager(getApplicationContext(), "List.db", null, 1);

        insert = (Button) findViewById(R.id.bt_insert);
        check = (Button) findViewById(R.id.bt_check);
        stats = (Button) findViewById(R.id.bt_stats);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_insert:
                        intent = new Intent(MainActivity.this, InsertActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.bt_check:
                        String str = dbManager.PrintData();
                        intent = new Intent(MainActivity.this, CheckActivity.class);
                        intent.putExtra("List", str);
                        startActivity(intent);
                        break;

                    case R.id.bt_stats:
                        intent = new Intent(MainActivity.this, StatsActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        insert.setOnClickListener(listener);
        check.setOnClickListener(listener);
        stats.setOnClickListener(listener);
    }
}