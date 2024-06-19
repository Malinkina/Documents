package ru.julia.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public abstract class DocumentRequestDto {
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String name;
    @NotNull
    @Min(1)
    @Max(500)
    private String text;
    @NotNull
    private UUID authorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
