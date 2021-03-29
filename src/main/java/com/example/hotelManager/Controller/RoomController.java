package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.RoomService;
import com.example.hotelManager.pojo.Room;
import com.example.hotelManager.util.ImageHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/getAllRoom")
    public Result<List<Room>> getAllRoom()
    {
    return new Result<>(roomService.findAllRoom());
    }
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/findByRoomID")
    public Result<Room> findByRoomID(@RequestBody Room room) {
        return new Result<>(roomService.findByRoomID(room.getRoomID()));
    }
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/UploadImage")
    public Result<String> UploadImage(MultipartFile file) {
        String URL1 = "E://uploadImage";
        String UploadFile = URL1 + file.getOriginalFilename();
        System.out.println(UploadFile);
        File imageFolder = new File(URL1);
        File f = new File(imageFolder, file.getOriginalFilename());
        if (!f.getParentFile().exists())
            f.getParentFile().mkdir();
        try {
            file.transferTo(f);
        } catch (IOException EX) {
            EX.printStackTrace();
        }
        //切割图片
        System.out.println(f.getAbsolutePath());
        String target_File = f.getAbsolutePath();
        String final_File = ImageHandle.targetDir + file.getOriginalFilename();
        int width = ImageHandle.width;
        int height = ImageHandle.height;
        new ImageHandle().ImageCutting(target_File,final_File,width,height);
        final_File = "."+final_File.substring(final_File.indexOf("/static"));
        System.out.println(final_File);
        return new Result<>(true,400,"操作成功",final_File);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/DeleteRoom")
    public Result DeleteRoom(@RequestBody Room room)
    {
        String roomID  = room.getRoomID();
        Room Select_Room = roomService.findByRoomID(roomID);
        if(Select_Room.getRoomState().equals("已入住"))
        {
            return new Result(200);
        }
        else
        {roomService.DeleteRoom(Select_Room);
        return new Result(400);
        }

    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/UpdateOrSaveRoom")
    public Result UpdateOrSaveRoom(@RequestBody Map<String,Object> requestParam)

    {   System.out.println(requestParam.get("roomDescribe"));
        System.out.println(requestParam.get("roomType"));
        System.out.println(requestParam.get("roomID"));
        System.out.println(requestParam.get("roomPrice"));
        System.out.println(requestParam.get("roomPicture"));
        String roomDescribe =(String) requestParam.get("roomDescribe");
        String roomType = (String) requestParam.get("roomType");
        String roomID =(String) requestParam.get("roomID");
        String roomPicture = (String) requestParam.get("roomPicture");
        Float roomPrice = Float.parseFloat((String)(requestParam.get("roomPrice")));
        Room roomModel = new Room();
        roomModel.setRoomType(roomType);
        roomModel.setRoomDescribe(roomDescribe);

        roomModel.setRoomPrice(roomPrice);
        roomModel.setRoomPicture(roomPicture);
        roomModel.setRoomID(roomID);
        Room select_Room = roomService.findByRoomID(roomID);
        /*这里检查是更新还是插入*/
        if(select_Room ==null) {
            String roomState = "未入住";
            roomModel.setRoomState(roomState);
            roomService.SaveOrUpdateRoom(roomModel);
            return new Result(400);
        }
        else {
            String roomState = select_Room.getRoomState();
            roomService.SaveOrUpdateRoom(roomModel);
            return new Result(400);
        }

    }
    }

