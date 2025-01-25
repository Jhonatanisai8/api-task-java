package com.isai.taskrestapi.model;

import com.isai.taskrestapi.model.enums.StatusTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task extends
        AuditModel {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    @NotBlank(message = "Por favor el campo tittle es obligatorio")
    @Length(min = 10, max = 100)
    private String tittle;

    @NotBlank(message = "Por favor el campo description es obligatorio")
    @Length(min = 10, max = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Por favor el campo status es obligatorio")
    private StatusTask status;

}
