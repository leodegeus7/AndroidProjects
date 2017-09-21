package whatsapp.cursoandroid.com.instagram.activity.helper;

import com.parse.Parse;
import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("La2UPzenxgcf1V8Td82bT7FyCiLXt51TWdjXXY6E")
                .clientKey("APCiJIYarN7uQAuU1KvUkzI5pBNbCIYvHZDeW6ni")
                .server("https://parseapi.back4app.com/").build()
        );
    }
}