package com.nexters.duckjiduckji.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Log4j2
public class RoomController {

    // 방 입장
    @GetMapping("/room/{roomId}/{userId}")
    public String room(@PathVariable String roomId, @PathVariable String userId, Model model) {

        model.addAttribute("roomId", roomId);
        model.addAttribute("userId", userId);

        return "room";
    }
}
