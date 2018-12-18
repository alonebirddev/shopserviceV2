package com.acsk.shop.registration;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.acsk.shop.model.user.BmbUser;
import com.acsk.shop.service.UserService;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

@Controller
public class RegisterController {
    
	//@Autowired
    //PasswordEncoder pEncoder;
	
	/*@Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
        //org.springframework.security.crypto.password.PasswordEncoder
    }*/
	
	@Autowired
	UserService userService;

    // Return registration form template
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, BmbUser bmbUser) {
        modelAndView.addObject("bmbUser", bmbUser);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid BmbUser bmbUser, BindingResult bindingResult, HttpServletRequest request) {

        // Lookup user in database by e-mail
    	BmbUser userExists = userService.findByEmail(bmbUser.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else { // new user so we create user and send confirmation e-mail

            // Disable user until they click on confirmation link in email
        	bmbUser.setEnabled(false);

            // Generate random 36-character string token for confirmation link
        	bmbUser.setConfirmationToken(UUID.randomUUID().toString());

            userService.addUser(bmbUser);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            /*SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
            registrationEmail.setFrom("noreply@domain.com");

            emailService.sendEmail(registrationEmail);*/

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + bmbUser.getEmail() + "To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + bmbUser.getConfirmationToken());
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        BmbUser bmbUser = userService.findByConfirmationToken(token);

        if (bmbUser == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", bmbUser.getConfirmationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password").toString());

        if (strength.getScore() < 3) {
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        BmbUser bmbUser = userService.findByConfirmationToken(requestParams.get("token").toString());

        // Set new password
        bmbUser.setPassword(requestParams.get("password").toString());

        // Set user to enabled
        bmbUser.setEnabled(true);

        // Save user
        userService.addUser(bmbUser);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }

}
