package firebase.admin;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public UserRecord createUser(User user) throws ExecutionException, InterruptedException, FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setEmailVerified(false)
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber())
                .setDisplayName(user.getName())
                .setPhotoUrl(user.getPhotoUrl())
                .setDisabled(user.getStatus());

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        System.out.println("Successfully created new user: " + userRecord.getUid());

        return userRecord;
    }

    public UserRecord findUser(String documentId) throws ExecutionException, InterruptedException, FirebaseAuthException {
        UserRecord userRecord = FirebaseAuth.getInstance().getUser(documentId);
        System.out.println("Successfully fetched user data: " + userRecord.getUid());

        return userRecord;
    }
}
