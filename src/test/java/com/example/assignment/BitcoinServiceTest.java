package com.example.assignment;

import com.example.assignment.model.Bitcoin;
import com.example.assignment.model.BitcoinPriceIndex;
import com.example.assignment.model.Time;
import com.example.assignment.repository.BitcoinRepository;
import com.example.assignment.service.BitcoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BitcoinServiceTest {

    @Mock
    private BitcoinRepository bitcoinRepository = mock(BitcoinRepository.class);

    @InjectMocks
    private BitcoinService bitcoinService;

    private Bitcoin bitcoin;
    private Time time;
    private BitcoinPriceIndex bpi;

    @BeforeEach
    void startup()
    {
        bitcoin = new Bitcoin();
        bitcoin.setDisclaimer("Test data from startup");
        bitcoin.setChartname("bitcoin startup test");
        time = new Time();
        time.setUpdated("14-6-2024");
        time.setUpdateduk("15-6-2024");
        time.setUpdatedISO("16-4-2024");
        bitcoin.setTime(time);

    }

    @DisplayName("JUnit test for saveBitcoin method")
    @Test
    public void testSaveBitcoinPrices() throws JSONException, JsonProcessingException {
        String jsonRequest = "{\"time\":{\"updated\":\"Jun 13, 2024 05:33:22 UTC\",\"updatedISO\":\"2024-06-13T05:33:22+00:00\",\"updateduk\":\"Jun 13, 2024 at 06:33 BST\"},\"disclaimer\":\"This is test data.\",\"chartName\":\"Bitcoin-test\",\"bpi\":{\"PKR\":{\"code\":\"PKR\",\"symbol\":\"&#36;\",\"rate\":\"67,608.215\",\"description\":\"Pakistan Rupee\",\"rate_float\":67608.2152},\"INR\":{\"code\":\"INR\",\"symbol\":\"&pound;\",\"rate\":\"52,897.411\",\"description\":\"Indian Rupee\",\"rate_float\":52897.4113}}}}";
        given(bitcoinRepository.save(any())).willReturn(bitcoin);
        Bitcoin savedBitcoin = bitcoinService.saveBitcoinPrices(jsonRequest);
        assertThat(savedBitcoin).isNotNull();
    }

    @DisplayName("JUnit test for getDataFromDB method")
    @Test
    public void testGetDataFromDB()
    {
        Bitcoin bitcoin1 = bitcoin;
        given(bitcoinRepository.findAll()).willReturn(List.of(bitcoin,bitcoin1));
        List<Bitcoin> bitcoinList = bitcoinService.getDatafromDB();
        assertThat(bitcoinList).isNotNull();
        assertThat(bitcoinList.size()).isEqualTo(2);
    }
}
