package com.manekineko.realm_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Button confirm;
    private Button show;
    private TextView textview;
    private Realm realm;
    private EditText et_id;
    private EditText et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();

        confirm = findViewById(R.id.confirm);
        show = findViewById(R.id.show);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id = findViewById(R.id.input_id);
                et_pwd = findViewById(R.id.input_pwd);


                String id = et_id.getText().toString();
                String pwd = et_pwd.getText().toString();
                realm.beginTransaction();
                Data data = realm.createObject(Data.class);
                data.setId(id);
                data.setPwd(pwd);
                realm.commitTransaction();
            }
        });

        RealmResults<Data> datas = realm.where(Data.class).findAll();
        //Log.e("DATA", datas.size()+"");

//        if (!datas.isEmpty()) {
//            textview.setText("id: "+datas.first().getId()+"|| pwd: "+datas.first().getPwd());
//
//        }
        //데잍를 전부 불러와서 그걸 다른 activity에 보내야

        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
