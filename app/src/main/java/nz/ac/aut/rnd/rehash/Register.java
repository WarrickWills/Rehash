package nz.ac.aut.rnd.rehash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by Warrick on 11/05/2016.
 */
public class Register extends AppCompatActivity {
    private Firebase firebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        firebaseRef = ((Rehash)getApplication()).getFirebaseRef();

        Button registerButton = (Button) findViewById(R.id.sign_up_register_button);

        final EditText usernameET = (EditText) findViewById(R.id.sign_up_page_username);
        final EditText passwordET = (EditText) findViewById(R.id.sign_up_page_password);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                firebaseRef.createUser(username, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        Log.i("register","Successfully created user account with uid: " + result.get("uid"));
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Log.i("register","error");
                    }
                });
            }
        });
    }
}
