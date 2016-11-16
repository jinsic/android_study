package kr.ac.kookmin.everydaylifelogger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends Activity{
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        DBManager dbManager = new DBManager(getApplicationContext(), "List.db", null, 1);

        result = (TextView) findViewById(R.id.text_result);
        result.setText(
                "∙  학습: " + dbManager.result_study() + "%\n\n" +
                        "∙  운동: " + dbManager.result_sports() + "%\n\n" +
                        "∙  식사: " + dbManager.result_meal() + "%\n\n" +
                        "∙  문화: " + dbManager.result_culture() + "%\n\n" +
                        "∙  여행: " + dbManager.result_travel() + "%\n\n" +
                        "∙  기타: " + dbManager.result_etc() + "%\n\n"
        );
    }
}
