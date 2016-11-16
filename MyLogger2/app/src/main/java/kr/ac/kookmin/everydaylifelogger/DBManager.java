package kr.ac.kookmin.everydaylifelogger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    // Table 생성
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE SCHEDULE_LIST(location TEXT NOT NULL, category TEXT NOT NULL, doing TEXT);");
        } catch (android.database.sqlite.SQLiteException e) {
            Log.d("finalProject","error: "+ e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }
    public String PrintData() {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST ", null);
        while(cursor.moveToNext()) {
            str += "위치 : " + cursor.getString(0) + "\n"
                    + "분류 : "
                    + cursor.getString(1)
                    + "\n"
                    + cursor.getString(2)
                    + "\n\n";
        }
        return str;
    }


    // 통계
    // 학습
    public double result_study(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        double all_num = 0; // 전체
        double doing = 0; // 해당 행동
        double result = 0; // %

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST", null);

        while(cursor.moveToNext()) {
            all_num += 1;
            str = cursor.getString(1);
            if(str.equals("학습")){doing+=1;}
        }

        result = (doing/all_num)*100;
        result = Double.parseDouble(String.format("%.3f", result));

        return result;
    }

    // 운동
    public double result_sports(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        double all_num = 0;
        double doing = 0;
        double result = 0;

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST", null);

        while(cursor.moveToNext()) {
            all_num += 1;
            str = cursor.getString(1);
            if(str.equals("운동")){doing+=1;}
        }

        result = (doing/all_num)*100;
        result = Double.parseDouble(String.format("%.3f", result));

        return result;
    }

    // 식사
    public double result_meal(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        double all_num = 0;
        double doing = 0;
        double result = 0;

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST", null);

        while(cursor.moveToNext()) {
            all_num += 1;
            str = cursor.getString(1);
            if(str.equals("식사")){doing+=1;}
        }

        result = (doing/all_num)*100;
        result = Double.parseDouble(String.format("%.3f", result));

        return result;
    }

    // 문화
    public double result_culture(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        double all_num = 0;
        double doing = 0;
        double result = 0;

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST", null);

        while(cursor.moveToNext()) {
            all_num += 1;
            str = cursor.getString(1);
            if(str.equals("문화")){doing+=1;}
        }

        result = (doing/all_num)*100;
        result = Double.parseDouble(String.format("%.3f", result));

        return result;
    }

    // 여행
    public double result_travel(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        double all_num = 0;
        double doing = 0;
        double result = 0;

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST", null);

        while(cursor.moveToNext()) {
            all_num += 1;
            str = cursor.getString(1);
            if(str.equals("여행")){doing+=1;}
        }

        result = (doing/all_num)*100;
        result = Double.parseDouble(String.format("%.3f", result));

        return result;
    }

    // 기타
    public double result_etc(){
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        double all_num = 0;
        double doing = 0;
        double result = 0;

        Cursor cursor = db.rawQuery("select * from SCHEDULE_LIST", null);

        while(cursor.moveToNext()) {
            all_num += 1;
            str = cursor.getString(1);
            if(str.equals("기타")){doing+=1;}
        }

        result = (doing/all_num)*100;
        result = Double.parseDouble(String.format("%.3f", result));

        return result;
    }
}