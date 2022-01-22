# Nexters_duckjiduckji_socket_server

## **폴라로이드 데이터 규격 및 연동정보**

- 연동 url 정보(sockJs 파라미터로 넣을 값) → 추후 전달 예정
    - http://ip:port/room
- publish(Client →Socket Server)
    - 종류
        - **채팅방 참여**
            - url : /publish/room/join/{roomId}
            - roomId는 UUID 형태로 제공 예정(ex. `550e8400-e29b-41d4-a716-446655440000`)
                - msgType : 전송 메시지 type
                - guestId(참여자 ID)
                - sendTime: 메시지 전송 시간(yyyymmddhhmmss)
                
                ```
                {
                	    msgType : ”joinRoom”,
                		guestId: “aaa1234”,
                		sendTime : yyyymmmdddhhhmmss        
                };
                ```
                
        - **채팅방 퇴장**
            - url : /publish/room/leave/{roomId}
                - msgType : 전송 메시지 type
                - guestId(참여자 ID)
                - sendTime  : 메시지 전송 시간(yyyymmddhhmmss)
                
                ```
                {
                	 	msgType : "leaveRoom”,
                	    guestId: “aaa1234”,
                	    sendTime  : yyyymmmdddhhhmmss        
                };
                ```
                
        - **데이터 전송 case 1(이미지, 제목, 메시지..등 → 폴라로이드 작성하고 확인버튼 클릭)**
            - url : /publish/room/content/{roomId}
                - msgType : 전송 메시지 type
                - polaroidId(폴라로이드 ID)
                - imgUrl → 별도 파일 업로드 API 제공 필요
                - title : 제목
                - content : 글 내용
                - sendTime : 메시지 전송 시간(yyyymmddhhmmss)
                
                ```
                {
                		msgType : ”sendContentMsg”,
                	    polaroidId: “basd23as-22323..",
                	    imgUrl : “http://.....”,
                		title : “덕지덕지 회고방”,
                		content: “회고를 시작합니다!.....”,
                		sendTime : yyyymmmdddhhhmmss        
                };
                ```
                
            - **데이터 전송 case 1 상세 절차**
                1. 파일 서버로 파일 전송 후 url 받음
                2. 이미지 url, 글 제목, 글 내용을 socket server로 전송
        
         
        
        - **데이터 전송 case 2(폴라로이드 이동 및 rotation 조정 → 마우스 이벤트)**
            - url : /publish/room/position/{roomId}
                - msgType : 전송 메시지 type
                - polaroidId(폴라로이드 ID)
                - posX(이동된 위치의 x 좌표)
                - posY(이동된 위치의 y 좌표)
                - rotation : 이동된 회전값
                - sendTime : 메시지 전송 시간(yyyymmddhhmmss)
                
                ```
                {
                		msgType: ”sendPositionMsg”,
                	    polaroidId: “basd23as-22323..",
                	    posX: 100,
                 	    posY: 100,
                		rotation: ??,
                		sendTime : yyyymmmdddhhhmmss        
                };
                ```
                

- subscribe(Socket Server → Client)
    - url : /subscribe/room/{roomID}
    - msgType으로 요청 type을 구분
    - roomId는 UUID 형태로 제공 예정(ex. `550e8400-e29b-41d4-a716-446655440000`)
    - 종류
        - **채팅방 참여 메시지 수신(다른 참여자 채팅방에 참가)**
            - msgType: 전송 메시지 type
            - joinerId :  참여한 유저 ID
            - sendTime : 메시지 수신 시간(yyyymmddhhmmss)
            
            ```
            {
            		msgType: ”joinRoom”,
            	    joinerId: “aaa9418”,
            		sendTime : yyyymmmdddhhhmmss        
            };
            ```
            
        - **채팅방 퇴장 메시지 수신(다른 참여자 채팅방에서 퇴장)**
            - msgType: 전송 메시지 type
            - leaverId:  퇴장한 유저 ID
            - sendTime : 메시지 수신 시간(yyyymmddhhmmss)
            
            ```
            {
            	    msg_type : ”outMsg”,
            		leaver_id: “aaa9418”,
            		sendTime : yyyymmmdddhhhmmss        
            };
            ```
            
        - **데이터 수신 case 1(이미지, 제목, 메시지..등)**
            - msgType: 전송 메시지 type
            - polaroidId(폴라로이드 ID)
            - imgUrl(이미지 url)
            - title : 제목
            - content : 글 내용
            - sendTime : 메시지 전송 시간(yyyymmddhhmmss)
            
            ```
            {
            		msgType : ”receiveContentMsg”,
            		polaroidId: “basd23as-22323..",
            		imgUrl: “http://.....”,
            		title: “덕지덕지 회고방”,
            		content: “회고를 시작합니다!.....”,
            		sendTime : yyyymmmdddhhhmmss        
            };
            ```
            
        - **데이터 수신 case 2(폴라로이드 이동 및 rotation 조정)**
            - msgType : 전송 메시지 type
            - polaroidId(폴라로이드 ID)
            - posX(이동된 위치의 x 좌표)
            - posY(이동된 위치의 y 좌표)
            - rotation : 이동된 회전값
            - sendTime : 메시지 전송 시간(yyyymmddhhmmss)
            
            ```
            {
            		msgType : ”receivePositionMsg”,
            		polaroidId: “basd23as-22323..",
            		posX: 100,
             		poyY: 100,
            		rotation: ??,
            		sendTime : yyyymmmdddhhhmmss        
            };
            ```
