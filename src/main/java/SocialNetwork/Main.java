package SocialNetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Integer guestUserid=0;
    static ArrayList<User> usersList;
    static int choice=-1;
    static Scanner input;
    public static void main(String[] args) {
        input=new Scanner(System.in);
        System.out.println("hello world");
        Session session=new Session(System.currentTimeMillis());
        usersList=new ArrayList<User>();
        /*Session staerted

         */
        GuestUser guestUser = new GuestUser(session);
        while(true) {
            System.out.println();
            System.out.println("1.Signup?\n" +
                    "2.Login?\n" +
                    "3.Search?\n" +
                    "4.Exit\n");
            choice=input.nextInt();
            if (choice==4)
                break;

            switch (choice){
                case 1:{
                    System.out.println("Enter userName");
                    input.nextLine();
                    String userName=input.nextLine();
                    System.out.println("Enter password");
                    String password=input.nextLine();
                    System.out.println("Enter name");
                    String name=input.nextLine();
                    System.out.println("Enter age");
                    int age=input.nextInt();
                    User newUser=guestUser.signup(userName,password,name,age);
                    usersList.add(newUser);

                }
                break;
                case 3: {
                    User otherUser = findUser(guestUser);
                    if (otherUser!=null){
                        System.out.println("User found");
                        System.out.println(otherUser);
                    }else{
                        System.out.println("User not found");
                    }
                }

                break;

                case 2: {
                    System.out.println("Enter username");
                    input.nextLine();
                    String userName = input.nextLine();
                    System.out.println("Enter password");
                    String password = input.nextLine();
                    User existingUser = guestUser.login(userName, password);
                    if (existingUser == null) {
                        System.out.println("user not found");
                        break;
                    }
                    existingUser.session = new Session(System.currentTimeMillis());
                    while (true) {
                        System.out.println();
                        System.out.println("1.Search\n" +
                                "2.View Received Requests\n" +
                                "3.View Sent Request\n" +
                                "4.View Following\n" +
                                "5.View Followers\n" +
                                "6.Log out\n");
                        int userChoice = input.nextInt();
                        if (userChoice == 6) {
                            guestUser = existingUser.logout();
                            System.out.println(guestUser);
                            break;
                        }

                        switch (userChoice) {
                            case 1: {
                                User otherUser = findUser(guestUser);
                                if (otherUser != null) {
                                    System.out.println("User found");
                                    System.out.println(otherUser);
                                } else {
                                    System.out.println("User not found");
                                }
                                System.out.println("Do you want to send follow request? (y/n)");
                                String ch = input.next();
                                if (ch.equals("y"))
                                    existingUser.followRequest(otherUser);

                            }

                            break;

                            case 2: {
                                existingUser.viewRecievedRequests();
                            }
                            break;

                            case 3: {
                                existingUser.viewSentRequests();
                            }
                            break;

                            case 4: {
                                existingUser.viewFollowings();
                            }
                            break;

                            case 5: {
                                existingUser.viewFollowers();
                            }
                            break;

                        }
                    }
                }
                break;
            }
        }

        /* To print all users

         */
        for (User user :
                usersList) {
            System.out.println(user);

        }

        /* Print session Id

         */
        System.out.println(guestUserid);

    }

    private static User findUser(GuestUser guestUser) {
        System.out.println("Enter userName to search");
        input.nextLine();
        String userName=input.nextLine();
        User isfound=guestUser.search(userName);
        return isfound;
    }
}
