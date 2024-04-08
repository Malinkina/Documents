package ru.julia.mapper.document.incoming;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.IncomingDocRequestDto;
import ru.julia.servicelayer.model.IncomingDocModel;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomingDocRequestDtoModelMapperTest {
    private static final IncomingDocRequestDtoModelMapper MAPPER = Mappers.getMapper(IncomingDocRequestDtoModelMapper.class);
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final UUID AUTHOR_ID = UUID.fromString("1403d3d8-bf8c-4f69-b986-844662bcc0dc");
    private static final UUID SENDER_ID = UUID.fromString("1403d3d8-bf8c-4f69-b986-844662bcc0dc");
    private static final UUID RECIPIENT_ID = UUID.fromString("7000d35f-2854-49e9-af9e-4c7836103239");
    @Test
    void toModel() {
        IncomingDocRequestDto requestDto = new IncomingDocRequestDto();
        requestDto.setName(NAME);
        requestDto.setText(TEXT);
        requestDto.setAuthorId(AUTHOR_ID);
        requestDto.setSenderId(SENDER_ID);
        requestDto.setRecipientId(RECIPIENT_ID);
        IncomingDocModel model = MAPPER.toModel(requestDto);
        assertEquals(NAME, model.getName());
        assertEquals(TEXT, model.getText());
        assertEquals(AUTHOR_ID, model.getAuthorId());
        assertEquals(SENDER_ID, model.getSenderId());
        assertEquals(RECIPIENT_ID, model.getRecipientId());
    }
}