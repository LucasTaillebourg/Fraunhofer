package com.fraunhoferproject.commonservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("UUID service test")
@ExtendWith(MockitoExtension.class)
class UUIDServiceTest{
    private static final String UUID_KEY = "uuid";
    private static String UUID_TEST = "feec8a0c-a97d-46dc-abfd-286ae420bee5";


    @Mock private Environment env;

    private UUIDService uuidService;

    @Test
    @DisplayName("Should return the environement prediction")
    void should_return_the_environement_uuid(){
        when(env.getProperty(UUID_KEY)).thenReturn(UUID_TEST);

        uuidService = new UUIDService(env);

        UUID result = uuidService.generateUUID();

        assertThat(result).isEqualTo(UUID.fromString(UUID_TEST));
        verify(env, times(1)).getProperty(UUID_KEY);
    }

    @Test
    @DisplayName("Should return throw a IllegalArgumentException if the environement uuid return an incorrect uuid")
    void should_throw_a_illegal_argument_exception_if_env_return_an_incorrect_uuid(){
        when(env.getProperty(UUID_KEY)).thenReturn("chain");

        uuidService = new UUIDService(env);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            uuidService.generateUUID();
        });
    }

    @Test
    @DisplayName("Should return throw a NullPointerException if the environement uuid return null")
    void should_throw_a_null_pointer_exception_if_env_return_null(){
        when(env.getProperty(UUID_KEY)).thenReturn(null);

        uuidService = new UUIDService(env);

        Assertions.assertThrows(NullPointerException.class, () -> {
            uuidService.generateUUID();
        });
    }
}