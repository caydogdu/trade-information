package com.bank.trade.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.trade.dto.Trade;
import com.bank.trade.response.TradeResponse;
import com.bank.trade.service.ValidationServiceImpl;

/**
 *
 * @author caydogdu
 *
 *         This is a controller for rest services
 */
@Controller
public class TradeController {

    private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    private ValidationServiceImpl validationService;

    /**
     *
     * @param List<Trade> to validate trades
     * @return Response<List<Trade>>
     */
    @RequestMapping(value = "/trades", method = RequestMethod.POST)
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    public ResponseEntity<TradeResponse> validate(@RequestBody List<Trade> trades) {

        TradeResponse tradeResponse = new TradeResponse();
        ResponseEntity<TradeResponse> response = new ResponseEntity<>(tradeResponse, HttpStatus.OK);

        try {
            response.getBody().setSuccess(true);
            response.getBody().setResult(validationService.validateAll(trades));
        } catch (Exception e) {
            logger.error("error", e);
            response.getBody().setSuccess(false);
        }

        return response;
    }

}
