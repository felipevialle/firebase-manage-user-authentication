package firebase.admin;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserRecord createUser(@RequestBody User user) throws InterruptedException, ExecutionException, FirebaseAuthException {
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public UserRecord findUser(@RequestParam String uid) throws InterruptedException, ExecutionException, FirebaseAuthException {
        return userService.findUser(uid);
    }

}
