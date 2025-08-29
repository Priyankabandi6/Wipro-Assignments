package com.example.user.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doner {
	private Long id;
    private String name;
    private String bloodGroup;
    private String city;
    private String contactNumber;
}
