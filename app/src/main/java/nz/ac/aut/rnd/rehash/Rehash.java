package nz.ac.aut.rnd.rehash;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Warrick on 11/05/16.
 */
public class Rehash extends Application {
    private Firebase firebaseRef;
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase("https://rehashaut.firebaseio.com/");
    }

    public Firebase getFirebaseRef() {
        return firebaseRef;
    }

    public void setFirebaseRef(Firebase firebaseRef) {
        this.firebaseRef = firebaseRef;
    }
}

