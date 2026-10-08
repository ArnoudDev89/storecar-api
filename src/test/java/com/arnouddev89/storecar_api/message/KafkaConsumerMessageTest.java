package com.arnouddev89.storecar_api.message;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import com.arnouddev89.storecar_api.service.CarPostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerMessageTest {

    @Mock
    private CarPostService carPostService;

    @InjectMocks
    private KafkaConsumerMessage kafkaConsumerMessage;

    @Test
    void deveChamarServiceAoReceberMensagem() {
        CarPostDTO dto = CarPostDTO.builder().model("Civic").brand("Honda").price(95000.0).build();
        doNothing().when(carPostService).newPostDetails(any(CarPostDTO.class));

        kafkaConsumerMessage.listening(dto);

        verify(carPostService).newPostDetails(any(CarPostDTO.class));
    }

    @Test
    void deveReceberMensagemComDtoCorreto() {
        CarPostDTO dto = CarPostDTO.builder().model("Corolla").brand("Toyota").build();
        doNothing().when(carPostService).newPostDetails(dto);

        kafkaConsumerMessage.listening(dto);

        verify(carPostService).newPostDetails(dto);
    }

    @Test
    void deveProcessarMensagemNulaSemErroDeChamada() {
        CarPostDTO dto = new CarPostDTO();
        doNothing().when(carPostService).newPostDetails(any(CarPostDTO.class));

        kafkaConsumerMessage.listening(dto);

        verify(carPostService).newPostDetails(dto);
    }
}
