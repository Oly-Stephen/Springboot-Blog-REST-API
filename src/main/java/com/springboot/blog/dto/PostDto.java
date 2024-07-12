package com.springboot.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(
        description = "PostDto Model Information"
)
public class PostDto {

    private Long id;

    // title should not be null or empty
    // title should have at least 2 characters
    @Schema(
            description = "Blog Post Title"
    )
    @NotEmpty
    @Size(min = 2, message = "Post titles should have at least 2 characters")
    private String title;

    // post description should not be null or empty
    // post description should have at least 10 characters
    @Schema(
            description = "Blog Post Description"
    )
    @NotEmpty
    @Size(max = 50, message = "Post description should have at least 10 characters")
    private String description;

    // post content should not be null or empty
    @Schema(
            description = "Blog Post content"
    )
    @NotEmpty
    private String content;
}
