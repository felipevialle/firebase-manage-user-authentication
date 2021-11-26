package firebase.admin;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String document_id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String phoneNumber;

    private String photoUrl;

    private Boolean status;

}
