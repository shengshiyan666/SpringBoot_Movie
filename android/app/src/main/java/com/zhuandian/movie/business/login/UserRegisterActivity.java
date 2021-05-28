package com.zhuandian.movie.business.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.zhuandian.movie.R;
import com.zhuandian.movie.base.BaseActivity;
import com.zhuandian.movie.entity.UserEntity;
import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpManager;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

public class UserRegisterActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.et_age)
    EditText etAge;
    private String userName;
    private String passWord;
    private String userAge;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_register;
    }

    @Override
    protected void setUpView() {
        setTitle("注册");
    }


    @OnClick(R.id.tv_register)
    public void onClick() {
        doRegister();
    }

    private void doRegister() {
        userName = etUsername.getText().toString();
        passWord = etPassword.getText().toString();
        userAge = etAge.getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord) || TextUtils.isEmpty(userAge) ) {
            Toast.makeText(this, "请完善注册信息...", Toast.LENGTH_SHORT).show();
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setPassWord(passWord);
            userEntity.setUserName(userName);
            userEntity.setAge(Integer.parseInt(userAge));
            Observable observable = getApi().addNewUser(userEntity);
            HttpManager.getInstance().doHttpRequest(this, observable, new CallBack<String>() {
                @Override
                public void onSuccess(String result) {
                    String result1 = result;
                    showRegisterDialog();
                }

                @Override
                public void onError(Exception e) {
                    System.out.println(e);
                }
            });
        }
    }

    private void showRegisterDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("注册成功")
                .setMessage("注册成功，是否马上去登陆？")
                .setNegativeButton("稍后登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("马上登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .show();
    }

}
