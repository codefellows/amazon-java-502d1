import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFirebaseApp {
    public static void main(String[] args) {
        try {
            String authFile = "/Users/moonmayor/Fellows/amazon-java-501d1/16-realtime-databases/Firebase/src/main/resources/storage-2cad2-firebase-adminsdk-hp9ti-761eb60122.json";
            FileInputStream serviceAccount = new FileInputStream(authFile);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://storage-2cad2.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    System.out.println("data change");
                    System.out.println(snapshot);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                }
            });

            //myRef.setValue("Hello, World!");
        } catch (FileNotFoundException e1) {
            System.out.println("Can't find auth json file.");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println("Can't connect to Firebase.");
            e2.printStackTrace();
            System.out.println(e2.getMessage());
        }
    }
}
