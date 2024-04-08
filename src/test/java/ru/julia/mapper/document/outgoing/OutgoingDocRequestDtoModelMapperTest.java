package ru.julia.mapper.document.outgoing;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.OutgoingDocRequestDto;
import ru.julia.servicelayer.model.OutgoingDocModel;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutgoingDocRequestDtoModelMapperTest {
    private static final OutgoingDocRequestDtoModelMapper MAPPER = Mappers.getMapper(OutgoingDocRequestDtoModelMapper.class);
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final UUID AUTHOR_ID = UUID.fromString("392739e5-3d70-4805-b599-a7b78978fedd");
    private static final UUID RECIPIENT_ID = UUID.fromString("efe5a2c7-cfbc-41b7-95a7-5227414616c9");
    private static final String DELIVERY_TYPE = "deliveryType";

    @Test
    void toModel() {
        OutgoingDocRequestDto requestDto = new OutgoingDocRequestDto();
        requestDto.setName(NAME);
        requestDto.setText(TEXT);
        requestDto.setAuthorId(AUTHOR_ID);
        requestDto.setRecipientId(RECIPIENT_ID);
        requestDto.setDeliveryType(DELIVERY_TYPE);
        OutgoingDocModel model = MAPPER.toModel(requestDto);
        assertEquals(NAME, model.getName());
        assertEquals(TEXT, model.getText());
        assertEquals(AUTHOR_ID, model.getAuthorId());
        assertEquals(RECIPIENT_ID, model.getRecipientId());
        assertEquals(DELIVERY_TYPE, model.getDeliveryType());
    }
}