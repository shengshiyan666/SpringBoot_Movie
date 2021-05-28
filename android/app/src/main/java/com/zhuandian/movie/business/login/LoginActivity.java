package com.zhuandian.movie.business.login;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.movie.MainActivity;
import com.zhuandian.movie.R;
import com.zhuandian.movie.base.BaseActivity;
import com.zhuandian.movie.business.activity.MenuActivity;
import com.zhuandian.movie.entity.UserEntity;
import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpManager;


import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_user_register)
    TextView tvUserRegister;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    private String userName;
    private String passWord;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setUpView() {
        setTitle("登录");
    }


    @OnClick({R.id.tv_user_register, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_user_register:
                startActivity(new Intent(LoginActivity.this, UserRegisterActivity.class));
                break;
            case R.id.tv_login:
                doLogin();
                break;
        }
    }

    private void doLogin() {
        userName = etUsername.getText().toString();
        passWord = etPassword.getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(this, "请完善登陆信息...", Toast.LENGTH_SHORT).show();
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setPassWord(passWord);
            userEntity.setUserName(userName);
            Observable observable = getApi().login(userEntity);
            HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<UserEntity>() {
                @Override
                public void onSuccess(UserEntity result) {
                    UserEntity result1 = result;
                    getSharedPreferences("movie", Context.MODE_PRIVATE).edit().putInt("age", result.getAge()).commit();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onError(Exception e) {
                    System.out.println(e);
                }
            });
        }
    }
}
