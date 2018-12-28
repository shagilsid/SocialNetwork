package SocialNetwork;

public class GuestUser {
    private Session session;
    GuestUser(){}
    GuestUser(Session session){
        this.session=session;
        Main.guestUserid++;
    }

    User login(String userName, String password){
        boolean exists=false;
        for (User user :
                Main.usersList) {
            if (user.userName.equals(userName) && user.password.equals(password)) {
                exists = true;
                return user;
            }
        }

        return null;
    }

    User search(String userName){
        for (User user :
                Main.usersList) {
            if (user.userName.equals(userName)){
                return user;
            }

        }
        return null;

    }

    User signup(String userName,String password,String name,int age){
        User newUser=new User();
        newUser.userName=userName;
        newUser.password=password;
        newUser.name=name;
        newUser.age=age;
        return newUser;

    }

    protected GuestUser getMe() {
        return this;
    }


}
