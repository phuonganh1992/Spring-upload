package com.example.springbootupload.endpoint;

import com.example.springbootupload.dto.command.FoodCreateCommand;
import com.example.springbootupload.dto.view.FoodView;
import com.example.springbootupload.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/foods")
@RestController
//@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FoodEndpoint {
    private final FoodService foodService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FoodView> createFood(@RequestPart(value = "image", required = false) MultipartFile image,
                                               @RequestPart(value = "food", required = false) FoodCreateCommand command) {
        return new ResponseEntity<>(foodService.createFood(image, command), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/image-base64")
    public ResponseEntity<String> getImageBase64(@PathVariable("id") Long id) {
        return new ResponseEntity<>(foodService.getImageBase64(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<String> getImage(@PathVariable("id") Long id) {
        return new ResponseEntity<>(foodService.getImage(id), HttpStatus.OK);
    }
}
