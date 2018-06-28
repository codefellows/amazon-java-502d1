import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirebaseMain {
    public static void main(String[] args) throws IOException {
        firebaseStuff();
    }

    public static void firebaseStuff() throws  IOException {
        String path = "/Users/moonmayor/.ssh/storage-2cad2-firebase-adminsdk-hp9ti-77e4b30ef1.json";
        FileInputStream serviceAccount = new FileInputStream(path);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://storage-2cad2.firebaseio.com/")
                .build();

        System.out.println("Initializing app");
        FirebaseApp.initializeApp(options);

        System.out.println("Database reference");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data");
        System.out.println("Setting value");
        myRef.setValue("hello", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                System.out.println("Ref: " + ref.toString());
            }
        });
    }
}
