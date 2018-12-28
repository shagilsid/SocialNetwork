package SocialNetwork;

/* Session: Starting of an app to ending of an App

 */
public class Session {
    long  startingTime;
    long endingTime;

    Session(long startingTime){
        this.startingTime=startingTime;
    }

    void closeSession(long endingTime){
        this.endingTime=endingTime;
    }
}
