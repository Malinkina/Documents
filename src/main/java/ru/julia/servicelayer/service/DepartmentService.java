
package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.DepartmentResponseDTO;
import ru.julia.orm.jpamodel.DepartmentJPA;
import ru.julia.orm.jpamodel.OrganizationJPA;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.mapper.DepartmentMapper;
import ru.julia.servicelayer.model.DepartmentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DepartmentService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper mapper;

    public void create(DepartmentModel departmentModel) {
        UUID organizationId = departmentModel.getOrganizationId();
        OrganizationJPA organizationJPA = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException(
                        "Organization with id " + organizationId + " not found")
                );
        DepartmentJPA departmentJPA = mapper.modelToJpa(departmentModel);
        departmentJPA.setOrganization(organizationJPA);
        departmentRepository.save(departmentJPA);
    }

    public DepartmentResponseDTO read(UUID id) {
        Optional<DepartmentJPA> departmentJPA = departmentRepository.findById(id);
        return departmentJPA.map(departmentJpa -> mapper.jpaToResponseDto(departmentJpa))
                .orElseThrow(() -> new RuntimeException("Department with id " + id +" not found"));
    }

    public List<DepartmentResponseDTO> readAll() {
        List<DepartmentJPA> departmentsJPA = (List<DepartmentJPA>) departmentRepository.findAll();
        List<DepartmentResponseDTO> departmentResponseDTOS = new ArrayList<>();
        departmentsJPA.forEach(departmentJpa -> departmentResponseDTOS.add(mapper.jpaToResponseDto(departmentJpa)));
        return departmentResponseDTOS;
    }

    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }
}

