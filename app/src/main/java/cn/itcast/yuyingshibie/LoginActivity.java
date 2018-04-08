package cn.itcast.yuyingshibie;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername;
    private Button btnLogin;
    private Button btnRegister;
    private Intent intent;
    private MyDBOpenHelper DBOpenHelper;
    private SQLiteDatabase db;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //改变EditText插入图片的大小
        EditText user = (EditText) findViewById(R.id.et_user_name);
        Drawable user_drawable = getResources().getDrawable(R.drawable.user);
        user_drawable.setBounds(0, 0, 50, 50);
        user.setCompoundDrawables(user_drawable, null, null, null);
        DBOpenHelper=new MyDBOpenHelper(this);
        init();
    }

    private void init() {
        etUsername = (EditText) findViewById(R.id.et_user_name);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username=etUsername.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(this, "请输入用户名！", Toast.LENGTH_SHORT).show();
                } else {
                    if (DBOpenHelper.DBSearch(username,db,DBOpenHelper)){
                        Toast.makeText(this,"欢迎回来",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(this,"输入的用户名不存在",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_register:
                startActivity(new Intent(this, Register.class));
                finish();
                break;
        }
    }
}
