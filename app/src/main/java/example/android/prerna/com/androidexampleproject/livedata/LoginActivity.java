package example.android.prerna.com.androidexampleproject.livedata;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import example.android.prerna.com.androidexampleproject.R;
import example.android.prerna.com.androidexampleproject.databinding.EmailInputBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EmailInputBinding emailInputBinding = DataBindingUtil.setContentView(this, R.layout.login_input);

        LoginViewModel model = new LoginViewModel();
        emailInputBinding.setLoginViewModel(model);

        model.getUser().observe(this, (user) -> {
            if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                Toast.makeText(this, "email : " + user.getEmail() + " password " + user.getPassword(),
                    Toast.LENGTH_SHORT).show();
        });
    }
}
