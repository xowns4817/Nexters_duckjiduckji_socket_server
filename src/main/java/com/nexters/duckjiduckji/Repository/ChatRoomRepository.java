package com.nexters.duckjiduckji.Repository;

import com.nexters.duckjiduckji.Dto.ChatRoomDto;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoomDto> chatRoomDtoMap;

    @PostConstruct
    private void init(){
        chatRoomDtoMap = new LinkedHashMap<>();
    }

    public List<ChatRoomDto> findAllRooms(){
        //채팅방 생성 순서 최근 순으로 반환
        List<ChatRoomDto> result = new ArrayList<>(chatRoomDtoMap.values());
        for(int i=0; i<result.size(); i++) System.out.println(result.get(i).toString());
        Collections.reverse(result);

        return result;
    }

    public ChatRoomDto findRoomById(String id){
        return chatRoomDtoMap.get(id);
    }

    public ChatRoomDto createChatRoomDTO(String name){
        ChatRoomDto room = ChatRoomDto.create(name);
        chatRoomDtoMap.put(room.getRoomId(), room);
        return room;
    }
}
