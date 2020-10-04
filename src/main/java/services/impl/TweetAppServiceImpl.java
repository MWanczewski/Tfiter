package services.impl;

import dao.AppUserDao;
import dao.TweetDao;
import errors.ValidationError;
import models.AppUser;
import services.TweetAppService;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static utils.ServletUtils.*;

public class TweetAppServiceImpl implements TweetAppService {

    private AppUserDao appUserDao;
    private TweetDao tweetDao;

    public TweetAppServiceImpl(AppUserDao appUserDao, TweetDao tweetDao) {
        this.appUserDao = appUserDao;
        this.tweetDao = tweetDao;
    }

    @Override
    public void registerUser(AppUser user) {
        appUserDao.saveUser(user);
    }

    @Override
    public List<ValidationError> validateUser(AppUser user) {
        List<ValidationError> errors = new ArrayList<>();
        if(isUserEmailInUse(user.getEmail())) {
            errors.add(new ValidationError(EMAIL_ERROR_HEADER, EMAIL_ERROR_MESSAGE));
        }
        if(isUserLoginInUse(user.getLogin())) {
            errors.add(new ValidationError(LOGIN_ERROR_HEADER, LOGIN_IN_USE_ERROR_MESSAGE));
        }
        return errors;
    }

    private boolean isUserLoginInUse(String userLogin) {
       try {
           appUserDao.getUserByLogin(userLogin);
           return true;
       } catch(NoResultException e) {
           return false;
       }
    }


    private boolean isUserEmailInUse(String userEmail) {
        try {
            appUserDao.getUserByLogin(userEmail);
            return true;
        } catch(NoResultException e) {
            return false;
        }
    }
}
