package kr.ac.kookmin.everydaylifelogger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckActivity extends Activity {

    Button back; // 메인으로 돌아가는 버튼
    TextView list; // List를 띄워줄 텍스트뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        DBManager dbManager = new DBManager(getApplicationContext(), "List.db", null, 1);

        back = (Button) findViewById(R.id.bt_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list = (TextView) findViewById(R.id.text_list);

        Intent intent = getIntent();
        String str = intent.getStringExtra("List");
        if(str != null) {
            list.setText(str);
            list.setVerticalScrollBarEnabled(true); // 텍스트뷰에 스크롤
            list.setMovementMethod(new ScrollingMovementMethod());
        }
        else{
            str = "DATA NULL";
            list.setText(str);
            list.setVerticalScrollBarEnabled(true); // 텍스트뷰에 스크롤
            list.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}
