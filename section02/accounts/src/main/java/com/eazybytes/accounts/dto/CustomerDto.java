package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    @NotEmpty(message = "Name can not be a null or empty")
    @Schema(
            description = "Name of the customer", example = "Eazy Bytes"
    )
    private String name;

    @Email(message = "Invalid email address")
    @NotEmpty(message = "Email can not be a null or empty")
    @Schema(
            description = "Email address of the customer", example = "tutor@eazybytes.com"
    )
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;
}
