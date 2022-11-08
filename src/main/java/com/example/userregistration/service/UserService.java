package com.example.userregistration.service;

import com.example.userregistration.entity.AppUser;
import com.example.userregistration.entity.VerificationToken;
import com.example.userregistration.model.UserModel;

import java.util.Optional;

public interface UserService {
    AppUser registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, AppUser user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    AppUser findUserByEmail(String email);

    void createPasswordResetTokenForUser(AppUser user, String token);

    String validatePasswordResetToken(String token);

    Optional<AppUser> getUserByPasswordResetToken(String token);

    void changePassword(AppUser user, String newPassword);

    boolean checkIfValidOldPassword(AppUser user, String oldPassword);
}
