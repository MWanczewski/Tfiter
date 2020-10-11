package controllers;

import dao.impl.MySQLTweetDao;
import dao.impl.MySQLUserDao;
import models.AppUser;
import services.TweetAppService;
import services.impl.TweetAppServiceImpl;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UnFollowServlet", value = "/unfollow")
public class UnFollowServlet extends HttpServlet {
    private TweetAppService service;

    @Override
    public void init() throws ServletException {
        service = new TweetAppServiceImpl(new MySQLUserDao(), new MySQLTweetDao());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppUser currentUser = service.getUser(ServletUtils.getUserLoginFromSession(req));
        AppUser userToStopFollow = service.getUser(req.getParameter(ServletUtils.USER_LOGIN_TO_STOP_FOLLOW));
        service.unfollow(currentUser, userToStopFollow);
        req.getRequestDispatcher("users").forward(req, resp);
    }
}
