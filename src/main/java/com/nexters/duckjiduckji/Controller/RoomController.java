package com.nexters.duckjiduckji.Controller;

import com.nexters.duckjiduckji.Dto.ChatRoomDto;
import com.nexters.duckjiduckji.Repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {
    private final ChatRoomRepository repository;
    private final AtomicInteger seq = new AtomicInteger(0);

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", repository.findAllRooms());
        return "/chat/room-list";
    }

    @GetMapping("/room/{id}/{name}")
    public String room(@PathVariable String id, @PathVariable String name, Model model) {
        System.out.println("방 입장!");
        ChatRoomDto room = repository.findRoomById(id);
        model.addAttribute("roomId", id);
        model.addAttribute("name", name); // 회원 이름 부여

        return "room";
    }

    @PostMapping("/room")
    public void createRoom(String name) {
        ChatRoomDto chatRoom = repository.createChatRoomDTO(name);
        log.info(chatRoom.getRoomId());
        log.info(chatRoom.getRoomName());
    }
}
