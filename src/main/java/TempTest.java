import dao.TweetDao;
import dao.impl.MySQLTweetDao;
import models.AppUser;
import dao.AppUserDao;
import dao.impl.MySQLUserDao;
import models.Tweet;
import services.TweetAppService;
import services.impl.TweetAppServiceImpl;

import java.util.List;

public class TempTest {
    public static void main(String[] args) {
        TweetAppService service = new TweetAppServiceImpl(new MySQLUserDao(), new MySQLTweetDao());
        AppUser h = service.getUser("h");
        service.getNotFollowedUsers(h);

    }
}
