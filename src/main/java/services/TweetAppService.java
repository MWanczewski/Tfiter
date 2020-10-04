package services;

import errors.ValidationError;
import models.AppUser;

import java.util.List;

public interface TweetAppService {
    List<ValidationError> validateUser(AppUser user);

    void registerUser(AppUser user);
}
