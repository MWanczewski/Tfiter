import dao.TweetDao;
import dao.impl.MySQLTweetDao;
import models.AppUser;
import dao.AppUserDao;
import dao.impl.MySQLUserDao;
import models.Tweet;

import java.util.List;

public class TempTest {
    public static void main(String[] args) {
        AppUserDao dao = new MySQLUserDao();
        TweetDao tweetDao = new MySQLTweetDao();
        AppUser user1 = AppUser.UserBuilder.getBuilder()
                .name("Mark")
                .lastName("1")
                .email("1@1")
                .password("aaa")
                .login("lol")
                .build();

        AppUser user2 = AppUser.UserBuilder.getBuilder()
                .name("Dark")
                .lastName("2")
                .email("2@2")
                .password("aaa2")
                .login("lol2")
                .build();

        AppUser user3 = AppUser.UserBuilder.getBuilder()
                .name("asdasd")
                .lastName("3")
                .email("3@3")
                .password("aaa3")
                .login("lol3")
                .build();

        dao.saveUser(user1);
        Tweet tweet = new Tweet(user1.getLogin(), "asfkwnfjibao3brjo2 j wewehf i wefweuigf2 ");
        tweetDao.save(tweet);

        System.out.println("-----------------------------");
        List<Tweet> userTweets = tweetDao.getUserTweets(user1);
        userTweets.forEach(System.out::println);
        System.out.println("-----------------------------");
        dao.deleteUser(user1);

    }
}
