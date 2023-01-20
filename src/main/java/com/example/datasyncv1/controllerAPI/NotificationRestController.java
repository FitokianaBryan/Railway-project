package com.example.datasyncv1.controllerAPI;


import com.example.datasyncv1.dao.TokenUserDao;
import com.example.datasyncv1.interfaces.NotificationRepository;
import com.example.datasyncv1.models.Notification;
import com.example.datasyncv1.models.TokenUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin
public class NotificationRestController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/insert")
    public ResponseEntity<Notification> insert_notification(@RequestBody Notification notification) throws Exception {
             Notification n = notificationRepository.save(notification);
            return new ResponseEntity(n,HttpStatus.OK);
    }

    @GetMapping("/getNotification")
    public ResponseEntity<ArrayList<Notification>> getNotificationUser(@RequestParam("idEnchere") int idEnchere) throws Exception {
        ArrayList<Notification> list = new ArrayList<>();
        try{
                list = (ArrayList<Notification>) notificationRepository.findByidEnchere(idEnchere);
                return new ResponseEntity<>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
        }
    }

}
