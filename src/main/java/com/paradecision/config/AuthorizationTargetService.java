package com.paradecision.config;

import com.paradecision.organizations.users.User;

public interface AuthorizationTargetService {

	Long getTargetIdByUser(User user);

}
