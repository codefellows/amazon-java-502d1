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
    public static void main(String[] args) {
        char[] a1 = {'a', 'a', 'b'};
        char[] a2 = {'a', 'a', 'b'};

        String s1 = new String(a1);
        String s2 = new String(a2);
        System.out.println("s1 == s2? " + s1.equals(s2));

        Set<char[]> set = new HashSet<>();
        System.out.println("a1 in? " + set.contains(a1));
        set.add(a1);
        System.out.println("a1 in? " + set.contains(a1));

        System.out.println("a2 in? " + set.contains(a2));
        set.add(a2);
        System.out.println("a2 in? " + set.contains(a2));

    }

    public static void firebaseStuff() throws  IOException {
        String path = "/Users/moonmayor/.ssh/storage-2cad2-firebase-adminsdk-hp9ti-77e4b30ef1.json";
        FileInputStream serviceAccount = new FileInputStream(path);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://storage-2cad2.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("messages");
        myRef.setValue("hello", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                System.out.println("Ref: " + ref.toString());
            }
        });
    }
}
