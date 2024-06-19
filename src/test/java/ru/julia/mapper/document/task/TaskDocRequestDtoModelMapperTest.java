package ru.julia.mapper.document.task;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.julia.controller.dto.request.TaskDocRequestDto;
import ru.julia.servicelayer.model.TaskDocModel;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskDocRequestDtoModelMapperTest {
    private static final TaskDocRequestDtoModelMapper MAPPER = Mappers.getMapper(TaskDocRequestDtoModelMapper.class);
    private static final String NAME = "Name";
    private static final String TEXT = "Text";
    private static final UUID AUTHOR_ID = UUID.fromString("392739e5-3d70-4805-b599-a7b78978fedd");
    private static final LocalDate EXECUTION_TERM = LocalDate.of(2024, 3, 31);
    private static final UUID RESPONSIBLE_EXECUTIVE_ID = UUID.fromString("0ebd76fc-62e0-4a64-8e55-808c71bb49fc");
    public static final Boolean CONTROL_MARK = true;
    public static final UUID CONTROLLER_ID = UUID.fromString("13687c80-a12f-4f97-b194-5b618bce6e17");

    @Test
    void toModel() {
        TaskDocRequestDto requestDto = new TaskDocRequestDto();
        requestDto.setName(NAME);
        requestDto.setText(TEXT);
        requestDto.setAuthorId(AUTHOR_ID);
        requestDto.setExecutionTerm(EXECUTION_TERM);
        requestDto.setResponsibleExecutiveId(RESPONSIBLE_EXECUTIVE_ID);
        requestDto.setControlMark(CONTROL_MARK);
        requestDto.setControllerId(CONTROLLER_ID);
        TaskDocModel model = MAPPER.toModel(requestDto);
        assertEquals(NAME, model.getName());
        assertEquals(TEXT, model.getText());
        assertEquals(AUTHOR_ID, model.getAuthorId());
        assertEquals(EXECUTION_TERM, model.getExecutionTerm());
        assertEquals(RESPONSIBLE_EXECUTIVE_ID, model.getResponsibleExecutiveId());
        assertEquals(CONTROL_MARK, model.getControlMark());
        assertEquals(CONTROLLER_ID, model.getControllerId());
    }
}