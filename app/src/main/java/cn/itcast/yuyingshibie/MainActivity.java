package cn.itcast.yuyingshibie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvshow;
    private Button btngetpassword;
    private Button btnzhuce;
    private Button btndelectmod;
    private Button btnselectmod;
    private Button btnstoprecord;
    private Button btnyanzheng;
    private Button btndezhuce;
    private Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        tvshow=(TextView)findViewById(R.id.tv_show);
        btngetpassword=(Button)findViewById(R.id.btn_getpassword);
        btnzhuce=(Button)findViewById(R.id.btn_zhuce);
        btndelectmod=(Button)findViewById(R.id.btn_delectmod);
        btnselectmod=(Button)findViewById(R.id.btn_selectmod);
        btnstoprecord=(Button)findViewById(R.id.btn_stoprecord);
        btnyanzheng=(Button)findViewById(R.id.btn_yanzheng);
        btndezhuce=(Button)findViewById(R.id.btn_dezhuce);
        btnback=(Button)findViewById(R.id.btn_back);
        btngetpassword.setOnClickListener(this);
        btnzhuce.setOnClickListener(this);
        btndelectmod.setOnClickListener(this);
        btnselectmod.setOnClickListener(this);
        btnstoprecord.setOnClickListener(this);
        btnyanzheng.setOnClickListener(this);
        btndezhuce.setOnClickListener(this);
        btnback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_getpassword:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_zhuce:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delectmod:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_selectmod:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_stoprecord:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_yanzheng:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_dezhuce:
                Toast.makeText(this,"此功能未实现>.<",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_back:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
        }
    }
}
