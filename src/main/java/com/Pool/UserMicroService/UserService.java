package com.Pool.UserMicroService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "UserService",
        url = "${user_micro_service.url}"
)
public interface UserService {
    @GetMapping(path = "user/get_user{user_id}")
    User getUser (@RequestParam Integer id);


}
