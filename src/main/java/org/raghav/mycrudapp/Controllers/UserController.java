package org.raghav.mycrudapp.Controllers;

import org.raghav.mycrudapp.Exceptions.UserNotFoundException;
import org.raghav.mycrudapp.Models.User;
import org.raghav.mycrudapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired private UserService userService;

    @GetMapping("/users")
    public String ListAllUsers(Model model) {
        List<User> allUsers = userService.AllUsers();
        model.addAttribute("allUsers", allUsers);

        return "Users";
    }

    @GetMapping("/users/create")
    public String CreateUser(Model model) {
        model.addAttribute("user", new User());
        return "CreateUser";
    }
    
    @PostMapping("/users/save")
    public String SaveUser(User user, RedirectAttributes ra) {
        userService.save(user);
        ra.addFlashAttribute("message", "User Added Successfully") ;
        return "redirect:/users";
    }

    @GetMapping("users/update/{id}")
    public String GetEditUserForm(@PathVariable UUID id, Model model, RedirectAttributes ra) {
        try {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
        }
        catch (UserNotFoundException exception){
            ra.addFlashAttribute("message", exception.getMessage());
            return "redirect:/users";
        }
        return "UpdateUser";
    }

    @PostMapping("/users/update")
    public String UpdateUser(User user, RedirectAttributes ra) {
        userService.save(user);
        ra.addFlashAttribute("message", "User Updated Successfully") ;
        return "redirect:/users";
    }

    @GetMapping("users/delete/{id}")
    public String GetDeleteUser(@PathVariable UUID id, Model model, RedirectAttributes ra) {
        try {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
        }
        catch (UserNotFoundException exception){
            ra.addFlashAttribute("message", exception.getMessage());
            return "redirect:/users";
        }
        return "DeleteUser";
    }

    @PostMapping("/users/delete")
    public String DeleteUser(User user, RedirectAttributes ra) {
        userService.deleteUser(user.getId());
        ra.addFlashAttribute("message", "User Deleted Successfully") ;
        return "redirect:/users";
    }
}
