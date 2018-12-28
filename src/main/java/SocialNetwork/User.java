package SocialNetwork;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class User extends  GuestUser{
    protected String userName;
    protected String password;
    protected String name;
    protected int age;
    protected Session session;
    protected User following;
    protected User followers;
    private LinkedList<FollowRequest> followRequestsList;
    User(){
        followRequestsList=new LinkedList<FollowRequest>();
    }
    @Override
    public String toString() {
        return String.format("User name: %s \t  Name:%s \t Age:%d",userName,name,age);
    }

    public GuestUser logout() {
        session.closeSession(System.currentTimeMillis());
        System.out.println(sessionTime());
        return super.getMe();
    }

    String sessionTime() {
        long milliseconds=(session.endingTime-session.startingTime);
        long minutes = (milliseconds / 1000) / 60;
        long seconds = (milliseconds / 1000) % 60;
        return String.format("session time: %d:%d",minutes,seconds);
    }

    public void followRequest(User otherUser) {
//        FollowRequest sentrequest=new FollowRequest();
//        sentrequest.start=1;
//        sentrequest.startingUser=this;
//        sentrequest.endingUser=otherUser;
//        this.followRequestsList.add(sentrequest);
//        FollowRequest receivedRequest=new FollowRequest();
//        receivedRequest.end=1;
//        receivedRequest.endingUser=this;
//        receivedRequest.startingUser=otherUser;
//        otherUser.followRequestsList.add(receivedRequest);
        FollowRequest request=new FollowRequest();
        request.end=1;
        request.startingUser=this;
        request.endingUser=otherUser;
        this.followRequestsList.add(request);
        otherUser.followRequestsList.add(request);
    }

    public void viewSentRequests(){
        System.out.println("Sent Follow requests");

        for (FollowRequest request :
                followRequestsList) {
//            System.out.printf("%d. %s: %s \n",++i,(request.end==1)?"From":"To",request.endingUser.userName);
            boolean isTo=(request.startingUser.equals(this)&&request.end==1);
//            System.out.printf("%d. %s: %s\n",++i,(isTo)?"To":"From",(isTo)?request.endingUser.userName:request.startingUser.userName);
            if (isTo){
                System.out.printf("%d. To: %s\n",followRequestsList.indexOf(request),request.endingUser.userName);
            }
        }
//        System.out.println("Do you want to delete any sent request? Then enter the desired index(num/n)");
//        Scanner input=new Scanner(System.in);
//        int index=input.nextInt();
//        System.out.println(followRequestsList.remove(index));
//
    }

    public void viewRecievedRequests() {
        System.out.println("Received Follow requests");

        for (FollowRequest request :
                followRequestsList) {
//            System.out.printf("%d. %s: %s \n",++i,(request.end==1)?"From":"To",request.endingUser.userName);
            boolean isFrom=(request.endingUser.equals(this)&&request.end==1);
//            System.out.printf("%d. %s: %s\n",++i,(isTo)?"To":"From",(isTo)?request.endingUser.userName:request.startingUser.userName);
            if (isFrom){
                System.out.printf("%d. From: %s\n",followRequestsList.indexOf(request),request.startingUser.userName);
            }
        }
        System.out.println("Do you want to accept any request?(y/n)");
        Scanner input=new Scanner(System.in);
        if (input.nextLine().equals("y")){
            System.out.println("Enter index number to accept");
            int index=input.nextInt();
            FollowRequest request=followRequestsList.get(index);
            request.end=2;

        }

    }

    public void viewFollowings(){
        System.out.println("Your are following:");
        int i=0;
        for (FollowRequest request :
                followRequestsList) {
            boolean isTo=(request.startingUser.equals(this)&&request.end==2);
            if (isTo){
                System.out.println(i++ +" Username: "+request.endingUser.userName);
            }
        }
    }

    public void viewFollowers(){
        System.out.println("Your followers:");
        int i=0;
        for (FollowRequest request :
                followRequestsList) {
            boolean isFrom=(request.endingUser.equals(this)&&request.end==2);
            if (isFrom){
                System.out.println(i++ +" Username: "+request.startingUser.userName);
            }
        }
    }
}
