package zucc.com.lk1131_lxx1132;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText login_id;
    private EditText login_pwd;
    private Button login_bt;
    private TextView login_forget;
    private TextView login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init();
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Init(){
        toolbar =(Toolbar) findViewById(R.id.tl_custom);
        login_id=(EditText)findViewById(R.id.login_id);
        login_pwd=(EditText)findViewById(R.id.login_pwd);
        login_bt=(Button)findViewById(R.id.login_bt);
        login_forget=(TextView)findViewById(R.id.login_forget);
        login_register=(TextView)findViewById(R.id.login_register);
        toolbar.setTitle("随手快递");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);

        AVOSCloud.initialize(this,"2vjHb5JuEsQrgw12qLXuG0Ex-gzGzoHsz","jcKJFzIEnxuDlxAu0uJ9d3hd");
        AVOSCloud.setDebugLogEnabled(true);

        // 测试 SDK 是否正常工作的代码
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    Log.d("saved","success!");
                }
            }
        });

    }

}
