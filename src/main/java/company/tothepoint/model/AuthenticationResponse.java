package company.tothepoint.model;

import org.apache.log4j.Logger;

/**
 * Created by butrint on 4/05/16.
 */
public class AuthenticationResponse extends ModelBase {
    private final Logger logger = Logger.getLogger(AuthenticationResponse.class);
    private static final long serialVersionUID = -6624726180748515507L;
    private String Authorization;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String Authorization) {

        this.setToken(Authorization);
    }

    public String getToken() {
        return this.Authorization;
    }

    public void setToken(String Authorization) {
        logger.error("Inside authenticationResponse");
        logger.error(Authorization);
        this.Authorization = Authorization;
    }

}
