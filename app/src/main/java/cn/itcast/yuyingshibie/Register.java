package cn.itcast.yuyingshibie;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button btnOK;
    private Button btnCancel;
    private EditText etAdpassword;
    private EditText etNewusername;
    private Intent intent;
    private SQLiteDatabase db;
    private MyDBOpenHelper myDBHelper;

    private String Adpassword = "abc123";

    public Register() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        myDBHelper = new MyDBOpenHelper(this);
        init();
    }

    private void init() {
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        etAdpassword = (EditText) findViewById(R.id.et_Adpassword);
        etNewusername = (EditText) findViewById(R.id.et_Newusename);
        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this, LoginActivity.class);
        db = myDBHelper.getWritableDatabase();
        switch (v.getId()) {
            case R.id.btn_ok:
                String NewUsername = etNewusername.getText().toString().trim();
                if (TextUtils.isEmpty(NewUsername)) {
                    Toast.makeText(this, "请输入用户名！", Toast.LENGTH_SHORT).show();
                } else {
                    if (etAdpassword.getText().toString().equals(Adpassword)) {
                        if (NewUsername.length() >= 20) {
                            Toast.makeText(this, "请输入长度小于20的用户名", Toast.LENGTH_SHORT).show();
                        } else {
                            if (myDBHelper.DBSearch(NewUsername, db, myDBHelper)) {
                                Toast.makeText(this, "用户名已存在！", Toast.LENGTH_SHORT).show();
                            } else {
                                ContentValues values = new ContentValues();
                                values.put("name", NewUsername);
                                db.insert("Users", null, values);
                                db.close();
                                Toast.makeText(this, "密码正确，欢迎使用", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }
                        }
                    } else {
                        Toast.makeText(this, "请输入正确的管理员密码！", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_cancel:
                startActivity(intent);
                finish();
                break;
        }
    }


}
