package com.example.assignment.service;

import com.example.assignment.model.BitcoinPriceIndex;
import com.example.assignment.model.Bitcoin;
import com.example.assignment.model.Time;
import com.example.assignment.repository.BitcoinRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BitcoinService {

    @Autowired
    private BitcoinRepository bitcoinRepository;

    public Bitcoin saveBitcoinPrices(String jsonData) throws JSONException, JsonProcessingException {
        JSONObject jsonObject = new JSONObject(jsonData);
        Bitcoin bitcoinPrice = new Bitcoin();

        bitcoinPrice.setTime(getTimeListFromJSON(jsonObject.getJSONObject("time")));
        bitcoinPrice.setDisclaimer(jsonObject.getString("disclaimer"));
        bitcoinPrice.setChartname(jsonObject.getString("chartName"));
        bitcoinPrice.setBitcoinPriceIndices(getBpiListFromJSON(jsonData));
        return bitcoinRepository.save(bitcoinPrice);
    }

    public List<Bitcoin> getDatafromDB()
    {
        return bitcoinRepository.findAll();
    }
    private Time getTimeListFromJSON(JSONObject jsonData) throws JSONException {
        Time time = new Time();
        time.setUpdated(jsonData.getString("updated"));
        time.setUpdateduk(jsonData.getString("updateduk"));
        time.setUpdatedISO(jsonData.getString("updatedISO"));
        return time;
    }
    private List<BitcoinPriceIndex> getBpiListFromJSON(String jsonData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonData);

        List<BitcoinPriceIndex> bitcoinPriceIndexList = new ArrayList<>();
        JsonNode bpiNode = root.get("bpi");
        for (Iterator<String> it = bpiNode.fieldNames(); it.hasNext(); ) {
            String currencyCode = it.next();
            JsonNode currencyNode = bpiNode.get(currencyCode);

            BitcoinPriceIndex bpi = new BitcoinPriceIndex();
            bpi.setCode(currencyNode.get("code").toString());
            bpi.setRate(currencyNode.get("rate").toString());
            bpi.setDescription(currencyNode.get("description").toString());
            bpi.setRateFloat(Float.parseFloat(currencyNode.get("rate_float").toString()));
            bpi.setSymbol(currencyNode.get("symbol").toString());
            bitcoinPriceIndexList.add(bpi);
        }
        return bitcoinPriceIndexList;
    }
}