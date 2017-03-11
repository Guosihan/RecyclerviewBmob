package com.example.gsh.recyclerviewbmob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


public class RegisterActivity extends AppCompatActivity {

    private EditText userphone;
    private Button sendSms;
    private EditText Sms;
    private EditText username;
    private EditText userpassword;
    private EditText userage;
    private Button sure;
    private String password;
    private String phone;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userphone= (EditText) findViewById(R.id.user_phone);
        sendSms= (Button) findViewById(R.id.sendsms);
        Sms= (EditText) findViewById(R.id.ed_sms);
        username=(EditText)findViewById(R.id.user_name);
        userpassword= (EditText) findViewById(R.id.user_password);
        userage= (EditText) findViewById(R.id.user_age);
        sure= (Button) findViewById(R.id.btn_sure);




        password =userpassword.getText().toString().trim();
        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone=userphone.getText().toString().trim();
                BmobSMS.requestSMSCode(phone,"qaz", new QueryListener<Integer>() {

                    @Override
                    public void done(Integer smsId,BmobException ex) {
                        if(ex==null){//验证码发送成功
                            Toast.makeText(RegisterActivity.this,"发送完成",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(RegisterActivity.this,"发送失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String code = Sms.getText().toString().trim();
                phone=userphone.getText().toString().trim();
           //    String name=username.getText().toString().trim();
                String password=userpassword.getText().toString().trim();
                Log.i("fafa","dfafa");
                Log.i("name","--"+password);
                BmobSMS.verifySmsCode(phone, code, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                   if (e==null){
                       BmobUser bmobUser = new BmobUser();
                       /*String name=username.getText().toString().trim();
                       String password=userpassword.getText().toString().trim();*/
                       /*String name=username.getText().toString().trim();
                       String password=userpassword.getText().toString().trim();
                       Toast.makeText(RegisterActivity.this, name+"12345"+password, Toast.LENGTH_SHORT).show();*/

                       bmobUser.setUsername("YY");
                       bmobUser.setPassword("123");
                       bmobUser.signUp(new SaveListener<User>() {
                           @Override
                           public void done(User s, BmobException e) {
                               Log.i("过丝丝","你好朋友");
                               if(e==null){
                                   Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                               }else{
                                   Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       Toast.makeText(RegisterActivity.this, "YEs", Toast.LENGTH_SHORT).show();
                   }else{
                       Log.i("国思思思",e.getErrorCode()+"----"+e.getMessage());
                       Toast.makeText(RegisterActivity.this, "验证不通过"+e.getErrorCode()+"----"+e.getMessage(), Toast.LENGTH_SHORT).show();
                   }

                    }
                });
            }
        });
     /*   sure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                phone = userphone.getText().toString().trim();
                sms=ed_sms.getText().toString().trim();
                Log.i(sms, sms);
                Log.i(phone, phone);
                BmobSMS.verifySmsCode("13430040516", "179081", new UpdateListener() {

                    @Override
                    public void done(BmobException ex) {
                        if(ex==null){//短信验证码已验证成功
                            String name=username.getText().toString().trim();
                            String  age=userage.getText().toString().trim();
                            String password=userpassword.getText().toString().trim();
                            BmobUser bu = new BmobUser();
                            bu.setUsername(name);
                            bu.setPassword(password);
                            bu.setEmail("sendi@163.com");
//注意：不能用save方法进行注册
                            bu.signUp(new SaveListener<User>() {
                                @Override
                                public void done(User s, BmobException e) {
                                    if(e==null){
                                        Toast.makeText(RegisterActivity.this,"注册完成",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else{
                           Log.i("国思思思",ex.getMessage());
                           Toast.makeText(RegisterActivity.this,"no验证通过"+ ex.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });*/

    }
}
