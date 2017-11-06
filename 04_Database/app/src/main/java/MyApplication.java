import android.app.Application;

import io.realm.Realm;

/**
 * Created by miguelcampos on 6/11/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
}
