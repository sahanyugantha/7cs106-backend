package com.sahan.dietplan.controller;

import com.sahan.dietplan.model.NutritionalInfo;
import com.sahan.dietplan.model.RecommendationResponse;
import com.sahan.dietplan.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sahan.dietplan.model.User;
import com.sahan.dietplan.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, RecommendationService recommendationService) {
        this.userService = userService;
        this.recommendationService = recommendationService;
    }

    private final RecommendationService recommendationService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        try {
            //System.out.println("Email --> "+user.getEmail());
            //System.out.println("PW --> "+user.getPassword());
            User loggedInUser = userService.login(user.getEmail(), user.getPassword());

            return ResponseEntity.ok(loggedInUser);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        //System.out.println("REACH");
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        if (userService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


//    @GetMapping("/{id}/recommendations")
//    public ResponseEntity<Object> getDailyRecommendations(@PathVariable Integer id) {
//        try {
//            List<NutritionalInfo> recommendations = recommendationService.generateDailyRecommendation(id);
//
//            if (recommendations.isEmpty()) {
//                Map<String, String> noRec = new HashMap<>();
//                noRec.put("NO", "No Recommendations yet");
//                return ResponseEntity.status(HttpStatus.OK).body(noRec);
//            } else {
//                return ResponseEntity.ok(recommendations);
//            }
//        } catch (Exception e){
//            Map<String, String> noRec = new HashMap<>();
//            noRec.put("ERROR", e.getMessage());
//            return ResponseEntity.status(HttpStatus.OK).body(noRec);
//        }
//
//    }

//    @GetMapping("/{id}/recommendations")
//    public ResponseEntity<List<NutritionalInfo>> getDailyRecommendations(@PathVariable Integer id) {
//        List<NutritionalInfo> recommendations = recommendationService.generateDailyRecommendation(id);
//        return ResponseEntity.ok(recommendations);
//    }

    @GetMapping("/{id}/recommendations")
    public ResponseEntity<RecommendationResponse> getDailyRecommendation(@PathVariable int id) {
        RecommendationResponse response = recommendationService.generateDailyRecommendation(id);
        return ResponseEntity.ok(response);
    }

}

