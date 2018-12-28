package SocialNetwork;

public class FollowRequest {
    User startingUser;
    User endingUser;
    int start=0;
    int end=0;


    public User getStartingUser() {
        return startingUser;
    }

    public void setStartingUser(User startingUser) {
        this.startingUser = startingUser;
    }

    public User getEndingUser() {
        return endingUser;
    }

    public void setEndingUser(User endingUser) {
        this.endingUser = endingUser;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("From: %s To: %s",startingUser.userName,endingUser.userName);
    }
}
