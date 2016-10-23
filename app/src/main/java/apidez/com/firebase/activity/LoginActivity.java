package apidez.com.firebase.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import apidez.com.firebase.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    @BindView(R.id.edtEmail)
    EditText edtEmail;

    @BindView(R.id.edtPassword)
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setUpFirebase();
        setUpViews();
    }

    private void setUpViews() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Processing...");
    }

    private void setUpFirebase() {
        // TODO: implement this
    }

    @OnClick(R.id.btnRegister)
    public void onRegisterClick() {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.btnLogin)
    public void onLoginClick() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            showError("Please enter email and password");
            return;
        }
        mProgressDialog.show();
        // TODO: implement login
    }

    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void handleLoginSuccess() {
        startActivity(TodoActivity.getIntent(this));
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }
}
