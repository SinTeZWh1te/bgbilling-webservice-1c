package ru.test.bgbilling.service.bill.common.service;

import ru.test.bgbilling.service.bill.common.bean.Bill1CPayment;
import ru.bitel.bgbilling.common.BGMessageException;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

/**
 * @author sintezwh1te
 */
@WebService
public interface Bill1CService {
    List<Bill1CPayment> getPaymentList(Date date) throws BGMessageException;
}
