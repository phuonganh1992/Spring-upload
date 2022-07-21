package com.example.springbootupload.service;

import com.example.springbootupload.domain.Food;
import com.example.springbootupload.dto.command.FoodCreateCommand;
import com.example.springbootupload.dto.view.FoodView;
import com.example.springbootupload.repository.FoodRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodView createFood(MultipartFile file, FoodCreateCommand command) {
        Food food = Food.builder()
                .name(command.getName())
                .description(command.getDescription())
                .preparedTime(command.getPreparedTime())
                .price(command.getPrice())
                .createdAt(Instant.now())
                .build();
        String image=null;
        try {
                byte[] fileContent = file.getBytes();
                String outputFile = Base64.getEncoder().encodeToString(fileContent);
            String contentType = file.getContentType();
            image= "data:".concat(contentType).concat(";base64,").concat(outputFile);
        } catch (IOException e) {
           log.info("Error in file get bytes `{}`",file);
        }
        food.setImage(image);
        return FoodView.from(foodRepository.save(food));
    }

    public String getImageBase64(@NonNull Long id){
        Optional<Food> foodOptional = foodRepository.findById(id);
        Food food = foodOptional.get();
        return food.getImage();
    }

    public MultipartFile getImage(@NonNull Long id){
        Optional<Food> foodOptional = foodRepository.findById(id);
        Food food = foodOptional.get();
        MultipartFile file=new File()

        return food.getImage();
    }
}
