package com.example.hasee.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.hasee.weather.db.Updata;

public class UpdataActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText xiaoshi;
    private EditText fenzhong;
    private EditText haomiao;
    private Button button1;
    private int xs;
    private int fz;
    private int hm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updata_activity);

        xiaoshi = (EditText) findViewById(R.id.edit_xiaoshi);
        fenzhong = (EditText) findViewById(R.id.edit_fenzhong);
        haomiao = (EditText) findViewById(R.id.edit_haomiao);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        xs = Integer.parseInt(xiaoshi.getText().toString());
        fz = Integer.parseInt(fenzhong.getText().toString());
        hm = Integer.parseInt(haomiao.getText().toString());
        switch (v.getId()) {
            case R.id.button1:
                Updata updata = new Updata();
                updata.setXiaoshi(xs);
                updata.setFenzhong(fz);
                updata.setHaomiao(hm);
                updata.save();
                Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
}
