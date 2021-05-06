package com.fbiankevin.player.playerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name name is required")
    private String lastName;
    private Integer level;
    private Long experience;
    @NotNull(message = "Please create an account first.")
    private Long accountId;


    public String getFullName(){
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }
}
