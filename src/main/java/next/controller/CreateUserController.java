package next.controller;

import core.db.DataBase;
import core.mvc.asis.Controller;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = User.builder()
                .userId(req.getParameter("userId"))
                .password(req.getParameter("password"))
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .build();

        log.debug("User : {}", user);

        DataBase.addUser(user);
        return "redirect:/";
    }
}
